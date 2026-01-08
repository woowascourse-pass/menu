package menu.dto.response;

import java.util.List;

public record CoachResponse (
        String name,
        List<String> recommendedMenuNames
){
}
