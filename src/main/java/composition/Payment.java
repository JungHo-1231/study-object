package composition;

import chapter02.Money;

import java.time.LocalDateTime;

public class Payment {

    private LocalDateTime when;
    private Money fee;

    public Payment(LocalDateTime when, Money fee) {
        this.when = when;
        this.fee = fee;
    }

    protected Payment(){}

    public LocalDateTime getWhen() {
        return when;
    }

    public Money getFee() {
        return fee;
    }
}
