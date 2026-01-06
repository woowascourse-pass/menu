package menu.message;

public enum ErrorMessage {
    COACH_NAME_OUT_OF_RANGE("[ERROR] 이름의 길이는 2글자 이상 4글자 이하여야 합니다."),
    COACH_NUMBER_OUT_OF_RANGE("[ERROR] 코치는 최소 2명이상 5명 이하만 가능합니다."),
    ;

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getMessage() {
        return description;
    }
}
