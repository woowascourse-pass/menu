package menu.config;

import menu.controller.MenuController;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {
    public MenuController menuController() {
        return new MenuController(inputView(), outputView());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
