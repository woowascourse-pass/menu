package menu.config;

import menu.controller.MenuController;
import menu.repository.MenuRepository;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {

    public MenuController MenuController() {
        return new MenuController(menuService(), inputView(), outputView());
    }

    public MenuService menuService() {
        return new MenuService(menuRepository());
    }

    public MenuRepository menuRepository() {
        return new MenuRepository();
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
