package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Benefit;
import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.request.OrderRequest;
import christmas.view.OutputView;
import christmas.view.request.VisitDateRequest;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;

    public PromotionController(
        final InputView inputView,
        final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        VisitDate visitDate = requestVisitDate();
        Order order = requestOrder();
        printRequest(visitDate, order);

        Benefit benefit = determineBenefit(visitDate, order);
        determineTotalPayment(benefit, order);
        determineBadge(benefit);
    }

    private VisitDate requestVisitDate() {
        while(true) {
            try {
                VisitDateRequest request = inputView.getVisitDate();
                return request.convertToValidDate();
            } catch (IllegalArgumentException e) {
                outputView.alertError(e.getMessage());
            }
        }
    }

    private Order requestOrder() {
        while(true) {
            try {
                OrderRequest request = inputView.getOrder();
                return request.convertToValidOrder();
            } catch (IllegalArgumentException e) {
                outputView.alertError(e.getMessage());
            }
        }
    }

    private void printRequest(final VisitDate visitDate, final Order order) {
        int orderAmount = order.calculateTotalPrice();
        outputView.alertPreview(visitDate.toString());
        outputView.alertOrder(order.convertToResponse(), orderAmount);
    }

    private Benefit determineBenefit(final VisitDate visitDate, final Order order) {
        Benefit benefit = new Benefit(visitDate, order);
        int benefitAmount = benefit.calculateTotalAmount();
        outputView.alertGift(benefit.convertToGiftResponse());
        outputView.alertBenefit(benefit.convertToResponse(), benefitAmount);
        return benefit;
    }

    private void determineTotalPayment(final Benefit benefit, final Order order) {
        int discountAmount = benefit.calculateDiscountAmount();
        int totalPayment = order.calculateTotalPayment(discountAmount);
        outputView.alertTotalPayment(totalPayment);
    }

    private void determineBadge(final Benefit benefit) {
        int benefitAmount = benefit.calculateTotalAmount();
        Badge badge = Badge.findByTotalBenefitAmount(benefitAmount);
        outputView.alertBadge(badge.toString());
    }
}
