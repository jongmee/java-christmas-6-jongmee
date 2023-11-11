package christmas.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Benefit {
    private final List<Discount> discounts;
    private final Map<Menu, Integer> gifts;

    public Benefit(VisitDate date) {
        this.discounts = determineDiscounts(date);
    }

    private List<Discount> determineDiscounts(VisitDate date) {
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

    private static boolean isAvailableForSpecial(VisitDate date) {
        if(date.isChristmas() || date.calculateDay().equals(Day.SUNDAY)) {
            return true;
        }
        return false;
    }

    private static boolean isAvailableForChristmas(VisitDate date) {
        if(date.isChristmas() || date.isBeforeChristmas()) {
            return true;
        }
        return false;
    }
}
