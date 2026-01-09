package menu.domain;

import java.util.List;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int id;
    private final String name;

    Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Category of(int categoryId) {
        if (!(1 <= categoryId && categoryId <= 5)) {
            return null;
        }
        List<Category> categories = List.of(JAPANESE, KOREAN, CHINESE, ASIAN, WESTERN);
        return categories.get(categoryId - 1);
    }
}
