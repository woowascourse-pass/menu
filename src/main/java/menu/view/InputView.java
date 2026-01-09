package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Parser;

public class InputView {

    private static final String INPUT_COACH_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_NO_MENUS_MESSAGE = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public String inputCoach() {
        System.out.println(INPUT_COACH_MESSAGE);
        return Parser.removeAllSpaces(Console.readLine());
    }

    public String inputNoMenus(String name) {
        System.out.printf(INPUT_NO_MENUS_MESSAGE, name);
        return Console.readLine();
    }
}
