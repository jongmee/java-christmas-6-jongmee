package christmas.view.response;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Discount;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BenefitResponseTest {
    @DisplayName("올바른 형식으로 혜택 내역 출력 메세지를 생성한다.")
    @ParameterizedTest
    @MethodSource("혜택내역_설정하기")
    void 올바른형식으로_출력메세지를_생성한다(Map<Discount, Integer> 할인내역, int 증정품가격합, List<String> 출력결과, int 출력개수) {
        // when
        BenefitResponse 응답객체 = new BenefitResponse(할인내역, 증정품가격합);
        List<String> 출력메세지 = 응답객체.getMessage();

        // then
        assertThat(출력메세지).hasSize(출력개수)
            .containsAll(출력결과);
    }

    static Stream<Arguments> 혜택내역_설정하기() {
        return Stream.of(
            Arguments.arguments(
                Map.of(Discount.CHRISTMAS, 1_200, Discount.WEEKDAY, 2_023), 2_5000,
                List.of("크리스마스 디데이 할인: -1,200원", "평일 할인: -2,023원", "증정 이벤트: -25,000원"), 3),
            Arguments.arguments(
                Map.of(), 0,
                List.of("없음"), 1)
        );
    }
}