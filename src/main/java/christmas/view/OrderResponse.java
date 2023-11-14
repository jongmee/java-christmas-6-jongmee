package christmas.view;

import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderResponse {
    private static final String FORMAT = "%s %d개";

    private final List<String> message;

    public OrderResponse(Map<Menu, Integer> orders) {
        this.message = convertToMessage(orders);
    }

    private List<String> convertToMessage(Map<Menu, Integer> orders) {
        List<String> message = new ArrayList<>();
        for(Map.Entry<Menu, Integer> order : orders.entrySet()) {
            String menu = String.format(FORMAT, order.getKey().toString(), order.getValue());
            message.add(menu);
        }
        return message;
    }

    public List<String> getMessage() {
        return message;
    }
}
