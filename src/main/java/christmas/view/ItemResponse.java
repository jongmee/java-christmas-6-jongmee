package christmas.view;

import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemResponse {
    private static final String FORMAT = "%s %d개";

    private final List<String> message;

    public ItemResponse(Map<Menu, Integer> items) {
        this.message = convertToMessage(items);
    }

    private List<String> convertToMessage(Map<Menu, Integer> items) {
        List<String> message = new ArrayList<>();
        for(Map.Entry<Menu, Integer> entry : items.entrySet()) {
            Menu menu = entry.getKey();
            Integer count = entry.getValue();
            String item = String.format(FORMAT, menu.toString(), count);
            message.add(item);
        }
        return message;
    }

    public List<String> getMessage() {
        return message;
    }
}
