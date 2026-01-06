package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.message.ErrorMessage;

public class Coaches {
    private final List<Coach> coaches = new ArrayList<>();

    public List<String> createCoaches(List<String> coachNames) {
        validateCoachesNumber(coachNames);
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName));
        }
        return List.copyOf(coachNames);
    }

    private void validateCoachesNumber(List<String> coachNames) {
        int size = coachNames.size();
        if (size < 2 || 5 < size) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public void addHateMenu(String coachName, List<String> hateMenu) {
        Coach coach = findByCoachName(coachName);
        coach.clearHateFood();
        coach.addHateFood(hateMenu);
    }

    private Coach findByCoachName(String coachName) {
        return coaches.stream().filter(coach -> coach.equalsName(coachName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.COACH_NOT_FOUND.getMessage()));
    }
}
