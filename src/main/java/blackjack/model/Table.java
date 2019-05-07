package blackjack.model;

import blackjack.rules.HouseRules;

public class Table {
    private DiscardTray discardTray = new DiscardTray();
    private HouseRules houseRules = new HouseRules();
    private Deck shoe = new Deck();
    private Seat seat;

    public void shuffle(){
        shoe.shuffle();
    }
    public void setupTable(HouseRules rules) {
        this.houseRules = rules;
        shoe = new CardFactory().getSixDecks();
        seat = new Seat(this);
    }

    public void setShoe(Deck deck) {
        shoe = deck;
    }

    public void SeatPlayer(Player p) {
       seat.sit(p);
    }

    public void clearTable(){
        seat = new Seat(this);
    }

    public Card draw() {
        return shoe.draw();
    }
    public Seat getSeats() {
        return seat;
    }

    public HouseRules getRules() {
        return houseRules;
    }

    public DiscardTray getDiscardTray() {
        return discardTray;
    }

    
    
}