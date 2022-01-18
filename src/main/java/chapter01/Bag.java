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
     * 이벤트아 당첨되지 않는 관람객, 초대장이 없다.
     *
     * @param amount 현금
     */
    public Bag(Long amount) {
        this.amount = amount;
    }

    /**
     * 이벤트에 당첨된 관람객, 현금과 초대쟁이 있다.
     *
     * @param invitation 초대
     * @param ticket     현금
     */
    public Bag(Invitation invitation, Ticket ticket) {
        this.invitation = invitation;
        this.ticket = ticket;
    }

    /**
     * 관람객이 초대장을 가지고 있으면 ture 를 반환한다.
     */
    public boolean hasInvitation() {
        return this.invitation != null;
    }

    /**
     * 현금을 감소시킨다.
     */
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    /**
     * 현금을 증가시킨다.
     */
    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        }

        setTicket(ticket);
        minusAmount(ticket.getFee());
        return ticket.getFee();
    }
}
