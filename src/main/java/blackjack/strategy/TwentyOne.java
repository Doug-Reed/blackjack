package blackjack.strategy;
import blackjack.action.PlayerAction;
import blackjack.action.STAND;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;
public class TwentyOne implements StrategyChart {

    private String description = "Player 21";

    public String description() {
        return description;
    }
    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard){
         
          description = "Stand on a 21.";
          return new STAND();
    }
}