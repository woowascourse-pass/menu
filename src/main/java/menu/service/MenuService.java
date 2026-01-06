package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.message.ErrorMessage;

public class MenuService {

    List<Coach> coaches = new ArrayList<>();

    public void createCoaches(List<String> coachNames) {
        validateCoachesNumber(coachNames);
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName));
        }
    }

    private void validateCoachesNumber(List<String> coachNames) {
        int size = coachNames.size();
        if (size < 2 || 5 < size) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
