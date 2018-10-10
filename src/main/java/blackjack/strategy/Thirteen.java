package blackjack.strategy;



import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.action.STAND;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public class Thirteen implements StrategyChart {

    private String description = "Player 13";

    public String description() {
        return description;
    }

    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {
        //Soft 13
        if (playerHand.isSoft()) {
            if (playerHand.firstTwoCards()) {
                if (dealerUpcard.getValue() == 5 || dealerUpcard.getValue() == 6) {
                    description = "Soft 13 doubles v. 5 or 6.";
                    return new DOUBLE();
                }
            }

            description = "Soft 13 hits v. everything except 5 or 6.";
            return new HIT();
        }
        
        //Hard 13
        if (!playerHand.isSoft()) {
           if(dealerUpcard.getValue()==2) {
               description = "13 hits v. 2 at a true -1 or lower.";
               if(tray.trueCount() <= (-1)) {
                   return new HIT();
               } else {
                   return new STAND();
               }
           }

           if(dealerUpcard.getValue() <=6) {
               description = "13 stands vr 6 or less.";
               return new STAND();
           }

           if(dealerUpcard.getValue() >6) {
               description = "13 hits vs 7 or higher.";
               return new HIT();
           }

        }
       
       description = "You should never reach this part of the code.";
       return new HIT();
     
    }
}
