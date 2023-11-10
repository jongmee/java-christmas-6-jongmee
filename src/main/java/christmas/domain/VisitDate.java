package christmas.domain;

import static christmas.constants.ErrorMessage.INVALID_DATE;

public class VisitDate {
    private static final int START_DATE = 1;
    private static final int LAST_DATE = 31;

    private final int date;

    public VisitDate(int date) {
        validate(date);
        this.date = date;
    }

    private void validate(int date) {
        if(date < START_DATE || date > LAST_DATE) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }

    public Day calculateDay() {
        int offset = date % 7;
        return Day.findByOffset(offset);
    }
}
