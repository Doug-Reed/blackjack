package blackjack.strategy;

import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public class Ten implements StrategyChart {

    private String description = "Player 10";

    public String description() {
        return description;
    }

    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {

        if(dealerUpcard.getValue() < 10 ) {
            description = "Ten doubles against damn near everything.";
            return new DOUBLE();
        }

        if(dealerUpcard.getValue() == 10) {
            description = "Ten doubles v. ten at a true 4 and above.";
            if(tray.trueCount() >= 4) {
                return new DOUBLE();
            } else {
                return new HIT();
            }
        }
        
        if(dealerUpcard.getValue() == 11) {
            if(rules.dealerHitsSoft17) {
                description = "10 doubles v. Ace in an H17 game at or above a true 3. True count = " + tray.trueCount();
                if(tray.trueCount() >= 3) {
                    return new DOUBLE();
                } else {
                    return new HIT();
                }
            }
            if(!rules.dealerHitsSoft17) {
                description = "10 doubles v. Ace in an S17 game at or above a true 4. True count = " + tray.trueCount();
                if(tray.trueCount() >= 4) {
                    return new DOUBLE();
                } else {
                    return new HIT();
                }
            }

        }

        description = "You should never have reached this part of the code.";
        return new HIT();
    }
}