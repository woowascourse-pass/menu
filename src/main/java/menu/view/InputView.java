package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.dto.request.AllergyMenuNamesRequest;
import menu.dto.request.CoachNamesRequest;
import menu.util.Parser;

import java.util.List;

import static menu.view.OutputView.PREFIX_ERROR;

public class InputView {

    public CoachNamesRequest readCoachNames() {
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String raw = Console.readLine().trim();
        validateBlank(raw);

        List<String> tokens = Parser.parseByDelimiter(raw);

        return new CoachNamesRequest(tokens);
    }

    public AllergyMenuNamesRequest readAllergy(String name) {
        System.out.println();
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String raw = Console.readLine().trim();
        validateBlank(raw);

        List<String> tokens = Parser.parseByDelimiter(raw);

        return new AllergyMenuNamesRequest(tokens);
    }

    private void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(PREFIX_ERROR + "입력이 비었어요.");
        }
    }
}
