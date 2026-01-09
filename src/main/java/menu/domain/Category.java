package menu.domain;

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
        if (categoryId == 1) {
            return JAPANESE;
        }
        if (categoryId == 2) {
            return KOREAN;
        }
        if (categoryId == 3) {
            return CHINESE;
        }
        if (categoryId == 4) {
            return ASIAN;
        }
        if (categoryId == 5) {
            return WESTERN;
        }
        return null;
    }
}
