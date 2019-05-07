package headsUpSim.game;

import blackjack.model.DiscardTray;

public interface Wong {
    public boolean wongIn(DiscardTray discardTray);

    public boolean wongOut(DiscardTray discardTray, APlayer player);
}