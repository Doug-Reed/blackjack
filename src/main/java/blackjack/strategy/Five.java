package blackjack.strategy;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;
public class Five implements StrategyChart {

    private String description = "Player 5";

    public String description() {
        return description;
    }
    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard){
         
          description = "You're going to stand on a 5? Are you nuts? Hit! Hit!";
          return new HIT();
    }
}