package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> noMenus;
    private final List<String> menus;

    public Coach(String name) {
        this.name = name;
        this.noMenus = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addNoMenus(String menu) {
        noMenus.add(menu);
    }

    public void addMenus(String menu) {
        menus.add(menu);
    }

    public boolean canEat(String menu) {
        return !noMenus.contains(menu) && !menus.contains(menu);
    }

    public String format() {
        return String.format("[ %s | %s | %s | %s | %s | %s ]", name, menus.get(0), menus.get(1),
            menus.get(2), menus.get(3), menus.get(4));
    }
}
