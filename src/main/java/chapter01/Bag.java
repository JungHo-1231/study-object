package chapter01;

import lombok.Setter;

/**
 * 관람객이 소지품을 보관할 가방
 */
public class Bag {
    private Long amount;
    private Invitation invitation;
    @Setter
    private Ticket ticket;

    /**
     * 관람객이 초대장을 가지고 있으면 ture 를 반환한다.
     */
    public boolean hasInvitation() {
        return this.invitation != null;
    }

    /**
     * 현금을 감소시킨다.
     */
    public void minusAmount(Ticket ticket) {
        this.amount -= amount;
    }

    /**
     * 현금을 증가시킨다.
     */
    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
