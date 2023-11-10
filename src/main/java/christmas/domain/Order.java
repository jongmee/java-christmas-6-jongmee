package christmas.domain;

import static christmas.constants.ErrorMessage.INVALID_ORDER;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> orders;

    public Order(Map<String, Integer> orders) {
        this.orders = validateMenu(orders);

    }

    private Map<Menu, Integer> validateMenu(Map<String, Integer> orders) {
        Map<Menu, Integer> result = new HashMap<>();
        for(String menuName: orders.keySet()) {
            Menu menu = Menu.findByName(menuName)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER));
            result.put(menu, orders.get(menuName));
        }
        return result;
    }
}
