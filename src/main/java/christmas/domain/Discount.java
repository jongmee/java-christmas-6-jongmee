package christmas.domain;

import static christmas.constants.ErrorMessage.INVALID_DISCOUNT_INSTANCE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Discount {
    CHRISTMAS(100, MenuType.ENTIRE, "크리스마스 디데이 할인"),
    WEEKDAY(2_023, MenuType.DESSERT, "평일 할인"),
    WEEKEND(2_023, MenuType.MAIN, "주말 할인"),
    SPECIAL(1_000, MenuType.ENTIRE, "특별 할인");

    private int amount;
    private MenuType target;
    private String name;

    Discount(final int amount, final MenuType target, final String name) {
        this.amount = amount;
        this.target = target;
        this.name = name;
    }

    public Map<Discount, Integer> calculateWeekDiscount(final Order order) {
        validate(WEEKDAY, WEEKEND);
        int count = order.countByMenuType(target);
        return new HashMap<>(Map.of(this, count * amount));
    }

    public Map<Discount, Integer> calculateSpecialDiscount() {
        validate(SPECIAL);
        return new HashMap<>(Map.of(this, amount));
    }

    public Map<Discount, Integer> calculateChristmasDiscount(final VisitDate date) {
        validate(CHRISTMAS);
        int offset = 1_000;
        return new HashMap<>(Map.of(this, date.getChristmasDiscountWeight() * amount + offset));
    }

    private void validate(Discount...discounts) {
        if (Arrays.stream(discounts).noneMatch(this::equals)) {
            throw new IllegalStateException(INVALID_DISCOUNT_INSTANCE);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
