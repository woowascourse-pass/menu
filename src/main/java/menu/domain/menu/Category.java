package menu.domain.menu;

import static menu.view.OutputView.PREFIX_ERROR;

public enum Category {
    Japan("일식"),
    Korean("한식"),
    China("중식"),
    Asia("아시안"),
    Western("양식"),
    ;

    private static final Category[] ENUMS = Category.values();
    private final String korean;

    Category(String korean) {
        this.korean = korean;
    }

    public static Category of(int index) {
        if (index < 1 || index > 5) {
            throw new IllegalArgumentException("[ERROR] Invalid value for Category: " + index);
        }
        return ENUMS[index - 1];
    }

    public static Category fromKorean(String value) {
        String trimmed = value.trim();
        for (Category category : ENUMS) {
            if (category.korean.equals(trimmed)) {
                return category;
            }
        }
        throw new IllegalArgumentException(PREFIX_ERROR + "Invalid value for Category: " + value);
    }

    public String toKorean() {
        return korean;
    }

    public boolean equals(Category category) {
        return category == this;
    }
}