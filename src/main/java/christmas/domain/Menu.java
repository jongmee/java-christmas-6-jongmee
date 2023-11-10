package christmas.domain;

public enum Menu {
    MUSHROOM_SOUP(MenuType.APPETIZER, 6_000, "양송이수프"),
    TAPAS(MenuType.APPETIZER, 5_500, "타파스"),
    CAESAR_SALAD(MenuType.APPETIZER, 8_000, "시저샐러드"),
    T_BONE_STEAK(MenuType.MAIN, 55_000, "티본스테이크"),
    BARBECUE_RIBS(MenuType.MAIN, 54_000, "바비큐립"),
    SEAFOOD_PASTA(MenuType.MAIN, 35_000, "해산물파스타"),
    CHRISTMAS_PASTA(MenuType.MAIN, 25_000, "크리스마스파스타"),
    CHOCO_CAKE(MenuType.DESSERT, 15_000, "초코케이크"),
    ICE_CREAM(MenuType.DESSERT, 5_000, "아이스크림"),
    ZERO_COKE(MenuType.BEVERAGE, 3_000, "제로콜라"),
    RED_WINE(MenuType.BEVERAGE, 60_000, "레드와인"),
    CHAMPAGNE(MenuType.BEVERAGE, 25_000, "샴페인");

    private MenuType type;
    private int price;
    private String name;

    Menu(MenuType type, int price, String name) {
        this.type = type;
        this.price = price;
        this.name = name;
    }
}