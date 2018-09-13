package blackjack.strategy;

import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.action.SPLIT;
import blackjack.action.STAND;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public class Twelve implements StrategyChart {

    private String description = "Player 12";

    public String description() {
        return description;
    }

    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {
        //Could be aces or sixes
        if(playerHand.isPair()) {
            String talkToTheHand = playerHand.toString();
            boolean isAces = talkToTheHand.indexOf("ACE") !=-1? true: false;
            boolean isSixes = talkToTheHand.indexOf("SIX") !=-1? true: false;

            if(isAces) {
                description = "Always split Aces.";
                return new SPLIT();
            }

            if(isSixes) {
                description = "Sixes split vs. dealer six or less.";
                if(dealerUpcard.getValue() <= 6) {
                    return new SPLIT();
                }
            }
        }

        if(dealerUpcard.getValue() ==2) {
            description = "12 stands v. 2 at or above a true 3.";
            if(tray.trueCount() >= 3) {
                return new STAND();
            } else {
                return new HIT();
            }
        }

        if(dealerUpcard.getValue() ==3) {
            description = "12 stands v. 3 at or above a true 2.";
            if(tray.trueCount() >= 2) {
                return new STAND();
            } else {
                return new HIT();
            }
        }

        if(dealerUpcard.getValue() ==4) {
            description = "12 hits v. 4 on a negative running count.";
            if(tray.runningCount() < 0) {
                return new HIT();
            } else {
                return new STAND();
            }
        }

        if(dealerUpcard.getValue() ==5 || dealerUpcard.getValue()==6) {
            description = "12 stands against a 5 or 6.";
            return new STAND();
        }

        if (dealerUpcard.getValue() >= 7) {
            description = "12 hits against 7 and up.";
            return new HIT();
        }

        description = "You should never have reached this part of the code.";
        return new HIT();
    }
}
