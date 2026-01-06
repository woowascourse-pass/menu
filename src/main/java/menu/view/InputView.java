package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String START_MENU = "점심 메뉴 추천을 시작합니다.";
    private static final String GET_COACH = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String GET_HATE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String readCoach() {
        System.out.println(START_MENU);
        System.out.println();
        System.out.println(GET_COACH);
        return Console.readLine();
    }

    public String readHateMenu(String name) {
        System.out.println();
        System.out.printf(GET_HATE_MENU + "\n", name);
        return Console.readLine();
    }
}
