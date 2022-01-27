package chapter11;

import chapter08.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
