package blackjack.strategy;



import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.action.STAND;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public class Fourteen implements StrategyChart {

    private String description = "Player 14";

    public String description() {
        return description;
    }

    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {
        //Soft 14
        if (playerHand.isSoft()) {
            if (playerHand.firstTwoCards()) {
                if ( dealerUpcard.getValue() == 5 || dealerUpcard.getValue() == 6) {
                    description = "Soft 14 doubles v. 5 or 6.";
                    return new DOUBLE();
                }
            }

            description = "Soft 14 hits v. everything except 5 or 6.";
            return new HIT();
        }
        
        //Hard 14
        if (!playerHand.isSoft()) {
           
           if (playerHand.isPair()) {
               description = "7's split vs. 7 or less."
               if(dealerUpcard.getValue() <= 7) {
                   return new SPLIT();
               }
           }

           if(dealerUpcard.getValue() <=6) {
               description = "14 stands vr 6 or less.";
               return new STAND();
           }

           if(dealerUpcard.getValue() >6) {
               description = "14 hits vs 7 or higher.";
               return new HIT();
           }

        }
       
       description = "You should never reach this part of the code.";
       return new HIT();
     
    }
}
