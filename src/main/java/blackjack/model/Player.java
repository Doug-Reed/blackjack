package blackjack.model;

import blackjack.action.PlayerAction;

public interface Player {
     public int bet();

     public void resolveBet(int resolveBet);
     public int numberOfHands();
     public Hand hand(int whichHand);

    public PlayerAction action(int whichHand);
}