package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";

    private static final String RECOMMEND_RESULT_MESSAGE = "\n메뉴 추천 결과입니다.";
    private static final String DAY_OF_WEEK_LIST = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_PREFIX = "[ 카테고리 | ";
    private static final String RECOMMEND_FINISH_MESSAGE = "\n추천을 완료했습니다.";

    private static final String MENU_LINK = "| ";
    private static final String MENU_SUFFIX = "]";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printRecommendedResult(List<Category> categories, List<Coach> coaches) {
        printRecommendedResultMessage();
        for (int i = 0; i < categories.size(); i++) {
            System.out.printf("%s ", categories.get(i).getName());
            if (i + 1 == categories.size()) {
                System.out.println(MENU_SUFFIX);
                break;
            }
            System.out.print(MENU_LINK);
        }
        for (Coach coach : coaches) {
            System.out.println(coach.format());
        }
        System.out.println(RECOMMEND_FINISH_MESSAGE);
    }

    private void printRecommendedResultMessage() {
        System.out.println(RECOMMEND_RESULT_MESSAGE);
        System.out.println(DAY_OF_WEEK_LIST);
        System.out.print(CATEGORY_PREFIX);
    }
}
