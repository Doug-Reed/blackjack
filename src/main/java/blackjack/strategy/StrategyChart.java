package blackjack.strategy;

import blackjack.action.PlayerAction;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.model.Card;

public interface StrategyChart{
    public PlayerAction correctPlay(HouseRules rules, DiscardTray tray, Hand playerHand, Card dealerUpcard);
    public String description();
}