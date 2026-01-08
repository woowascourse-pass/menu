package menu.domain.Coach;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> allergyMenuNames;

    public Coach(String name, List<String> allergyMenuNames) {
        this.name = name;
        this.allergyMenuNames = allergyMenuNames;
    }
}
