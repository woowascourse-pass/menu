package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.dto.RecommendMenuResult;
import menu.dto.ResultHeader;
import menu.message.ErrorMessage;

public class Coaches {
    private final List<Coach> coaches = new ArrayList<>();
    private final List<Category> weekCategories = new ArrayList<>();

    public List<String> createCoaches(List<String> coachNames) {
        validateCoachesNumber(coachNames);
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName));
        }
        return List.copyOf(coachNames);
    }

    private void validateCoachesNumber(List<String> coachNames) {
        int size = coachNames.size();
        if (size < 2 || 5 < size) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public void addHateMenu(String coachName, List<String> hateMenu) {
        Coach coach = findByCoachName(coachName);
        coach.clearHateFood();
        coach.addHateFood(hateMenu);
    }

    private Coach findByCoachName(String coachName) {
        return coaches.stream().filter(coach -> coach.equalsName(coachName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.COACH_NOT_FOUND.getMessage()));
    }

    // 무작위 뽑기
    public ResultHeader startLottery() {

        for (int day = 0; day < 5; day++) {
            Category category = randomCategory();
            weekCategories.add(category);
            recommendRandomMenu(category);
        }

        return getResultHeader();
    }

    private ResultHeader getResultHeader() {
        List<RecommendMenuResult> menuResults = new ArrayList<>();

        for (Coach coach : coaches) {
            menuResults.add(coach.makeResult());
        }

        List<String> categoryResults = weekCategories.stream().map(Category::getName).toList();

        return new ResultHeader(categoryResults, menuResults);
    }

    private void recommendRandomMenu(Category category) {
        for (Coach coach : coaches) {
            Food food = randomFood(coach, category);
            coach.eatFood(food);
        }
    }

    private Category randomCategory() {
        while (true) {
            Category category = Category.get(Randoms.pickNumberInRange(1, 5));
            if (checkAvailable(category)) {
                return category;
            }
        }
    }

    // 이용 불가하면 false 반환
    private boolean checkAvailable(Category category) {
        // 이용 가능한지 봐야됨.
        int count = (int) weekCategories.stream()
                .filter(eachCategory -> eachCategory.equals(category))
                .count();

        return count < 2;
    }

    private Food randomFood(Coach coach, Category category) {
        while (true) {
            List<String> menu = Food.getFoodByCategory(category);
            String foodName = Randoms.shuffle(menu).get(0);

            if (coach.checkFoodUnavailable(foodName)) {
                continue;
            }

            return Food.searchFood(foodName);
        }
    }
}
