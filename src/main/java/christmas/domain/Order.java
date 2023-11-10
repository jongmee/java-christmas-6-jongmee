package christmas.domain;

import static christmas.constants.ErrorMessage.BEVERAGE_ONLY_ERROR;
import static christmas.constants.ErrorMessage.INVALID_ORDER;
import static christmas.constants.ErrorMessage.MAX_ORDER_LIMIT_EXCEEDED;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static final long ORDER_MAX = 20L;

    private final Map<Menu, Integer> orders;

    public Order(Map<String, Integer> orders) {
        this.orders = validateMenu(orders);
        validateTotalCount();
        validateBeverage();
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

    private void validateTotalCount() {
        long sum = 0;
        for(int count: orders.values()) {
            sum += count;
        }
        if(sum > ORDER_MAX) {
            throw new IllegalArgumentException(MAX_ORDER_LIMIT_EXCEEDED);
        }
    }

    private void validateBeverage() {
        long beverageCount = orders.keySet().stream()
            .filter(Menu::isBeverage)
            .count();
        if(beverageCount == (long)orders.size()) {
            throw new IllegalArgumentException(BEVERAGE_ONLY_ERROR);
        }
    }
}