package christmas.view;

import static christmas.constants.ErrorMessage.INVALID_ORDER;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRequest {
    private static final String MENU_DELIMITER = ",";
    private static final String COUNT_DELIMITER = "-";

    private final Map<String, Integer> orders;

    public OrderRequest(final String input) {
        this.orders = convertToOrders(input);
    }

    private Map<String, Integer> convertToOrders(final String input) {
        List<String> parsedMenus = parseInput(input);
        Map<String, String> menuMap = convertToMap(parsedMenus);
        return convertToValidForm(menuMap);
    }

    private List<String> parseInput(final String input) {
        return Arrays.stream(input.split(MENU_DELIMITER))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    private Map<String, String> convertToMap(final List<String> menus) {
        List<List<String>> parsedMenus = menus.stream()
            .map(this::parseMenu)
            .collect(Collectors.toList());
        Map<String, String> map = new HashMap<>();
        for(List<String> menu: parsedMenus) {
            validateDuplicate(map, menu.get(0));
            map.put(menu.get(0), menu.get(1));
        }
        return map;
    }

    private List<String> parseMenu(final String menu) {
        List<String> parsedMenu = Arrays.stream(menu.split(COUNT_DELIMITER))
            .map(String::trim)
            .collect(Collectors.toList());
        validateMenuForm(parsedMenu);
        return parsedMenu;
    }

    private Map<String, Integer> convertToValidForm(final Map<String, String> menuMap) {
        Map<String, Integer> validForm = new HashMap<>();
        for (Map.Entry<String, String> entry : menuMap.entrySet()) {
            String menuName = entry.getKey();
            String value = entry.getValue();
            Integer count = validateCount(value);
            validForm.put(menuName, count);
        }
        return validForm;
    }

    private void validateDuplicate(final Map<String, String> map, final String key) {
        if(map.containsKey(key)) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private void validateMenuForm(final List<String> parsedMenu) {
        if(parsedMenu.size() != 2) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private Integer validateCount(final String count) {
        try {
            return Integer.valueOf(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
}
