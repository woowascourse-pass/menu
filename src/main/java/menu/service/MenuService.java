package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.dto.RecommendMenuResult;
import menu.dto.ResultHeader;

public class MenuService {

    private Coaches coaches;

    public List<String> createCoaches(List<String> coachNames) {

        List<Coach> coaches = coachNames.stream()
                .map(Coach::new)
                .toList();

        this.coaches = new Coaches(coaches);

        return List.copyOf(coachNames);
    }

    public void addHateMenu(String coachName, List<String> hateMenu) {
        coaches.addHateMenu(coachName, hateMenu);
    }

    public ResultHeader startLottery() {
        for (int day = 0; day < 5; day++) {
            Category category = randomCategory();
            coaches.addWeekCategories(category);
            recommendRandomMenu(category);
        }

        return getResultHeader();
    }

    private ResultHeader getResultHeader() {

        List<Coach> allCoaches = coaches.findAll();

        List<RecommendMenuResult> menuResults = allCoaches.stream().map((coach) ->
            new RecommendMenuResult(coach.getName(), coach.makeResult())
        ).toList();

        List<String> categoryResults = coaches.getWeekCategories();

        return new ResultHeader(categoryResults, menuResults);
    }

    private void recommendRandomMenu(Category category) {
        coaches.recommendRandomMenu(category);
    }

    private Category randomCategory() {
        while (true) {
            Category category = Category.get(Randoms.pickNumberInRange(1, 5));
            if (coaches.checkAvailable(category)) {
                return category;
            }
        }
    }
}
