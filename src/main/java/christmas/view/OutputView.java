package christmas.view;

import christmas.view.utility.Writer;

public class OutputView {
    private static final String BENEFIT_MESSAGE = "12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_HEADER = "<주문 메뉴>";
    private static final String ORDER_AMOUNT_HEADER = "<할인 전 총주문 금액>";
    private static final String GIFT_MENU_HEADER = "<증정 메뉴>";
    private static final String BENEFIT_HEADER = "<혜택 내역>";
    private static final String BENEFIT_AMOUNT_HEADER = "<총혜택 금액>";
    private static final String TOTAL_PAYMENT_HEADER = "<할인 후 예상 결제 금액>";
    private static final String BADGE_HEADER = "<12월 이벤트 배지>";

    public static void alertBenefit(String visitDate) {
        Writer.printLine(String.format(BENEFIT_MESSAGE, visitDate));
    }

    public static void alertOrder(OrderResponse response, int orderAmount) {
        Writer.printLine(ORDER_MENU_HEADER);
        response.getMessage().stream()
            .forEach(Writer::printLine);

        Writer.printLine(ORDER_AMOUNT_HEADER);
        Writer.printLine(orderAmount);
    }
}
