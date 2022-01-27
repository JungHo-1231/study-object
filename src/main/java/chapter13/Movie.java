package chapter13;


import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

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
        if (screening == null || screening.getStartTime().isBefore(LocalDateTime.now())) {
            throw new InvalidScreeningException();
        }

        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}

