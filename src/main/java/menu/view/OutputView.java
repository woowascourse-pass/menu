package menu.view;

import menu.domain.menu.Categories;
import menu.domain.menu.Category;
import menu.dto.response.CoachResponse;
import menu.dto.response.RecommendationResultResponse;

import java.util.List;

public class OutputView {
    public static final String PREFIX_ERROR = "[ERROR]";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printGuide() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printResult(RecommendationResultResponse result) {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        printHead();
        printCategory(result.categories());
        printRecommendedMenu(result.coachResponses());
    }

    private void printRecommendedMenu(List<CoachResponse> coachResponses) {
        for (CoachResponse coachResponse : coachResponses) {
            StringBuilder sb = new StringBuilder("[ ");
            sb.append(coachResponse.name());
            for (String recommendedMenuName : coachResponse.recommendedMenuNames()) {
                sb.append(" | ").append(recommendedMenuName);
            }
            sb.append(" ]");
            System.out.println(sb);
        }
    }

    private void printCategory(Categories categories) {
        StringBuilder sb = new StringBuilder("[ 카테고리");
        for (Category category: categories.getCategories()) {
            sb.append(" | ").append(category.name());
        }
        sb.append(" ]");
        System.out.println(sb);
    }

    private void printHead() {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }
}
