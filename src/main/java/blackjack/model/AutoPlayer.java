package blackjack.model;

import blackjack.action.PlayerAction;
import blackjack.strategy.StrategyChart;
import blackjack.strategy.StrategyChartFactory;

public class AutoPlayer implements Player {
     private int bankroll;
     private int bet;
     private int numberOfHands;
     private Hand[] hand;
     private PlayerAction action;
     private Seat seat;
     private BetSpread betSpread;
     
     public Hand hand(int whichHand){
        return hand[whichHand];
     }

     public int bet() {
         int trueCount = seat.getTable().getDiscardTray().trueCount();
         bet = betSpread.getBet(trueCount);
         bankroll -= bet;
         return bet;  
     }
     public void resolveBet(int resolveBet) {
         bet += resolveBet;
         bankroll += bet;
     }
     public void resetHand() {
         hand = new Hand[1];
         hand[0] = new Hand();
     }
     public AutoPlayer() {
         betSpread = new BetSpread();
         bankroll = 1000;
         numberOfHands = 1;
         hand[1] = new Hand();
     }

     public PlayerAction action(int whichHand) {
        StrategyChart strategyChart =  StrategyChartFactory.getCorrectPlay(hand[whichHand]);
        Table thisTable = seat.getTable();
        PlayerAction playerAction = strategyChart.correctPlay(thisTable.getRules(), thisTable.getDiscardTray(), hand[whichHand], thisTable.getDealer().dealerUpcard());
        return playerAction;    
    }

     public int numberOfHands() {
         return numberOfHands;
     }
}