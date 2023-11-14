package christmas.view.request;

import static christmas.constants.ErrorMessage.INVALID_DATE;

import christmas.domain.VisitDate;

public class VisitDateRequest {
    private final int date;

    public VisitDateRequest(final String input) {
        this.date = validate(input);
    }

    public int validate(final String input) {
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
