package blackjack.model;

import blackjack.rules.HouseRules;

public class Table {
    private DiscardTray discardTray = new DiscardTray();
    private HouseRules houseRules = new HouseRules();
    private Dealer dealer = new Dealer();
    private Deck shoe = new Deck();
    private Seat[] seats = new Seat[7];

    public void setupTable(HouseRules rules) {
        
    }

    public Seat[] getSeats() {
        return seats;
    }
    public Dealer getDealer() {
        return dealer;
    }
    public HouseRules getRules() {
        return houseRules;
    }

    public DiscardTray getDiscardTray() {
        return discardTray;
    }
    
}