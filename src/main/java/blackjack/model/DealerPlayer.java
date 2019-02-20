package blackjack.model;

import blackjack.action.PlayerAction;
public class DealerPlayer implements Player {
    private Dealer dealer;
     public int bet(){
         return 0;
     }

     public void resolveBet(int resolveBet){
         
     }
     public int numberOfHands(){
         return 1;
     }
     public Hand hand(int whichHand){
         return null;
     }

     public void resetHand(){

     }

    public PlayerAction action(int whichHand){
        return null;
    }
}