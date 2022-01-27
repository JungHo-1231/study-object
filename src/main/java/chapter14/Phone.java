package chapter14;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {
    private RatePolicy ratePolicy;

    /** 전체 통화 목록  */
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }

    public Money calculateFee(){
        return ratePolicy.calculateFee(this);
    }
}
