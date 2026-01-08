package menu.dto.response;

import menu.domain.menu.Categories;

import java.util.List;

public record RecommendationResultResponse (
        Categories categories,
        List<CoachResponse> coachResponses
){
}
