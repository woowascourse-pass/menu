package menu.controller;

import java.util.List;
import menu.domain.Coaches;
import menu.dto.ResultHeader;
import menu.util.Parser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Coaches coaches = new Coaches();

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<String> coachNames = readCoach();

        for (String coachName : coachNames) {
            readHateMenu(coachName);
        }

        ResultHeader result = coaches.startLottery();

        outputView.printResult(result);

    }

    private void readHateMenu(String coachName) {
        while (true) {
            try {
                String rawHateMenu = inputView.readHateMenu(coachName);
                List<String> hateMenu = Parser.parseHateFoods(rawHateMenu);
                coaches.addHateMenu(coachName, hateMenu);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<String> readCoach() {
        while(true) {
            try {
                String rawCoaches = inputView.readCoach();
                List<String> coachNames = Parser.parseCoaches(rawCoaches);
                return coaches.createCoaches(coachNames);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
