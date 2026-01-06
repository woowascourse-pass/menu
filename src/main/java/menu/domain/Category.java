package menu.domain;

import java.util.Arrays;
import menu.message.ErrorMessage;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5),;

    private final String name;
    private final int number;

    Category(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static Category get(int categoryNumber) {
        return Arrays.stream(values())
                .filter(category -> category.number == categoryNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.CATEGORY_NOT_FOUND.getMessage()));
    }

    public String getName() {
        return name;
    }
}
