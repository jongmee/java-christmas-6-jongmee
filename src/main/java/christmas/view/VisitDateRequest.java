package christmas.view;

import static christmas.constants.ErrorMessage.INVALID_DATE;

import christmas.domain.VisitDate;

public class VisitDateRequest {
    private final int date;

    public VisitDateRequest(String input) {
        this.date = validate(input);
    }

    public int validate(String input) {
        try {
            return Integer.valueOf(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }

    public VisitDate convertToValidDate() {
        return new VisitDate(date);
    }
}
