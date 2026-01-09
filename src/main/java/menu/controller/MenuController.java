package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.util.Parser;
import menu.validator.CoachNameValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.printStartMessage();
        List<Coach> coaches = inputCoachNames();
    }

    private List<Coach> inputCoachNames() {
        String input = inputView.inputCoach();
        CoachNameValidator.validate(input);
        List<String> names = Parser.parseInput(input, ",");
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            coaches.add(new Coach(name));
        }
        return coaches;
    }
}
