package menu.dto.request;

import java.util.List;

import static menu.view.OutputView.PREFIX_ERROR;

public record CoachNamesRequest(
        List<String> coachNames
) {
    public CoachNamesRequest {
        if (coachNames.size() < 2) {
            throw new IllegalArgumentException(PREFIX_ERROR + "코치는 2명 이상 입력해야 합니다.");
        }

        if (coachNames.size() > 5) {
            throw new IllegalArgumentException(PREFIX_ERROR + "코치는 5명 이하 입력해야 합니다.");
        }

        for (String coachName : coachNames) {
            if (coachName.length() < 2) {
                throw new IllegalArgumentException(PREFIX_ERROR + "코치 이름은 최소 2글자 입니다.");
            }

            if (coachName.length() > 4) {
                throw new IllegalArgumentException(PREFIX_ERROR + "코치 이름은 최대 4글자 입니다.");
            }
        }
    }
}
