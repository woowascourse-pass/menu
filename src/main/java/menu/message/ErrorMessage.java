package menu.message;

public enum ErrorMessage {
    COACH_NAME_OUT_OF_RANGE("[ERROR] 이름의 길이는 2글자 이상 4글자 이하여야 합니다."),
    COACH_NUMBER_OUT_OF_RANGE("[ERROR] 코치는 최소 2명이상 5명 이하만 가능합니다."),
    HATE_FOOD_OUT_OF_RANGE("[ERROR] 못 먹는 음식은 0개 ~ 2개까지만 선택 가능합니다."),
    FOOD_NOT_FOUND("[ERROR] 존재하지 않는 음식입니다."),
    COACH_NOT_FOUND("[ERROR] 존재하지 않는 코치입니다."),
    CATEGORY_NOT_FOUND("[ERROR] 존재하지 않는 카테고리입니다."),
    ;

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getMessage() {
        return description;
    }
}
