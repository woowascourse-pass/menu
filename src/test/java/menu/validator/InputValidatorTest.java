package menu.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private static final String MESSAGE = "error";

    @Nested
    class RequireNotBlankTest {

        @Test
        void 공백만_입력되면_예외를_발생시킨다() {
            // when & then
            assertThatThrownBy(() -> InputValidator.requireNotBlank("   ", MESSAGE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MESSAGE);
        }

        @Test
        void 공백이_아니면_예외를_발생시키지_않는다() {
            // when & then
            InputValidator.requireNotBlank("a", MESSAGE);
        }
    }

    @Nested
    class RequireDigitsTest {

        @Test
        void 숫자가_아닌_문자가_포함되면_예외를_발생시킨다() {
            // when & then
            assertThatThrownBy(() -> InputValidator.requireDigits("12a", MESSAGE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MESSAGE);
        }

        @Test
        void 숫자만_입력되면_예외를_발생시키지_않는다() {
            // when & then
            InputValidator.requireDigits("0123", MESSAGE);
            InputValidator.requireDigits("", MESSAGE);
        }
    }

    @Nested
    class ParseIntOrThrowTest {

        @Test
        void 숫자로_파싱할_수_없으면_예외를_발생시킨다() {
            // when & then
            assertThatThrownBy(() -> InputValidator.parseIntOrThrow("12a", MESSAGE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MESSAGE);
        }

        @Test
        void 숫자로_파싱한다() {
            // when
            int result = InputValidator.parseIntOrThrow("42", MESSAGE);

            // then
            assertThat(result).isEqualTo(42);
        }
    }

    @Nested
    class RequireNotDuplicateTest {

        @Test
        void 중복이_있으면_예외를_발생시킨다() {
            // when & then
            assertThatThrownBy(
                () -> InputValidator.requireNotDuplicate(List.of("a", "b", "a"), MESSAGE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MESSAGE);
        }

        @Test
        void 중복이_없으면_예외를_발생시키지_않는다() {
            // when & then
            InputValidator.requireNotDuplicate(List.of("a", "b", "c"), MESSAGE);
        }
    }
}