package menu.validator;

import java.util.List;
import menu.message.ErrorMessage;
import menu.util.Parser;

public class CoachNameValidator {

    public static void validate(String input) {
        InputValidator.requireNotBlank(input, ErrorMessage.BLANK_ERROR_MESSAGE.getMessage());
        List<String> inputs = Parser.parseInput(input, ",");
        for (String name : inputs) {
            validateCoachName(name);
        }
        InputValidator.requireNotDuplicate(inputs,
            ErrorMessage.COACH_NAME_DUPLICATED_ERROR_MESSAGE.getMessage());
        validateCoachCount(inputs);
    }

    private static void validateCoachName(String name) {
        if (!(2 <= name.length() && name.length() <= 4)) {
            throw new IllegalArgumentException(
                ErrorMessage.COACH_NAME_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateCoachCount(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(
                ErrorMessage.COACH_COUNT_UNDER_ERROR_MESSAGE.getMessage());
        }
        if (5 < names.size()) {
            throw new IllegalArgumentException(
                ErrorMessage.COACH_COUNT_OVER_ERROR_MESSAGE.getMessage());
        }
    }

}
