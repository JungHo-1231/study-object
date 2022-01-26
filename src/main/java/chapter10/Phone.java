package chapter10;

import chapter08.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 통화 요금을 계산할 Phone
 * <p>
 * 전화 요금을 계산하는 규칙  : 통화 시간 / 단위 시간 요금
 * <p>
 * 예를들으 10초당 5원의 통화료를 부과하는 욪금제에 가입되어 있는 경우 100 초 통화시
 * 100/ 10 * 5 = 50원 부과
 */
public class Phone extends AbstractPhone {
    // 단위 요금 저장
    private Money amount;

    // 단위 시간 저장
    private Duration seconds;

    public Duration getSeconds() {
        return seconds;
    }

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }


    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}

