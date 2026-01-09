package menu.domain;

import static menu.domain.Category.*;

import java.util.Arrays;
import java.util.List;
import menu.message.ErrorMessage;

public enum Food {
    GYUDON("규동", JAPANESE),
    UDON("우동", JAPANESE),
    MISO_SIRU("미소시루", JAPANESE),
    SUSHI("스시", JAPANESE),
    KATSU_DONG("가츠동", JAPANESE),
    ONIGIRI("오니기리", JAPANESE),
    HIGH_RICE("하이라이스", JAPANESE),
    RAMEN("라멘", JAPANESE),
    OKONOMIYAKI("오코노미야끼", JAPANESE),

    GIMBAP("김밥", KOREAN),
    KIMCHI_STEW("김치찌개", KOREAN),
    SSAMBAP("쌈밥", KOREAN),
    SOYBEAN_PASTE_STEW("된장찌개", KOREAN),
    BIBIMBAP("비빔밥", KOREAN),
    KALGUKSU("칼국수", KOREAN),
    BULGOGI("불고기", KOREAN),
    TTEOKBOKKI("떡볶이", KOREAN),
    STIR_FRIED_SPICY_PORK("제육볶음", KOREAN),

    KKANPUNGGI("깐풍기", CHINESE),
    STIR_FRIED_NOODLES("볶음면", CHINESE),
    DONGPAE_MEAT("동파육", CHINESE),
    JAJANGMYEON("짜장면", CHINESE),
    JJAMPPONG("짬뽕", CHINESE),
    MAPA_TOFU("마파두부", CHINESE),
    SWEET_AND_SOUR_PORK("탕수육", CHINESE),
    TOMATO_STIR_FRIED_EGGS("토마토 달걀볶음", CHINESE),
    RED_PEPPER_JAPCHAE("고추잡채", CHINESE),

    PAD_THAI("팟타이", ASIAN),
    KAO_PAD("카오 팟", ASIAN),
    NASI_GORENG("나시고렝", ASIAN),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", ASIAN),
    PHO("쌀국수", ASIAN),
    TOM_YUM_KUNG("똠얌꿍", ASIAN),
    BANH_MI("반미", ASIAN),
    VIETNAMESE_SPRING_ROLLS("월남쌈", ASIAN),
    BUNCHA("분짜", ASIAN),

    LASAGNA("라자냐", WESTERN),
    GRATIN("그라탱", WESTERN),
    GNOCCHI("뇨끼", WESTERN),
    QUICHE("끼슈", WESTERN),
    FRENCH_TOAST("프렌치 토스트", WESTERN),
    BAGUETTE("바게트", WESTERN),
    SPAGHETTI("스파게티", WESTERN),
    PIZZA("피자", WESTERN),
    PANINI("파니니", WESTERN);

    private final String name;
    private final Category category;

    Food(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static Food searchFood(String foodName) {
        return Arrays.stream(values())
                .filter(food -> food.name.equals(foodName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.FOOD_NOT_FOUND.getMessage()));
    }

    public static List<String> getFoodByCategory(Category category) {
        return Arrays.stream(values())
                .filter(food -> food.category.equals(category))
                .map(food -> food.name)
                .toList();
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }
}
