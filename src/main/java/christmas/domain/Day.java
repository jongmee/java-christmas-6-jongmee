package christmas.domain;

import java.util.Arrays;

public enum Day {
    MONDAY(4),
    TUESDAY(5),
    WEDNESDAY(6),
    THURSDAY(0),
    FRIDAY(1),
    SATURDAY(2),
    SUNDAY(3);

    private int offset;

    Day(final int offset) {
        this.offset = offset;
    }

    public static Day findByDate(final int date) {
        final int offset = date % 7;
        return Arrays.stream(Day.values())
            .filter(day -> day.offset == offset)
            .findAny().get();
    }

    public boolean isWeekend() {
        if(this.equals(FRIDAY) || this.equals(SATURDAY)) {
            return true;
        }
        return false;
    }
}
