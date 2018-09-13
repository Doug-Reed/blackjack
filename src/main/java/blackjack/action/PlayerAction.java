package blackjack.action;

import blackjack.model.Table;
public abstract class PlayerAction {

    public String actionIs(){
        return "abstract";
    }
    public void go(Table table) {}
}