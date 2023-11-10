package christmas.view;

import static christmas.constants.ErrorMessage.INVALID_DATE;

public class VisitDateRequest {
    private final Integer date;

    public VisitDateRequest(String input) {
        this.date = validate(input);
    }

    public Integer validate(String input) {
        try {
            return Integer.valueOf(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }
}
