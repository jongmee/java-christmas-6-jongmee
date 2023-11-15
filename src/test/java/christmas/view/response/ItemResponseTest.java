package christmas.view.response;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Menu;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ItemResponseTest {
    @DisplayName("올바른 형식으로 메뉴와 개수 출력 메세지를 생성한다.")
    @ParameterizedTest
    @MethodSource("출력대상_설정하기")
    void 올바른형식으로_출력메세지를_생성한다(Map<Menu, Integer> 출력대상, List<String> 출력결과) {
        // when
        ItemResponse 응답객체 = new ItemResponse(출력대상);
        List<String> 출력메세지 = 응답객체.getMessage();

        // then
        assertThat(출력메세지).containsAll(출력결과);
    }

    static Stream<Arguments> 출력대상_설정하기() {
        return Stream.of(
            Arguments.arguments(Map.of(Menu.CHAMPAGNE, 2, Menu.T_BONE_STEAK, 1), List.of("샴페인 2개", "티본스테이크 1개")),
            Arguments.arguments(Map.of(), List.of("없음"))
        );
    }
}