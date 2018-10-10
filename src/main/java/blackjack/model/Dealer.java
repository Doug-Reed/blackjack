package blackjack.model;

public class Dealer {
    private Hand hand;
    private Table table;
    private int seatIndex;
    private int seatMaxIndex;

    public void setTable(Table t) {
        this.table = t;
    }

    public Hand selectHand() {
        for(Seat seat: table.getSeats()) {
           
        }
    }
    public Card dealerUpcard() {
        return hand.dealerUpcard();
    }
}