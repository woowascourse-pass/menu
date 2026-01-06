package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.message.ErrorMessage;

public class Coach {

    private final String name;
    private final List<Food> hateFoods = new ArrayList<>();

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    public boolean equalsName(String name) {
        return this.name.equals(name);
    }

    private void validateName(String name) {
        if (name.length() < 2 || 4 < name.length()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_OUT_OF_RANGE.getMessage());
        }
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

    private void validateHateFood(List<String> hateFoodNames) {
        if (hateFoodNames.size() > 3) {
            throw new IllegalArgumentException(ErrorMessage.HATE_FOOD_OUT_OF_RANGE.getMessage());
        }
    }

    public void clearHateFood() {
        hateFoods.clear();
    }
}
