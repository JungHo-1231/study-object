package composition;

import chapter02.Money;

public class PercentDiscountPolicy extends AdditionalCalculationPolicy {
    private double discountRate;


    public PercentDiscountPolicy(CalculatePolicy additionalPolicy, double discountRate) {
        super(additionalPolicy);
        this.discountRate = discountRate;
    }

    @Override
    protected Money adjustAmountAfterCalculated(Money fee) {
        return null;
    }
}
