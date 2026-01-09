package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.service.MenuService;
import menu.util.Parser;
import menu.validator.CoachNameValidator;
import menu.validator.NoFoodsValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final MenuService menuService = new MenuService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.printStartMessage();
        List<Coach> coaches = inputCoachNames();
        inputNoMenusAllCoaches(coaches);
    }

    private List<Coach> inputCoachNames() {
        while (true) {
            try {
                String input = inputView.inputCoach();
                CoachNameValidator.validate(input);
                List<String> names = Parser.parseInput(input, ",");
                return convertCoach(names);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Coach> convertCoach(List<String> names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            coaches.add(new Coach(name));
        }
        return coaches;
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
                NoFoodsValidator.validate(input, menuService.getAllMenus());
                return Parser.parseInput(input, ",");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
