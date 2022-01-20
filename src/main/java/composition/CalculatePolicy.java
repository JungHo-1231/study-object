package composition;

import chapter02.Money;

public interface CalculatePolicy {
    Money calculateFee(Card card);
}
