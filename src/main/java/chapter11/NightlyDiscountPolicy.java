package chapter11;

import chapter08.Money;
import chapter10.Call;

import java.time.Duration;

public class NightlyDiscountPolicy extends BasicRatePolicy {

    private static final int LATE_NIGHT_HOUR = 22;

    // 밤 10시 이전에 적용할 통화 요금
    private Money regularAmount;
    // 밤 10시 이후에 적용할 통화 요금
    private Money nightlyAmount;
    private Duration seconds;

    public NightlyDiscountPolicy(Money regularAmount, Money nightlyAmount, Duration seconds) {
        this.regularAmount = regularAmount;
        this.nightlyAmount = nightlyAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }

        return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }

    @Override
    public Money calculateFee(Phone phone) {
        return null;
    }
}
