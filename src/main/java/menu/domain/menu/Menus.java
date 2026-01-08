package menu.domain.menu;

import java.util.List;

import static menu.view.OutputView.PREFIX_ERROR;

public class Menus {
    private final List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public Menu findByName(String name) {
        for (Menu menu : menus) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }

        throw new IllegalArgumentException(PREFIX_ERROR + name + "은 없는 메뉴");
    }
}
