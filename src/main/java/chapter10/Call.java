package chapter10;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 개별 통화 기간을 저장하는 Call
 */
public class Call {
    private LocalDateTime from;
    private LocalDateTime to;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public Duration getDuration() {
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }
}
