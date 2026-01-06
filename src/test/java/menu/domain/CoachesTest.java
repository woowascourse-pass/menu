package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CoachesTest {

    Coaches coaches = new Coaches();

    @DisplayName("예외 경우")
    @Nested
    class Failure {

        static Stream<Arguments> generateNumberOutOfRangeData() {
            return Stream.of(
                    Arguments.of(List.of("토미")),
                    Arguments.of(List.of("토미1", "토미2", "토미3", "토미4", "토미5", "토미6"))
            );
        }

        static Stream<Arguments> generateLengthOutOfRangeData() {
            return Stream.of(
                    Arguments.of(List.of("토", "미미")),
                    Arguments.of(List.of("토미미미미", "토미2"))
            );
        }

        @DisplayName("코치가 2명 미만, 5명 초과인 경우")
        @ParameterizedTest
        @MethodSource("generateNumberOutOfRangeData")
        public void 코치_미달_및_초과_테스트(List<String> data) {
            //given
            //when
            //then
            assertThatThrownBy(() -> coaches.createCoaches(data))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 코치는 최소 2명이상 5명 이하만 가능합니다.");
        }

        @DisplayName("코치 이름이 2글자 미만, 4글자 초과")
        @ParameterizedTest
        @MethodSource("generateLengthOutOfRangeData")
        public void 코치_이름_미만_및_초과_테스트(List<String> data) {
            //given
            //when
            //then
            assertThatThrownBy(() -> coaches.createCoaches(data))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 이름의 길이는 2글자 이상 4글자 이하여야 합니다.");
        }

        @DisplayName("코치 이름이 중복된 경우")
        @Test
        public void 코치_이름_중복_테스트() {
            //given
            //when
            //then
            assertThatThrownBy(() -> coaches.createCoaches(List.of("토미", "제임스", "토미")))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 코치 이름은 중복될 수 없습니다.");
        }
    }

    @DisplayName("성공")
    @Nested
    class Success {

        @DisplayName("코치 인원 정상일 경우")
        @Test
        public void 코치_정상_생성_테스트() {
            //given
            List<String> coachNames = coaches.createCoaches(List.of("토미", "제임스", "포코"));
            //when
            //then
            Assertions.assertThat(coachNames).containsExactly("토미", "제임스", "포코");
        }
    }

}