package blackjack.model;

public class Dealer {
    private Hand hand;
    private Table table;
    private int seatIndex;
    private int seatMaxIndex;

    public void setTable(Table t) {
        this.table = t;
    }

    public void deal() {
        hand = new Hand();
        hand.addToHand(table.draw());

        for (Seat seat: table.getSeats()) {
            if(seat.hasPlayer()) {
               Player p = seat.getPlayer();
               p.resetHand();
               p.hand(0).addToHand(table.draw());
            }
        }

        for (Seat seat: table.getSeats()) {
            if(seat.hasPlayer()) {
               Player p = seat.getPlayer();
               p.hand(0).addToHand(table.draw());
               System.out.println(p.hand(0).toString());
            }
        }

        hand.addToHand(table.draw());
    }

    public Hand selectHand() {
        for(Seat seat: table.getSeats()) {
           return null;
        }
        return null;
    }
    public Card dealerUpcard() {
        return hand.dealerUpcard();
    }
}