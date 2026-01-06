package menu.domain;

import menu.message.ErrorMessage;

public class Coach {

    private final String name;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < 2 || 4 < name.length()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_OUT_OF_RANGE.getMessage());
        }
    }
}
