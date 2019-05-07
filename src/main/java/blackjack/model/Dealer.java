package blackjack.model;

public class Dealer {
    private Hand hand;
    private Table table;
    private int seatIndex;
    private int seatMaxIndex;

   public void shuffle(){
       
   }

    public void setTable(Table t) {
        this.table = t;
    }

    public void newHand() {
     
    }

    public void deal() {
        hand = new Hand();
        hand.addToHand(table.draw());
      
           
    }

    public Hand selectHand() {

        return null;
    }
    public Card dealerUpcard() {
        return hand.dealerUpcard();
    }
}