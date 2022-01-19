package chapter02;

/**
 * 순번 할인 조건
 */
public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    /**
     * 순번 할인 조건에 상영 순서가 일치하면
     * 할인이 가능하다는 의미에 true 를 리턴한다
     *
     * @param screening
     * @return
     */
    @Override
    public boolean isSatisfied(Screening screening) {
        return screening.isSequence(sequence);
    }
}
