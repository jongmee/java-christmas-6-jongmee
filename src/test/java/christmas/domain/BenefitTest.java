package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BenefitTest {
    @DisplayName("할인 금액을 올바르게 계산한다.")
    @ParameterizedTest
    @MethodSource("할인종목과_방문날짜_설정하기")
    void 할인_금액을_올바르게_계산한다(Discount 할인종목, VisitDate 방문날짜, Integer 할인금액) {
        // given
        Order 주문 = 주문_생성하기();

        // when
        Benefit 할인혜택 = new Benefit(방문날짜, 주문);

        // then
        assertEquals(할인금액, 할인혜택.getDiscounts().get(할인종목));
    }

    static Stream<Arguments> 할인종목과_방문날짜_설정하기() {
        return Stream.of(
            Arguments.arguments(Discount.WEEKEND, new VisitDate(16), 6_069),
            Arguments.arguments(Discount.WEEKDAY, new VisitDate(26), 4_046),
            Arguments.arguments(Discount.CHRISTMAS, new VisitDate(24), 3_300),
            Arguments.arguments(Discount.CHRISTMAS, new VisitDate(28), null),
            Arguments.arguments(Discount.SPECIAL, new VisitDate(17), 1_000)
        );
    }

    @DisplayName("총 혜택 금액을 계산한다.")
    @Test
    void 총_혜택_금액을_계산한다() {
        // given
        Order 주문 = 주문_생성하기();
        VisitDate 방문날짜 = new VisitDate(3);
        Benefit 할인혜택 = new Benefit(방문날짜, 주문);

        // when
        int 총혜택금액 = 할인혜택.calculateTotalAmount();

        // then
        assertEquals(31_246, 총혜택금액);
    }

    private static Order 주문_생성하기() {
        return new Order(Map.of("티본스테이크", 1, "바비큐립", 2, "초코케이크", 2, "제로콜라", 1));
    }
}