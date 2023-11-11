package christmas.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Benefit {
    private final List<Discount> discounts;
    private final Map<Menu, Integer> gifts;

    public Benefit(VisitDate date) {

    }

    private List<Discount> determineDiscounts(VisitDate date) {
        Day day = date.calculateDay();

        List<Discount> result = new ArrayList<>();
        result.add(Discount.chooseWeekdayOrWeekend(day));

    }
}
