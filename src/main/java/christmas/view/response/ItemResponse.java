package christmas.view.response;

import christmas.domain.Menu;
import java.util.List;
import java.util.Map;

public class ItemResponse extends Response {
    private static final String FORMAT = "%s %d개";

    private final List<String> message;

    public ItemResponse(final Map<Menu, Integer> items) {
        this.message = convertToMessage(items);
    }

    private List<String> convertToMessage(final Map<Menu, Integer> items) {
        List<String> message = convertMapToMessage(items, FORMAT);
        return checkEmptyList(message);
    }

    public List<String> getMessage() {
        return message;
    }
}
