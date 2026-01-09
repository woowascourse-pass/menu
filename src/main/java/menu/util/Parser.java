package menu.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<String> parseInput(String input, String delimiter) {
        String[] inputs = input.split(delimiter, -1);
        List<String> newInputs = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            newInputs.add(inputs[i].trim());
        }
        return newInputs;
    }

    public static String removeAllSpaces(String input) {
        return input.replaceAll("\\s", "");
    }
}
