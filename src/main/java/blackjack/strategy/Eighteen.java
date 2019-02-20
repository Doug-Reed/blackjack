package blackjack.strategy;

import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.action.STAND;
import blackjack.action.SPLIT;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public class Eighteen implements StrategyChart {

    private String description = "Player 18";

    public String description() {
        return description;
    }

    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {
        //Soft 18
        if (playerHand.isSoft()) {
            if(dealerUpcard.getValue() ==7 || dealerUpcard.getValue()==8) {
                description = "Soft 18 stands vs. 7 or 8.";
                return new STAND();
            }
            
            if (dealerUpcard.getValue() <= 6) {
                description = "Soft 18 doubles or stands vs. 2 - 6.";
                if (playerHand.firstTwoCards()) {
                    return new DOUBLE();
                } else {
                    return new STAND();
                }
            }

            if(dealerUpcard.getValue() >= 9) {
                description = "Soft 18 hits vs. 9, 10, A.";
                return new HIT();
            }
        }

    //Hard 17
    if(!playerHand.isSoft())
    {
        if(playerHand.isPair()) {
            if(dealerUpcard.getValue== 7 || dealerUpcard >= 10) {
                description = "Pair of 9's stands against 7, 10, Ace.";
                return new STAND();
            } else {
                description = "Pair of 9s splits against everything but 7, 10, Ace.";
                return new SPLIT();
            }
        }

        description = "18 stands.";
        return new STAND();

    }

    description="You should never reach this part of the code.";return new HIT();

}}
