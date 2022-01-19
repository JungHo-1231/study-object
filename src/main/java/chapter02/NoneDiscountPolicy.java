package chapter02;

/**
 * 할인 하지 않는 정책
 */
public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return null;
    }
}
