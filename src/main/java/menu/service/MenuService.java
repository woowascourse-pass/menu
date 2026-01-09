package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;
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


    public List<Category> recommendMenus(List<Coach> coaches) {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < 5) {
            Category pickedCategory = pickCategory();
            if (isPossible(categories, pickedCategory)) {
                categories.add(pickedCategory);
            }
            for (Coach coach : coaches) {
                while (true) {
                    String menu = recommendMenu(pickedCategory);
                    if (coach.canEat(menu)) {
                        coach.addMenus(menu);
                        break;
                    }
                }
            }
        }
        return categories;
    }

    private Category pickCategory() {
        int categoryId = Randoms.pickNumberInRange(1, 5);
        return Category.of(categoryId);
    }

    private String recommendMenu(Category category) {
        return Randoms.shuffle(menuRepository.find(category.getId())).get(0);
    }

    private boolean isPossible(List<Category> categories, Category category) {
        return Collections.frequency(categories, category) < 2;
    }
}
