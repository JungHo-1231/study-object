package chapter11;

import chapter08.Money;
import chapter10.Call;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicRatePolicy implements RatePolicy {

    // 전체 통화 목록을 저장하고 있는 Call 리스트
    private List<Call> calls = new ArrayList<>();

    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    abstract protected Money calculateCallFee(Call call);
}
