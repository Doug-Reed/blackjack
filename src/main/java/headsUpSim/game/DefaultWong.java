package headsUpSim.game;

import blackjack.model.DiscardTray;

public class DefaultWong implements Wong {
    public boolean wongIn(DiscardTray discardTray){
        return true;
    }

    public boolean wongOut(DiscardTray discardTray, APlayer player) {
        return false;
    }
}