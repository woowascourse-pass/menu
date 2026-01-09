package menu.validator;

import java.util.List;
import java.util.Map;
import menu.message.ErrorMessage;
import menu.util.Parser;

public class NoFoodsValidator {

    public static void validate(String input, List<String> allMenus) {
        if (input.isEmpty()) {
            return;
        }
        List<String> menus = Parser.parseInput(input, ",");
        for (String menu : menus) {
            InputValidator.requireNotBlank(menu,
                ErrorMessage.NO_FOOD_NOT_FOUND_ERROR_MESSAGE.getMessage());
            isExistedMenu(menu, allMenus);
        }
        InputValidator.requireNotDuplicate(menus,
            ErrorMessage.NO_FOOD_DUPLICATED_ERROR_MESSAGE.getMessage());
        isRuleOk(menus);
    }

    private static void isExistedMenu(String menu, List<String> allMenus) {
        Map<String, String> convert = Map.of(
            "토마토달걀볶음", "토마토 달걀볶음",
            "카오팟", "카오 팟",
            "파인애플볶음밥", "파인애플 볶음밥",
            "프렌치토스트", "프렌치 토스트"
        );
        menu = convert.getOrDefault(menu, menu);
        if (!allMenus.contains(menu)) {
            throw new IllegalArgumentException(
                ErrorMessage.NO_FOOD_NOT_FOUND_ERROR_MESSAGE.getMessage());
        }
    }

    private static void isRuleOk(List<String> menus) {
        if (2 < menus.size()) {
            throw new IllegalArgumentException(ErrorMessage.NO_FOOD_OVER_ERROR_MESSAGE
                .getMessage());
        }
    }
}
