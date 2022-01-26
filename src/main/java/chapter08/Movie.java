package chapter08;


import lombok.Getter;

import java.time.Duration;

/**
 * 영화
 */
public class Movie {
    private String title;
    private Duration duration;
    @Getter
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration duration, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.duration = duration;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}

