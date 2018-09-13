package blackjack.strategy;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.action.SPLIT;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;
public class Four implements StrategyChart {

    private String description = "Player 4";

    public String description() {
        return description;
    }
    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard){
          if(dealerUpcard.getValue() <= 3) {
             if(playerHand.size()==2 && rules.canDoubleAfterSplit) {
                 description = "Split 2's vs. 2/3 if DAS";
                 return new SPLIT();
             }
             if(!rules.canDoubleAfterSplit) {
                 description = "2/3 pairs stay together vs. 2/3 if NDAS";
                 return new HIT();
             }
          }

          if(dealerUpcard.getValue() <= 7) {
              description = "Split 2's and 3's up through 7";
              return new SPLIT();
          }

          if(dealerUpcard.getValue() >7) {
              description = "Keep 2's and 3's together vs. 8 and up";
              return new HIT();
          }

          return new HIT();
    }
}