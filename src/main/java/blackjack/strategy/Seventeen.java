package blackjack.strategy;

import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.action.STAND;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public class Seventeen implements StrategyChart {

    private String description = "Player 16";

    public String description() {
        return description;
    }

    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {
        //Soft 17
        if (playerHand.isSoft()) {
            if (playerHand.firstTwoCards()) {
                if (dealerUpcard.getValue() == 2) {
                    description = "Soft 17 doubles v. 2 above a true 1.";
                    if (tray.trueCount() >= 1) {
                        return new DOUBLE();
                    } else {
                        return new HIT();
                    }
                }
                if (dealerUpcard.getValue() <= 6) {
                    description = "Soft 17 doubles v. 6 or less.";
                    return new DOUBLE();
                }
            }

            description = "Soft 17 hits.";
            return new HIT();
        }

        //Hard 17
        if (!playerHand.isSoft()) {

            description = "17 stands.";
            return new STAND();

        }

        description = "You should never reach this part of the code.";
        return new HIT();

    }
}
