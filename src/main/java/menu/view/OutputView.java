package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRecommendedResult(List<Category> categories, List<Coach> coaches) {
        printRecommendedResultMessage();
        for (int i = 0; i < categories.size(); i++) {
            System.out.printf("%s ", categories.get(i).getName());
            if (i + 1 == categories.size()) {
                System.out.print("]");
                break;
            }
            System.out.println("| ");
        }
        for (Coach coach : coaches) {
            System.out.println(coach.format());
        }
        System.out.println("\n추천을 완료했습니다.");
    }

    private void printRecommendedResultMessage() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.print("[ 카테고리 | ");
    }
}
