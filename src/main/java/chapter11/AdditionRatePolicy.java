package chapter11;

import chapter08.Money;

public abstract class AdditionRatePolicy implements RatePolicy {
    private RatePolicy next;

    public AdditionRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    protected abstract Money afterCalculated(Money fee);

}
