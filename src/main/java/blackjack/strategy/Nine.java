package blackjack.strategy;

import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public class Nine implements StrategyChart {

    private String description = "Player 9";

    public String description() {
        return description;
    }

    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {

        if (dealerUpcard.getValue() == 2) {
            description = "Double 9 v. 2 at a true count of 1 or higher. Basic = HIT.";
            if (tray.trueCount() >= 1) {

                return new DOUBLE();
            } else {
                return new HIT();
            }
        }

        if(dealerUpcard.getValue() >= 3 && dealerUpcard.getValue() <= 6) {
            description = "9 doubles vs. " + dealerUpcard.getValue();
            return new DOUBLE();
        }

        if (dealerUpcard.getValue() == 7) {
            description = "Double 9 v. 7 at a true count of 3 or higher. Basic = HIT.";
            if (tray.trueCount() >= 3) {
                return new DOUBLE();
            } else {
                return new HIT();
            }
        }

        if (dealerUpcard.getValue() > 7) {
            description = "It's a 9. What's the worst that could happen? Hit.";
            return new HIT();
        }

        description = "You should never have reached this part of the code.";
        return new HIT();
    }
}