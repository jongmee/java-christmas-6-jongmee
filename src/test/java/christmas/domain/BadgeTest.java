package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BadgeTest {
    @DisplayName("총 혜택 금액으로 이벤트 배지를 정한다.")
    @ParameterizedTest
    @MethodSource("혜택금액과_이벤트배지_설정하기")
    void 총_혜택_금액으로_이벤트_배지를_정한다(int 혜택금액, Badge 예상된_배지) {
        // when
        Badge 배지 = Badge.findByTotalBenefitAmount(혜택금액);

        // then
        assertEquals(예상된_배지, 배지);
    }

    static Stream<Arguments> 혜택금액과_이벤트배지_설정하기() {
        return Stream.of(
            Arguments.arguments(4_046, Badge.NONE),
            Arguments.arguments(5_600, Badge.STAR),
            Arguments.arguments(16_000, Badge.TREE),
            Arguments.arguments(50_000, Badge.SANTA)
        );
    }
}