package blackjack.strategy;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;
import blackjack.action.PlayerAction;
public class Insurance implements StrategyChart {
    public String description(){
        return "Take the Insurance at or above a 3.";
    }
     public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard) {
       return null;
     }     
}