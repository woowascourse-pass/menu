package menu.dto.request;

import java.util.List;

import static menu.view.OutputView.PREFIX_ERROR;

public record AllergyMenuNamesRequest (
        List<String> allergyMenuNames
) {
    public AllergyMenuNamesRequest {
        if (allergyMenuNames.size() > 2) {
            throw new IllegalArgumentException(PREFIX_ERROR + "못 먹는 메뉴는 최대 2개 입니다.");
        }
    }
}
