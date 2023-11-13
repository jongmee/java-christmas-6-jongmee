package christmas.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Benefit {
    private static final int GIFT_CRITERIA = 120_000;

    private final List<Discount> discounts;
    private final Map<Menu, Integer> gifts;

    public Benefit(final VisitDate date, final Order order) {
        this.discounts = determineDiscounts(date);
        this.gifts = determineGifts(order);
    }

    private List<Discount> determineDiscounts(final VisitDate date) {
        List<Discount> result = new ArrayList<>();
        result.add(Discount.chooseWeekdayOrWeekend(date));
        if(isAvailableForSpecial(date)) {
            result.add(Discount.SPECIAL);
        }
        if(isAvailableForChristmas(date)) {
            result.add(Discount.CHRISTMAS);
        }
        return result;
    }

    private boolean isAvailableForSpecial(final VisitDate date) {
        if(date.isChristmas() || date.calculateDay().equals(Day.SUNDAY)) {
            return true;
        }
        return false;
    }

    private boolean isAvailableForChristmas(final VisitDate date) {
        if(date.isChristmas() || date.isBeforeChristmas()) {
            return true;
        }
        return false;
    }

    private Map<Menu, Integer> determineGifts(final Order order) {
        if(order.calculateTotalPrice() > GIFT_CRITERIA) {
            return new HashMap<>(Map.of(Menu.CHAMPAGNE, 1));
        }
        return new HashMap<>();
    }
}
