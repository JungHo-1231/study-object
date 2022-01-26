package chapter10;

import chapter08.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 심야 할인 요금제 NightlyDiscountPhone
 * <p>
 * 밤 10시 이후 통화에 대한 요금 할인 해주는 방식
 */
public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    // 밤 10시 이전에 적용할 통화 요금
    private Money regularAmount;
    // 밤 10시 이후에 적용할 통화 요금
    private Money nightlyAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(
                        nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                result = result.plus(
                        regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }
        return result;
    }
}
