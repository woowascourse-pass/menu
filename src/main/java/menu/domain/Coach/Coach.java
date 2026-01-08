package menu.domain.Coach;

import java.util.List;

public record Coach(
        String name,
        List<String> allergyMenuNames
) {

    public boolean isEat(String menuName) {
        return !allergyMenuNames.contains(menuName);
    }
}
