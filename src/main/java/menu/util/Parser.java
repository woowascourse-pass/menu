package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<String> parseCoaches(String coaches) {
        return Arrays.stream(coaches.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
