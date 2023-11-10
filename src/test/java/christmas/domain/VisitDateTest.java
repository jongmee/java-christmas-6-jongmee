package christmas.domain;

import static christmas.constants.ErrorMessage.INVALID_DATE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateTest {
    @DisplayName("방문 날짜를 입력할 때 1일과 31일 사이가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 32, -1})
    void 유효하지않은_날짜를_입력하면_예외가_발생한다(int 입력) {
        // when & then
        assertThatThrownBy(() -> {
            new VisitDate(입력);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_DATE);
    }

    @DisplayName("방문 날짜로 요일을 구한다.")
    @ParameterizedTest
    @MethodSource("비교할_두개의_로또번호_설정")
    void 방문날짜로_요일을_구한다(int 날짜, Day 요일) {
        // when
        VisitDate 방문날짜 = new VisitDate(날짜);

        // then
        assertEquals(요일, 방문날짜.calculateDay());
    }

    static Stream<Arguments> 비교할_두개의_로또번호_설정() {
        return Stream.of(
            Arguments.arguments(11, Day.MONDAY),
            Arguments.arguments(19, Day.TUESDAY),
            Arguments.arguments(6, Day.WEDNESDAY),
            Arguments.arguments(28, Day.THURSDAY),
            Arguments.arguments(1, Day.FRIDAY),
            Arguments.arguments(9, Day.SATURDAY),
            Arguments.arguments(31, Day.SUNDAY)
        );
    }
}