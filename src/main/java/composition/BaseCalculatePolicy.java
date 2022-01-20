package composition;

import chapter02.Money;

public abstract class BaseCalculatePolicy implements CalculatePolicy {

    @Override
    public Money calculateFee(Card card) {
        Money fee = Money.ZERO;

        for (Payment payment : card.getPayments()) {
            fee.plus(calculatePaymentFee(payment));
        }
        return fee;
    }

    protected abstract Money calculatePaymentFee(Payment payment);
}
