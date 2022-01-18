package chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 매표소
 */
public class TicketOffice {
    /**
     * 매표소에서 판매한 모든 판매 금액
     */
    private Long amount;

    /**
     * 매표소에서 판매하거나 초대장과 교환해 줄 티켓의 목록
     */
    private List<Ticket> ticketList = new ArrayList<>();

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.ticketList.addAll(Arrays.asList(tickets));
    }

    /**
     * 판매할 티켓을 꺼내준다
     */
    public Ticket getTicket(){
        // 편의상 티켓 컬렉션에서 첫 번째 위치에 저장된 티켓을 리턴한다.
        return ticketList.remove(0);
    }

    /**
     * 판매 금액을 차감한다
     */
    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    /**
     * 판매 금액을 더한다
     */
    private void plusAmount(Long amount) {
        this.amount+= amount;
    }

    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }
}
