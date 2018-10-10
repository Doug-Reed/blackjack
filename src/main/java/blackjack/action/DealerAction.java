package blackjack.action;

import blackjack.model.Table;
public abstract class DealerAction {

    public String actionIs(){
        return "abstract";
    }
    public void go(Table table) {}
}