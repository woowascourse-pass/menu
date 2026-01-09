package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.constant.RandomConstant;
import menu.domain.Category;
import menu.domain.Coach;
import menu.repository.MenuRepository;

public class MenuService {

    private static final int NO_MENUS_MAX = 2;
    private static final int WEEK_LENGTH = 5;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    private final MenuRepository menuRepository;

    public List<String> getAllMenus() {
        return menuRepository.getAllMenus();
    }

    public void addNoMenus(Coach coach, List<String> menus) {
        for (String menu : menus) {
            coach.addNoMenu(menu);
        }
    }

    public List<Coach> convertCoach(List<String> names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            coaches.add(new Coach(name));
        }
        return coaches;
    }

    public List<Category> recommendMenus(List<Coach> coaches) {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < WEEK_LENGTH) {
            Category pickedCategory = pickCategory();
            if (isPossible(categories, pickedCategory)) {
                categories.add(pickedCategory);
            }
            recommendCoaches(pickedCategory, coaches);
        }
        return categories;
    }

    private Category pickCategory() {
        int categoryId = Randoms.pickNumberInRange(RandomConstant.MIN_VALUE,
            RandomConstant.MAX_VALUE);
        return Category.of(categoryId);
    }

    private String recommendMenu(Category category) {
        return Randoms.shuffle(menuRepository.find(category.getId()))
            .get(RandomConstant.PICK_INDEX);
    }

    private boolean isPossible(List<Category> categories, Category category) {
        return Collections.frequency(categories, category) < NO_MENUS_MAX;
    }

    private void recommendCoaches(Category category, List<Coach> coaches) {
        for (Coach coach : coaches) {
            recommendCoach(category, coach);
        }
    }

    private void recommendCoach(Category category, Coach coach) {
        while (true) {
            String menu = recommendMenu(category);
            if (coach.canEat(menu)) {
                coach.addMenu(menu);
                return;
            }
        }
    }
}
