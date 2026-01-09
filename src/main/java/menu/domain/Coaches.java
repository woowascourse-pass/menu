package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.message.ErrorMessage;

public class Coaches {
    private final List<Coach> coaches;
    private final List<Category> weekCategories = new ArrayList<>();

    public Coaches(List<Coach> coaches) {
        validateCoachesNumber(coaches);
        validateDuplicateName(coaches);
        this.coaches = new ArrayList<>(coaches);
    }

    private void validateDuplicateName(List<Coach> coaches) {
        long distinctCount = coaches.stream()
                .map(Coach::getName)
                .distinct()
                .count();

        if (distinctCount != coaches.size()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_DUPLICATE.getMessage());
        }
    }

    private void validateCoachesNumber(List<Coach> coaches) {
        int size = coaches.size();
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

    public void recommendRandomMenu(Category category) {
        for (Coach coach : coaches) {
            Food food = randomFood(coach, category);
            coach.eatFood(food);
        }
    }

    // 이용 불가하면 false 반환
    public boolean checkAvailable(Category category) {
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

    public void addWeekCategories(Category category) {
        weekCategories.add(category);
    }

    public List<Coach> findAll() {
        return List.copyOf(coaches);
    }

    public List<String> getWeekCategories() {
        return weekCategories.stream().map(Category::getName).toList();
    }
}
