package menu.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import menu.message.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachNameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "       ", " "})
    void 공백만_입력된_경우라면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            CoachNameValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.BLANK_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"코치,", "코", "코치,이름이다섯글자초과", "이름,나랑드사이다,포비"})
    void 코치의_이름이_2글자_미만_4글자_초과라면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            CoachNameValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.COACH_NAME_LENGTH_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"포비", "포비쓰"})
    void 코치가_2명_미만이라면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            CoachNameValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.COACH_COUNT_UNDER_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"포비,포비2,포비3,포비4,포비5,포비6"})
    void 코치가_5명_초과라면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            CoachNameValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.COACH_COUNT_OVER_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"포비,포비"})
    void 코치_이름이_중복되면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            CoachNameValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.COACH_NAME_DUPLICATED_ERROR_MESSAGE.getMessage());
    }
}