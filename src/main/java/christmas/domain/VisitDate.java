package christmas.domain;

import static christmas.constants.ErrorMessage.INVALID_DATE;

public class VisitDate {
    private static final int START_DATE = 1;
    private static final int LAST_DATE = 31;

    private final int date;

    public VisitDate(final int date) {
        validate(date);
        this.date = date;
    }

    private void validate(final int date) {
        if(date < START_DATE || date > LAST_DATE) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }

    public Day calculateDay() {
        return Day.findByDate(date);
    }

    public boolean isBeforeChristmas() {
        return date < 25;
    }

    public boolean isChristmas() {
        return date == 25;
    }

    public int getChristmasDiscountWeight() {
        return date - 1;
    }

    @Override
    public String toString() {
        return String.valueOf(date);
    }
}
