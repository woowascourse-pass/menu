package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach.Coach;
import menu.domain.Coach.Coaches;
import menu.domain.menu.Categories;
import menu.domain.menu.Category;
import menu.domain.menu.Menu;
import menu.domain.menu.Menus;
import menu.dto.response.CoachResponse;
import menu.dto.response.RecommendationResultResponse;
import menu.repository.MenuRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuService {
    private final Menus menus;

    public MenuService(MenuRepository menuRepository) {
        this.menus = new Menus(menuRepository.findAll());
    }

    public RecommendationResultResponse recommendation(Coaches coaches) {
        // 월~금 카테고리 정하기
        Categories categories = randomCategory();

        List<String> menuNames = new ArrayList<>();
        for (Menu menu : menus.getMenus()){
            menuNames.add(menu.getName());
        }
        // 코치 별 메뉴 추천
        List<CoachResponse> coachResponses = recommendationEachCoach(coaches, menuNames, categories);


        return new RecommendationResultResponse(
                categories,
                coachResponses
        );
    }

    private List<CoachResponse> recommendationEachCoach(Coaches coaches, List<String> menuNames, Categories categories) {
        List<CoachResponse> coachResponses = new ArrayList<>();
        // 코치 순회
        for (Coach coach : coaches.coaches()) {
            List<String> recommendedMenuNames = recommendedMenuNames(menuNames, coach, categories);
            coachResponses.add(
                    new CoachResponse(
                            coach.name(),
                            recommendedMenuNames
                    )
            );
        } return coachResponses;
    }

    private List<String> recommendedMenuNames(List<String> menuNames, Coach coach, Categories categories) {
        List<String> recommendedMenuNames = new ArrayList<>();
        for (Category category: categories.getCategories()) {
            String menuName = recommendationMenu(menuNames, coach, recommendedMenuNames, category);
            recommendedMenuNames.add(menuName);
        }
        return recommendedMenuNames;
    }

    private String recommendationMenu(List<String> menuNames, Coach coach, List<String> recommendedMenuNames, Category category) {
        while (true){
            String menuName = Randoms.shuffle(menuNames).get(0);
            Menu menu = menus.findByName(menuName);
            if (!category.equals(menu.getCategory())) {
                continue;
            }

            if (recommendedMenuNames.contains(menuName)){
                continue;
            }

            if (coach.isEat(menuName)) {
                return menuName;
            }
        }
    }

    private Categories randomCategory() {
        while (true) {
            List<Category> categories = pickCategories();
            if (isSatisfy(categories)) {
                return new Categories(categories);
            }
        }
    }

    private List<Category> pickCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Category category = Category.of(Randoms.pickNumberInRange(1, 5));
            categories.add(category);
        }
        return categories;
    }

    private boolean isSatisfy(List<Category> categories) {
        Map<Category, Integer> frequencyCategories = new HashMap<>();

        for (Category category : categories) {
            frequencyCategories.put(category, frequencyCategories.getOrDefault(category, 0) + 1);
        }

        for (Map.Entry<Category, Integer> entry : frequencyCategories.entrySet()) {
            if (frequencyCategories.get(entry.getKey()) > 2) {
                return false;
            }
        }

        return true;
    }
}