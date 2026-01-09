package menu.controller;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.service.MenuService;
import menu.util.Parser;
import menu.validator.CoachNameValidator;
import menu.validator.NoMenusValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService, InputView inputView, OutputView outputView) {
        this.menuService = menuService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private final InputView inputView;
    private final OutputView outputView;

    public void start() {
        outputView.printStartMessage();
        List<Coach> coaches = inputCoachNames();
        inputNoMenusAllCoaches(coaches);
        List<Category> categories = menuService.recommendMenus(coaches);
        outputView.printRecommendedResult(categories, coaches);
    }

    private List<Coach> inputCoachNames() {
        while (true) {
            try {
                String input = inputView.inputCoach();
                CoachNameValidator.validate(input);
                List<String> names = Parser.parseInput(input, ",");
                return menuService.convertCoach(names);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void inputNoMenusAllCoaches(List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<String> noMenus = inputNoFoods(coach);
            menuService.addNoMenus(coach, noMenus);
        }
    }

    private List<String> inputNoFoods(Coach coach) {
        while (true) {
            try {
                String input = inputView.inputNoFoods(coach.getName());
                NoMenusValidator.validate(input, menuService.getAllMenus());
                return Parser.parseInput(input, ",");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
