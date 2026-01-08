package menu.config;


import menu.controller.MenuController;
import menu.repository.MenuRepository;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {

    public MenuController menuController() {
        return new MenuController(inputView(), outputView(), oncallService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private MenuService oncallService() {
        return new MenuService(menuRepository());
    }

    private MenuRepository menuRepository() {
        return new MenuRepository();
    }
}