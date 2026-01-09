package menu.message;

public enum ErrorMessage {
    // 공통
    BLANK_ERROR_MESSAGE("공백만 입력되었습니다."),
    INVALID_INPUT_ERROR_MESSAGE("유효하지 않은 입력값입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        String prefix = "[ERROR] ";
        return prefix + message;
    }
}