package menu.dto;

import java.util.List;

public record ResultHeader(List<String> categoryName, List<RecommendMenuResult> eachOne) {
}
