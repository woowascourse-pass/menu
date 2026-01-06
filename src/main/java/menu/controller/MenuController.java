package menu.controller;

import java.util.List;
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
        readCoach();
    }

    private void readCoach() {
        while(true) {
            try {
                String rawCoaches = inputView.readCoach();
                List<String> coachNames = Parser.parseCoaches(rawCoaches);
                menuService.createCoaches(coachNames);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
