package christmas.view.request;

import static christmas.constants.ErrorMessage.INVALID_DATE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.view.request.VisitDateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateRequestTest {
    @DisplayName("방문 날짜를 입력할 때 정수가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "이십오일"})
    void 정수가아닌_날짜를_입력하면_예외가_발생한다(String 입력) {
        // when & then
        assertThatThrownBy(() -> {
            new VisitDateRequest(입력);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_DATE);
    }

    @DisplayName("방문 날짜를 입력할 때 양옆 공백은 무시된다.")
    @ParameterizedTest
    @ValueSource(strings = {" 1 ", "18 ", " 5"})
    void 양옆공백은_입력에서_무시한다(String 입력) {
        // when & then
        assertDoesNotThrow(() -> {
            new VisitDateRequest(입력);
        });
    }
}