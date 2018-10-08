package blackjack.strategy;



import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.action.STAND;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public class Sixteen implements StrategyChart {

    private String description = "Player 16";

    public String description() {
        return description;
    }

    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {
        if(playerHand.isPair()) {
            description = "Always split 8s.";
            return new SPLIT();
        }

        //Soft 16
        if (playerHand.isSoft()) {
            if (playerHand.firstTwoCards()) {
                if ( dealerUpcard.getValue() ==4 || dealerUpcard.getValue() == 5 || dealerUpcard.getValue() == 6) {
                    description = "Soft 16 doubles v. 4, 5 or 6.";
                    return new DOUBLE();
                }
            }

            description = "Soft 16 hits v. everything except 4, 5 or 6.";
            return new HIT();
        }
        
        //Hard 16
        if (!playerHand.isSoft()) {

           if(dealerUpcard.getValue() <=6) {
               description = "15 stands vr 6 or less.";
               return new STAND();
           }

           if(dealerUpcard.getValue() >6) {
               description = "16 hits vs 7 or higher.";
               return new HIT();
           }

        }
       
       description = "You should never reach this part of the code.";
       return new HIT();
     
    }
}
