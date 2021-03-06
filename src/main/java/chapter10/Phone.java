package chapter10;

import chapter08.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {

    // 전체 통화 목록을 저장하고 있는 Call 리스트
    private List<Call> calls = new ArrayList<>();
    // 세금 추가
    private double taxRate;

    public Phone(double taxRate) {
        this.taxRate = taxRate;
    }

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

        return result.plus(result.times(taxRate));

    }

    abstract protected Money calculateCallFee(Call call);
}
