package composition;

import chapter02.Money;

public abstract class AdditionalCalculationPolicy implements CalculatePolicy {
    // 다른 옵셔과 조합될 수 있도록 인스턴스 변수로 포함
    private CalculatePolicy additionalPolicy;

    public AdditionalCalculationPolicy(CalculatePolicy additionalPolicy) {
        this.additionalPolicy = additionalPolicy;
    }

    @Override
    public Money calculateFee(Card card) {
        Money fee = additionalPolicy.calculateFee(card);
        return adjustAmountAfterCalculated(fee);
    }

    // 최정 결제 금액에 수정할 수 있도록 메서드 추가
    abstract protected Money adjustAmountAfterCalculated(Money fee);
}
