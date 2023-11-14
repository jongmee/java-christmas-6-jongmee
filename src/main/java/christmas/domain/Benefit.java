package christmas.domain;

import christmas.view.BenefitResponse;
import java.util.HashMap;
import java.util.Map;

public class Benefit {
    private static final int GIFT_CRITERIA = 120_000;

    private final Map<Discount, Integer> discountAmounts;
    private final Map<Menu, Integer> giftCounts;

    public Benefit(final VisitDate date, final Order order) {
        this.discountAmounts = determineDiscounts(date, order);
        this.giftCounts = determineGifts(order);
    }

    private Map<Discount, Integer> determineDiscounts(final VisitDate date, final Order order) {
        Map<Discount, Integer> result = new HashMap<>();
        result.putAll(determineWeekDiscount(date, order));
        result.putAll(determineSpecialDiscount(date));
        result.putAll(determineChristmasDiscount(date));
        return result;
    }

    private Map<Discount, Integer> determineWeekDiscount(final VisitDate date, final Order order) {
        if(date.calculateDay().isWeekend()) {
            return Discount.WEEKEND.calculateWeekDiscount(order);
        }
        return Discount.WEEKDAY.calculateWeekDiscount(order);
    }

    private Map<Discount, Integer> determineSpecialDiscount(final VisitDate date) {
        if(date.isChristmas() || date.calculateDay().equals(Day.SUNDAY)) {
            return Discount.SPECIAL.calculateSpecialDiscount();
        }
        return new HashMap<>();
    }

    private Map<Discount, Integer> determineChristmasDiscount(final VisitDate date) {
        if(date.isChristmas() || date.isBeforeChristmas()) {
            return Discount.CHRISTMAS.calculateChristmasDiscount(date);
        }
        return new HashMap<>();
    }

    private Map<Menu, Integer> determineGifts(final Order order) {
        if(order.calculateTotalPrice() > GIFT_CRITERIA) {
            return new HashMap<>(Map.of(Menu.CHAMPAGNE, 1));
        }
        return new HashMap<>();
    }

    public int calculateGiftAmount() {
        int amount = 0;
        for(Map.Entry<Menu, Integer> entry : giftCounts.entrySet()) {
            Menu menu = entry.getKey();
            Integer count = entry.getValue();
            amount += menu.getPriceAboutCount(count);
        }
        return amount;
    }

    public int calculateTotalAmount() {
        int giftAmount = calculateGiftAmount();
        int discountAmount = discountAmounts.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
        return giftAmount + discountAmount;
    }

    public BenefitResponse convertToResponse() {
        return new BenefitResponse(discountAmounts, calculateGiftAmount());
    }
}
