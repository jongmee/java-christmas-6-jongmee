package christmas.domain;

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
}
