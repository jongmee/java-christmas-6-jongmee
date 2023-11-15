package christmas.view.response;

import christmas.domain.Discount;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BenefitResponse {
    private static final String FORMAT = "%s: -%,d원";
    private static final String GIFT_MESSAGE = "증정 이벤트";
    private static final String NONE = "없음";

    private final List<String> message;

    public BenefitResponse(final Map<Discount, Integer> discountAmounts, final int giftAmounts) {
        this.message = convertToMessage(discountAmounts, giftAmounts);
    }

    private List<String> convertToMessage(
        final Map<Discount, Integer> discountAmounts, final int giftAmounts) {
        List<String> message = new ArrayList<>();

        for(Map.Entry<Discount, Integer> discount : discountAmounts.entrySet()) {
            String benefit = String.format(FORMAT, discount.getKey().toString(), discount.getValue());
            message.add(benefit);
        }

        if(giftAmounts != 0) {
            String gift = String.format(FORMAT, GIFT_MESSAGE, giftAmounts);
            message.add(gift);
        }

        return checkEmptyList(message);
    }

    private List<String> checkEmptyList(final List<String> message) {
        if(message.size() == 0) {
            message.add(NONE);
        }
        return message;
    }

    public List<String> getMessage() {
        return message;
    }
}
