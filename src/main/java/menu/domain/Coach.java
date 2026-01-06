package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.dto.RecommendMenuResult;
import menu.message.ErrorMessage;

public class Coach {

    private final String name;
    private final List<Food> hateFoods = new ArrayList<>();
    private final List<Food> alreadyEat = new ArrayList<>();

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    public void clearHateFood() {
        hateFoods.clear();
    }

    public boolean equalsName(String name) {
        return this.name.equals(name);
    }

    public void addHateFood(List<String> hateFoodNames) {

        if (hateFoodNames.isEmpty()) {
            return;
        }

        validateHateFood(hateFoodNames);

        for (String hateFoodName : hateFoodNames) {
            Food food = Food.searchFood(hateFoodName);
            hateFoods.add(food);
        }
    }

    public void eatFood(Food food) {
        alreadyEat.add(food);
    }

    private void validateName(String name) {
        if (name.length() < 2 || 4 < name.length()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateHateFood(List<String> hateFoodNames) {
        if (hateFoodNames.size() > 2) {
            throw new IllegalArgumentException(ErrorMessage.HATE_FOOD_OUT_OF_RANGE.getMessage());
        }
    }

    public boolean checkFoodUnavailable(String foodName) {
        Food food = Food.searchFood(foodName);

        if (hateFoods.contains(food)) {
            return true;
        }

        if (alreadyEat.contains(food)) {
            return true;
        }

        return false;
    }

    public RecommendMenuResult makeResult() {
        List<String> foodNames = alreadyEat.stream().map(Food::getName)
                .toList();

        return new RecommendMenuResult(name, foodNames);
    }
}
