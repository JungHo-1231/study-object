package chapter02;

import java.util.Arrays;
import java.util.List;

/**
 * 할인 정책
 * <p>
 * 조건을 만족할 경우 일정 금액을 할인해주는 정책
 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    /**
     * 하나의 할인 정책은 여러 개의 할인 조건을 포함할 수 있다.
     */

    private List<DiscountCondition> conditions;

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    /**
     * 할인 금액을 계산한다.
     *
     * @param screening
     * @return
     */
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfied(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
