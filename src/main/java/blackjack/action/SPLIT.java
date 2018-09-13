package blackjack.action;

import blackjack.model.Table;

public class SPLIT extends PlayerAction {
    @Override
    public void go(Table table) {

    }

    @Override
    public String actionIs() {
        return "SPLIT";
    }
}