package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.dto.RecommendMenuResult;
import menu.dto.ResultHeader;

public class OutputView {

    private static final String LOTTERY_RESULT = "메뉴 추천 결과입니다.";
    private static final String WEEK_DAYS = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY = "카테고리";
    private static final String COMPLETE_LOTTERY = "추천을 완료했습니다.";

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public void printResult(ResultHeader result) {
        System.out.println();
        System.out.println(LOTTERY_RESULT);
        System.out.println(WEEK_DAYS);

        System.out.println(printEachLine(CATEGORY, result.categoryName()));

        printEachCoachMenu(result.eachOne());

        System.out.println();
        System.out.println(COMPLETE_LOTTERY);
    }

    private void printEachCoachMenu(List<RecommendMenuResult> menuResults) {
        for (RecommendMenuResult menuResult : menuResults) {
            System.out.println(printEachLine(menuResult.coachName(), menuResult.foodNames()));
        }
    }

    private String printEachLine(String beginning, List<String> list) {
        return "[ " + beginning + " | " + list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" | ", "", " ]"));
    }
}
