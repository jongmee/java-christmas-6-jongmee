package christmas.domain;

import static christmas.constants.ErrorMessage.INVALID_DISCOUNT_INSTANCE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @DisplayName("주말 할인과 주중 할인 금액을 계산한다.")
    @ParameterizedTest
    @MethodSource("주문과_할인종목_설정하기")
    void 주말과_주중_할인_금액을_계산한다(Order 주문, Discount 할인종목, int 할인금액) {
        // when
        Map<Discount, Integer> 할인계산결과 = 할인종목.calculateWeekDiscount(주문);

        // then
        assertEquals(할인금액, 할인계산결과.get(할인종목));
    }

    static Stream<Arguments> 주문과_할인종목_설정하기() {
        return Stream.of(
            Arguments.arguments(주문_생성하기(), Discount.WEEKEND, 6_069),
            Arguments.arguments(주문_생성하기(), Discount.WEEKDAY, 4_046)
        );
    }

    private static Order 주문_생성하기() {
        return new Order(Map.of("티본스테이크", 1, "바비큐립", 2, "초코케이크", 2, "제로콜라", 1));
    }

    @DisplayName("크리스마스 디데이 할인 금액을 계산한다.")
    @Test
    void 크리스마스_디데이_할인_금액을_계산한다() {
        // given
        VisitDate 방문날짜 = new VisitDate(10);

        // when
        Map<Discount, Integer> 할인계산결과 = Discount.CHRISTMAS.calculateChristmasDiscount(방문날짜);

        // then
        assertEquals(1_900, 할인계산결과.get(Discount.CHRISTMAS));
    }
}