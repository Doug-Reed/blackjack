package blackjack.model;

public class BetSpread {
    private int unit = 5;
    public int getBet(int trueCount) {
       if(trueCount < -2) {
           return 0;
       }
       
       if(trueCount <= -1) {
           return 1;
       }

      int multiplier = trueCount + 1;
      return unit * multiplier;
    }
}