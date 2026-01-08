package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.dto.request.CoachNamesRequest;
import menu.util.Parser;

import java.util.List;

public class InputView {

    public CoachNamesRequest readCoachNames() {
        System.out.println();
        System.out.print("코치의 이름을 입력해 주세요. (, 로 구분)");
        String raw = Console.readLine().trim();
        validateBlank(raw);

        List<String> tokens = Parser.parseByDelimiter(raw);

        return new CoachNamesRequest(tokens);
    }

    public List<String> readAllergy(String name) {
        System.out.println();
        System.out.print(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String raw = Console.readLine().trim();
        validateBlank(raw);

        List<String> tokens = Parser.parseByDelimiter(raw);

        return tokens;
    }

    private void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력이 비었어요.");
        }
    }
}
