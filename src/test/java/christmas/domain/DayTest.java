package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DayTest {
    @DisplayName("해당 요일이 주말인지 판단한다.")
    @ParameterizedTest
    @MethodSource("요일과_판단결과_설정하기")
    void 해당_요일이_주말인지_판단한다(Day 요일, boolean 판단결과) {
        // when
        boolean 판단 = 요일.isWeekend();

        // then
        assertEquals(판단결과, 판단);
    }

    static Stream<Arguments> 요일과_판단결과_설정하기() {
        return Stream.of(
            Arguments.arguments(Day.MONDAY, false),
            Arguments.arguments(Day.TUESDAY, false),
            Arguments.arguments(Day.WEDNESDAY, false),
            Arguments.arguments(Day.THURSDAY, false),
            Arguments.arguments(Day.FRIDAY, true),
            Arguments.arguments(Day.SATURDAY, true),
            Arguments.arguments(Day.SUNDAY, false)
        );
    }
}