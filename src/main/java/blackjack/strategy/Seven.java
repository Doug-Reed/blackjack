package blackjack.strategy;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;
public class Seven implements StrategyChart {

    private String description = "Player 7";

    public String description() {
        return description;
    }
    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard){
         
          description = "You're going to stand on a 7? Seriously?";
          return new HIT();
    }
}