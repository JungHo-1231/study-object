package chapter10;

import chapter08.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 통화 요금을 계산할 Phone
 *
 * 전화 요금을 계산하는 규칙  : 통화 시간 / 단위 시간 요금
 *
 * 예를들으 10초당 5원의 통화료를 부과하는 욪금제에 가입되어 있는 경우 100 초 통화시
 * 100/ 10 * 5 = 50원 부과
 */
public class Phone {
    // 단위 요금 저장
    private Money amount;

    // 단위 시간 저장
    private Duration seconds;

    // 전체 통화 목록을 저장하고 있는 Call 리스트
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee(){
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result;
    }
}

