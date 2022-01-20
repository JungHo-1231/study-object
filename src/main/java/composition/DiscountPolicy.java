package composition;

import chapter02.Money;

/**
 * 500 원을 할인해주는 정책
 */
public class DiscountPolicy extends BaseCalculatePolicy {
    private static final int discountAmount = 500;

    @Override
    protected Money calculatePaymentFee(Payment payment) {
        return payment.getFee().minus(Money.wons(discountAmount));
    }
}
