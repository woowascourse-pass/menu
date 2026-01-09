package menu.validator;

import java.util.List;
import menu.message.ErrorMessage;
import menu.util.Parser;

public class NoMenusValidator {

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
