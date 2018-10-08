package blackjack.strategy;
import blackjack.action.PlayerAction;
import blackjack.action.STAND;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;
public class Twenty implements StrategyChart {

    private String description = "Player 20";

    public String description() {
        return description;
    }
    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard){
         
          if(playerHand.isPair()) {
              if(dealerUpcard.getValue() ==4 && tray.trueCount() >=6 ) {
                  description = "Split tens v. 4 at a count greater than or equal to 6. Fetch the pit boss,";
                  return new SPLIT();
              }
              if(dealerUpcard.getValue() ==5 && tray.trueCount() >=5 ) {
                description = "Split tens v. 5 at a count greater than or equal to 5. Prepare for heat,";
                return new SPLIT();
              }
              if(dealerUpcard.getValue() ==6 && tray.trueCount() >=4 ) {
                description = "Split tens v. 6 at a count greater than or equal to 4. Get 86'd,";
                return new SPLIT();
              }
           }
              
          
          description = "Stand on a 20.";
          return new STAND();
    }
}