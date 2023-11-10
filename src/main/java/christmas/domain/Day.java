package christmas.domain;

public enum Day {
    MONDAY(4),
    TUESDAY(5),
    WEDNESDAY(6),
    THURSDAY(0),
    FRIDAY(1),
    SATURDAY(2),
    SUNDAY(3);

    private int offset;

    Day(int offset) {
        this.offset = offset;
    }
}
