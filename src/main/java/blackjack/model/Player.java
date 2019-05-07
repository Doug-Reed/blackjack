package blackjack.model;

import java.util.ArrayList;

import blackjack.action.PlayerAction;

public interface Player {

    public ArrayList<Hand> myHands();
     public int bet();

     public void addToHand(Card c);

     public void resolveBet(int resolveBet);
     public int numberOfHands();
     public Hand hand(int whichHand);

     public void resetHand();

    public PlayerAction action(int whichHand);
}