package menu.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import menu.message.ErrorMessage;
import menu.service.MenuService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NoMenusValidatorTest {

    private final MenuService menuService = new MenuService();

    @ParameterizedTest
    @ValueSource(strings = {"토마토달걀볶음", "교동", "라면", "선풍기, 동파육", "뇨끼,토스투"})
    void 존재하지_않는_메뉴를_입력하면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            NoMenusValidator.validate(input, menuService.getAllMenus());
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.NO_FOOD_NOT_FOUND_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"규동, 우동, 스시", "규동, 마파두부, 탕수육, 토마토 달걀볶음"})
    void 메뉴의_수가_2개를_초과하면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            NoMenusValidator.validate(input, menuService.getAllMenus());
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.NO_FOOD_OVER_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"규동,규동", "스시,스시"})
    void 메뉴가_중복되면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            NoMenusValidator.validate(input, menuService.getAllMenus());
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.NO_FOOD_DUPLICATED_ERROR_MESSAGE.getMessage());
    }
}