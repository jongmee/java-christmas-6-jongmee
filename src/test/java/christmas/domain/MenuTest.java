package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {
    @DisplayName("메뉴 이름으로 메뉴 enum 객체를 구한다.")
    @Test
    void 이름으로_메뉴_객체를_구한다() {
        // given
        String 메뉴이름 = "아이스크림";

        // when
        Menu 메뉴 = Menu.findByName(메뉴이름).get();

        // then
        assertEquals(Menu.ICE_CREAM, 메뉴);
    }

    @DisplayName("메뉴 개수만큼의 지불 금액을 계산한다.")
    @Test
    void 개수만큼_지불금액을_계산한다() {
        // given
        int 개수 = 4;

        // when & then
        assertEquals(5_000 * 개수, Menu.ICE_CREAM.getPriceAboutCount(4));
    }
}