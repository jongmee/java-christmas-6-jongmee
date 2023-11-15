package christmas.view.response;

import christmas.domain.Discount;
import java.util.List;
import java.util.Map;

public class BenefitResponse extends Response {
    private static final String FORMAT = "%s: -%,d원";
    private static final String GIFT_MESSAGE = "증정 이벤트";

    private final List<String> message;

    public BenefitResponse(final Map<Discount, Integer> discountAmounts, final int giftAmounts) {
        this.message = convertToMessage(discountAmounts, giftAmounts);
    }

    private List<String> convertToMessage(
        final Map<Discount, Integer> discountAmounts, final int giftAmounts) {
        List<String> message = convertMapToMessage(discountAmounts, FORMAT);

        if(giftAmounts != 0) {
            String gift = String.format(FORMAT, GIFT_MESSAGE, giftAmounts);
            message.add(gift);
        }

        return checkEmptyList(message);
    }

    public List<String> getMessage() {
        return message;
    }
}
