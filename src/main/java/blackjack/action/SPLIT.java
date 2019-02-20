package blackjack.action;

import blackjack.model.Table;
import blackjack.model.Player;
public class SPLIT extends PlayerAction {
    @Override
    public void go(Table table, Player Player) {

    }

    @Override
    public String actionIs() {
        return "SPLIT";
    }
}