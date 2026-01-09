package menu.controller;

import java.util.List;
import menu.dto.ResultHeader;
import menu.service.MenuService;
import menu.util.Parser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void start() {
        List<String> coachNames = readCoach();

        for (String coachName : coachNames) {
            readHateMenu(coachName);
        }

        ResultHeader result = menuService.startLottery();

        outputView.printResult(result);

    }

    private void readHateMenu(String coachName) {
        while (true) {
            try {
                String rawHateMenu = inputView.readHateMenu(coachName);
                List<String> hateMenu = Parser.parseHateFoods(rawHateMenu);
                menuService.addHateMenu(coachName, hateMenu);
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
                return menuService.createCoaches(coachNames);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
