package menu.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Nested
    class ParseInputTest {

        @Test
        void 구분자로_입력을_분리한다() {
            // given
            String input = "a,b,";
            String delimiter = ",";

            // when
            List<String> result = Parser.parseInput(input, delimiter);

            // then
            assertThat(result).containsExactly("a", "b", "");
        }

        @Test
        void 빈_입력도_분리_결과를_반환한다() {
            // given
            String input = "";
            String delimiter = ",";

            // when
            List<String> result = Parser.parseInput(input, delimiter);

            // then
            assertThat(result).containsExactly("");
        }
    }

    @Nested
    class RemoveAllSpacesTest {

        @Test
        void 모든_공백을_제거한다() {
            // given
            String input = " a\tb\nc ";

            // when
            String result = Parser.removeAllSpaces(input);

            // then
            assertThat(result).isEqualTo("abc");
        }
    }
}