package christmas;

import christmas.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        config.promotionController().run();
    }
}
