package chapter13;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 상영
 */
@AllArgsConstructor
@Getter
public class Screening {
    /**
     * 상영할 영화
     */
    private Movie movie;
    /**
     * 상영 순번
     */
    private int sequence;

    /**
     * 상영 시작 시작
     */
    private LocalDateTime whenScreened;

    /**
     * 상영 시작 시간을 리턴한다
     */
    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    /**
     * 순번이 일치하면 true 를 리턴한다
     */
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    /**
     * 영화를 예매하고, 예매 정보를 리턴한다.
     *
     * @param customer      예매자
     * @param audienceCount 예매 인원 수
     * @return 예매 정보
     */
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    /**
     * 전체 예매 요금을 계산해 리턴한다
     *
     * @param audienceCount 예매 인원 수
     * @return 예매 요금
     */
    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public Money getMovieFee(){
        return movie.getFee();
    }
}
