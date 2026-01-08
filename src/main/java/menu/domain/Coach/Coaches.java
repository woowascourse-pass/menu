package menu.domain.Coach;

import java.util.List;

public record Coaches(
        List<Coach> coaches
) {

    public int size() {
        return coaches.size();
    }
}
