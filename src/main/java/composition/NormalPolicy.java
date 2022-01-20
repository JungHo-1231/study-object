package composition;

import chapter02.Money;

public class NormalPolicy extends BaseCalculatePolicy {
    public NormalPolicy() {
    }

    @Override
    protected Money calculatePaymentFee(Payment payment) {
        return payment.getFee();
    }
}
