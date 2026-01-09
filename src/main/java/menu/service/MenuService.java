package menu.service;

import java.util.List;
import menu.domain.Coach;
import menu.repository.MenuRepository;

public class MenuService {

    private final MenuRepository menuRepository = new MenuRepository();

    public List<String> getAllMenus() {
        return menuRepository.getAllMenus();
    }

    public void addNoMenus(Coach coach, List<String> menus) {
        for (String menu : menus) {
            coach.addNoMenus(menu);
        }
    }
}
