package menu.config;

import menu.controller.MenuController;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {
    public MenuController menuController() {
        return new MenuController(inputView(), outputView(), menuService());
    }

    public MenuService menuService() {
        return new MenuService();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
