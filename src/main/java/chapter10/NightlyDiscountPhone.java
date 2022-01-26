package chapter10;

import chapter08.Money;

import java.time.Duration;

/**
 * 심야 할인 요금제 NightlyDiscountPhone
 * <p>
 * 밤 10시 이후 통화에 대한 요금 할인 해주는 방식
 */
public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    // 밤 10시 이전에 적용할 통화 요금
    private Money regularAmount;
    // 밤 10시 이후에 적용할 통화 요금
    private Money nightlyAmount;
    private Duration seconds;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }


    @Override
    protected Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        } else {
            return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }
    }
}
