package chapter10;

import chapter08.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPhone {

    // 전체 통화 목록을 저장하고 있는 Call 리스트
    private List<Call> calls = new ArrayList<>();

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }
        return result;
    }

    abstract protected Money calculateCallFee(Call call);
}
