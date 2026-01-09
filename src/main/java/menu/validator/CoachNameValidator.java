package menu.validator;

import java.util.List;
import menu.constant.MenuConstant;
import menu.message.ErrorMessage;
import menu.util.Parser;

public class CoachNameValidator {

    private static final int COACH_NAME_MIN_LENGTH = 2;
    private static final int COACH_NAME_MAX_LENGTH = 4;
    private static final int COACH_MIN_COUNT = 2;
    private static final int COACH_MAX_COUNT = 5;


    public static void validate(String input) {
        InputValidator.requireNotBlank(input, ErrorMessage.BLANK_ERROR_MESSAGE.getMessage());
        List<String> inputs = Parser.parseInput(input, MenuConstant.DELIMITER);
        for (String name : inputs) {
            validateCoachName(name);
        }
        InputValidator.requireNotDuplicate(inputs,
            ErrorMessage.COACH_NAME_DUPLICATED_ERROR_MESSAGE.getMessage());
        validateCoachCount(inputs);
    }

    public static void validateCoachName(String name) {
        if (!(COACH_NAME_MIN_LENGTH <= name.length() && name.length() <= COACH_NAME_MAX_LENGTH)) {
            throw new IllegalArgumentException(
                ErrorMessage.COACH_NAME_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateCoachCount(List<String> names) {
        if (names.size() < COACH_MIN_COUNT) {
            throw new IllegalArgumentException(
                ErrorMessage.COACH_COUNT_UNDER_ERROR_MESSAGE.getMessage());
        }
        if (COACH_MAX_COUNT < names.size()) {
            throw new IllegalArgumentException(
                ErrorMessage.COACH_COUNT_OVER_ERROR_MESSAGE.getMessage());
        }
    }

}
