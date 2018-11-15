package blackjack.action;

import blackjack.model.Table;
import blackjack.model.Player;
public abstract class PlayerAction {

    public String actionIs(){
        return "abstract";
    }
    public void go(Table table, Player player) {}
}