package blackjack.strategy;

import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.action.STAND;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public class Nineteen implements StrategyChart {

    private String description = "Player 19";

    public String description() {
        return description;
    }

    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {
        //Soft 19
        if (playerHand.isSoft()) {
            if (playerHand.firstTwoCards()) {
                if (dealerUpcard.getValue() == 4) {
                    description = "Soft 19 doubles v. 4 at or above a true 3.";
                    if (tray.trueCount() >= 3) {
                        return new DOUBLE();
                    } else {
                        return new STAND();
                    }
                }
                if (dealerUpcard.getValue() == 5) {
                    description = "Soft 19 doubles v. 5 at or above a true 1.";
                    if (tray.trueCount() >= 1) {
                        return new DOUBLE();
                    } else {
                        return new STAND();
                    }
                }
                if (dealerUpcard.getValue() == 6) {
                    description = "Soft 19 doubles v. 6 at RC 0+ in H17, and true 1 in S17";
                    if(rules.dealerHitsSoft17 && tray.runningCount() > 0) {
                        return new DOUBLE();
                    }

                    if(!rules.dealerHitsSoft17 && tray.trueCount() >=1) {
                        return new DOUBLE();
                    }

                    return new STAND();
                }
            }
        }
        
        description = "19 stands.";
        return new STAND();
    }
}
