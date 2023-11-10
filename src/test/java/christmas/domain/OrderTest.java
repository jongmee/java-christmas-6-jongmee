package christmas.domain;

import static christmas.constants.ErrorMessage.INVALID_ORDER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
}