package menu.message;

public enum ErrorMessage {
    // 공통
    BLANK_ERROR_MESSAGE("공백만 입력되었습니다."),
    INVALID_INPUT_ERROR_MESSAGE("유효하지 않은 입력값입니다."),

    // 코치 이름
    COACH_NAME_LENGTH_ERROR_MESSAGE("코치 이름은 2글자 이상 4글자 이하만 가능합니다."),
    COACH_COUNT_UNDER_ERROR_MESSAGE("코치는 최소 2명 이상 입력해야 합니다."),
    COACH_COUNT_OVER_ERROR_MESSAGE("코치는 최대 5명 이하 입니다."),
    COACH_NAME_DUPLICATED_ERROR_MESSAGE("코치 이름이 중복 되었습니다."),

    // 못먹는 메뉴
    NO_FOOD_NOT_FOUND_ERROR_MESSAGE("존재하지 않는 메뉴가 입력되었습니다."),
    NO_FOOD_OVER_ERROR_MESSAGE("못 먹는 메뉴의 수는 최대 2개 입니다."),
    NO_FOOD_DUPLICATED_ERROR_MESSAGE("못 먹는 메뉴가 중복 되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        String prefix = "[ERROR] ";
        return prefix + message;
    }
}