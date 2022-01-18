package chapter02;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 상영
 */
@AllArgsConstructor
@Getter
public class Screening {
    // 상영할 영화
    private Movie movie;
    // 순번
    private int sequence;
    // 상영 시작 시간
    private LocalDateTime whenScreened;

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
