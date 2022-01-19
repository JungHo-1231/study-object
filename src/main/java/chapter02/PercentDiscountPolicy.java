package chapter02;

/**
 * 일정 비율 할인 정책
 */
public class PercentDiscountPolicy extends DiscountPolicy {

    /**
     * 할인 비율
     */
    private double percent;

    public PercentDiscountPolicy(DiscountCondition... conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
