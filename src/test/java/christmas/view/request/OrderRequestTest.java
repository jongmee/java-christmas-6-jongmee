package christmas.view.request;

import static christmas.constants.ErrorMessage.INVALID_ORDER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.view.request.OrderRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderRequestTest {
    @DisplayName("주문을 입력할 때 양옆 공백은 무시된다.")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-2, 레드와인-1", " 해산물파스타-2 , 레드와인-1 ", "해산물파스타 - 2, 레드와인 - 1"})
    void 양옆공백은_주문_입력에서_무시한다(String 입력) {
        // when & then
        assertDoesNotThrow(() -> {
            new OrderRequest(입력);
        });
    }

    @DisplayName("주문을 입력할 때 메뉴 개수가 정수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-일,레드와인-1", "해산물파스타-1,레드와인-two"})
    void 주문개수가_정수가_아니면_예외가_발생한다(String 입력) {
        // when & then
        assertThatThrownBy(() -> {
            new OrderRequest(입력);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_ORDER);
    }

    @DisplayName("주문을 입력할 때 -를 하나씩 사용하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타 1개,레드와인 1개", "해산물파스타-1-1,레드와인-2"})
    void 잘못된_형식의_주문은_예외가_발생한다(String 입력) {
        // when & then
        assertThatThrownBy(() -> {
            new OrderRequest(입력);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_ORDER);
    }

    @DisplayName("메뉴를 중복해서 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-1,레드와인-1,해산물파스타-2", "레드와인-1,레드와인-1"})
    void 중복된_메뉴는_예외가_발생한다(String 입력) {
        // when & then
        assertThatThrownBy(() -> {
            new OrderRequest(입력);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_ORDER);
    }
}