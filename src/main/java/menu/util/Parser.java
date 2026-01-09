package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<String> parseCoaches(String rawCoachesName) {
        return Arrays.stream(rawCoachesName.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> parseHateFoods(String rawHateFood) {
        if (rawHateFood == null || rawHateFood.isEmpty()) {
            return List.of();
        }
        return Arrays.stream(rawHateFood.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
