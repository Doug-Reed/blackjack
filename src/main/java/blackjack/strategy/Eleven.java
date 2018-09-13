package blackjack.strategy;

import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public class Eleven implements StrategyChart {

    private String description = "Player 11";

    public String description() {
        return description;
    }

    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {

        if (dealerUpcard.getValue() <= 10) {
            description = "Eleven doubles against damn near everything.";
            return new DOUBLE();
        }

        if (dealerUpcard.getValue() <= 11) {
            if (rules.dealerHitsSoft17) {
                description = "Eleven doubles against damn near everything.";
                return new DOUBLE();
            }

            if (!rules.dealerHitsSoft17) {
                description = "In S17, 11 doubles against an Ace at or above a true 1.";
                if (tray.trueCount() >= 1) {
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
