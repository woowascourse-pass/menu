package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.validator.CoachNameValidator;

public class Coach {

    private final String name;
    private final List<String> noMenus;
    private final List<String> menus;

    public Coach(String name) {
        CoachNameValidator.validateCoachName(name);
        this.name = name;
        this.noMenus = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addNoMenu(String menu) {
        noMenus.add(menu);
    }

    public void addMenu(String menu) {
        if (!canEat(menu)) {
            return;
        }
        menus.add(menu);
    }

    public boolean canEat(String menu) {
        return !noMenus.contains(menu) && !menus.contains(menu);
    }

    public String format() {
        if (menus.size() != 5) {
            return String.format("[ %s | 메뉴가 유효하지 않습니다. ]", name);
        }
        return String.format("[ %s | %s | %s | %s | %s | %s ]", name, menus.get(0), menus.get(1),
            menus.get(2), menus.get(3), menus.get(4));
    }
}
