package christmas.domain;

import static christmas.constants.ErrorMessage.INVALID_DISCOUNT_INSTANCE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountTest {
    @DisplayName("잘못된 할인 계산 메서드를 부르면 예외가 발생한다.")
    @Test
    void 잘못된_메서드_호출시_예외가_발생한다() {
        // given
        Discount 할인 = Discount.CHRISTMAS;

        // when & then
        assertThatThrownBy(() -> {
            할인.calculateWeekDiscount(new Order(Map.of("타파스", 2)));
        }).isInstanceOf(IllegalStateException.class)
            .hasMessage(INVALID_DISCOUNT_INSTANCE);
    }

    @DisplayName("올바르게 인스턴스 메서드를 호출한다.")
    @Test
    void 올바르게_인스턴스_메서드를_호출한다() {
        // given
        Discount 할인 = Discount.WEEKDAY;

        // when & then
        assertDoesNotThrow(() -> {
            할인.calculateWeekDiscount(new Order(Map.of("타파스", 2)));
        });
    }
}