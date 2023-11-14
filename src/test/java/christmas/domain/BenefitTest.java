package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
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
    @MethodSource("방문날짜와_할인결과_설정하기")
    void 할인_금액을_올바르게_계산한다(VisitDate 방문날짜, String 포함되는할인, String 포함되지않는할인) {
        // given
        Order 주문 = 주문_생성하기();

        // when
        Benefit 할인혜택 = new Benefit(방문날짜, 주문);

        // then
        List<String> 응답 = 할인혜택.convertToResponse().getMessage();
        assertThat(응답)
            .contains(포함되는할인)
            .doesNotContain(포함되지않는할인);
    }

    static Stream<Arguments> 방문날짜와_할인결과_설정하기() {
        return Stream.of(
            Arguments.arguments(new VisitDate(16), "주말 할인: -6,069원", "평일 할인"),
            Arguments.arguments(new VisitDate(26), "평일 할인: -4,046원", "크리스마스 디데이 할인"),
            Arguments.arguments(new VisitDate(24), "크리스마스 디데이 할인: -3,300원", "특별 할인"),
            Arguments.arguments(new VisitDate(17), "특별 할인: -1,000원", "주말 할인")
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

    @DisplayName("총 주문 금액이 10,000원을 넘지 않으면 혜택이 적용되지 않는다.")
    @Test
    void 총주문금액에따라_혜택이_적용되지않는다() {
        // given
        Order 주문 = new Order(Map.of("타파스", 1,"제로콜라", 1));
        VisitDate 방문날짜 = new VisitDate(3);

        // when
        Benefit 혜택 = new Benefit(방문날짜, 주문);

        // then
        List<String> 응답 = 혜택.convertToResponse().getMessage();
        assertThat(응답)
            .hasSize(1)
            .contains("없음");
    }
}