package christmas.domain;

import static christmas.constants.ErrorMessage.BEVERAGE_ONLY_ERROR;
import static christmas.constants.ErrorMessage.INVALID_ORDER;
import static christmas.constants.ErrorMessage.MAX_ORDER_LIMIT_EXCEEDED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    @DisplayName("없는 메뉴를 주문하면 예외가 발생한다.")
    @Test
    void 없는메뉴를_주문하면_예외가_발생한다() {
        // given
        Map<String, Integer> 주문 = Map.of("양송이수프", 1, "김치볶음밥", 2);

        // when & then
        assertThatThrownBy(() -> {
            new Order(주문);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_ORDER);
    }

    @DisplayName("메뉴가 20개를 초과하면 예외가 발생한다.")
    @Test
    void 메뉴가_20개를_초과하면_예외가_발생한다() {
        // given
        Map<String, Integer> 주문 = Map.of("양송이수프", 19, "시저샐러드", 2);

        // when & then
        assertThatThrownBy(() -> {
            new Order(주문);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MAX_ORDER_LIMIT_EXCEEDED);
    }

    @DisplayName("음료만 주문하면 예외가 발생한다.")
    @Test
    void 음료만_주문하면_예외가_발생한다() {
        // given
        Map<String, Integer> 주문 = Map.of("제로콜라", 1, "레드와인", 2);

        // when & then
        assertThatThrownBy(() -> {
            new Order(주문);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(BEVERAGE_ONLY_ERROR);
    }

    @DisplayName("총 주문 금액을 바르게 계산한다.")
    @Test
    void 총_주문_금액을_계산한다() {
        // given
        Map<String, Integer> 주문요청 = Map.of("제로콜라", 1, "양송이수프", 2, "해산물파스타", 4);
        Order 주문 = new Order(주문요청);

        // when
        int 총_주문_금액 = 주문.calculateTotalPrice();

        // then
        assertEquals(3_000*1 + 6_000*2 + 35_000*4, 총_주문_금액);
    }
}