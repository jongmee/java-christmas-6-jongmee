package christmas.config;

import christmas.controller.PromotionController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {
    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    public PromotionController promotionController() {
        return new PromotionController(inputView(), outputView());
    }
}
