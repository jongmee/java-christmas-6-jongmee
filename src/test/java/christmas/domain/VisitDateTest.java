package christmas.domain;

import static christmas.constants.ErrorMessage.INVALID_DATE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}