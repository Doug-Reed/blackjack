package blackjack.strategy;
import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.action.SPLIT;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;
public class Eight implements StrategyChart {

    private String description = "Player 8";

    public String description() {
        return description;
    }
    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard){
          
          if(playerHand.isPair()) {
              if(dealerUpcard.getValue()==5 || dealerUpcard.getValue()==6) {
                  if(rules.canDoubleAfterSplit) {
                      description = "Split 4's vs. 5/6 if you can double.";
                      return new SPLIT();
                  }
              }
          }

          if(dealerUpcard.getValue()==6) {
              if(tray.trueCount() >= 2) {
                  description = "Double 8 v. 6 at or above a true 2.";
                  return new DOUBLE();
              }
          }
          
          return new HIT();
    }
}