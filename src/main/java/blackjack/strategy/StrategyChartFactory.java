package blackjack.strategy;

import  blackjack.model.Hand;

public class StrategyChartFactory {
    public static StrategyChart getCorrectPlay (Hand playerHand) {
        switch (playerHand.valueOfHand()) {
            case 4:
                return new Four();
            case 5:
                return new Five();
            case 6:
                return new SIX();
            case 7:
                return new Seven();    
            case 8:
                return new Eight();
            case 9:
                return new Nine();
            case 10:
                return new Ten();
            case 11:
                return new Eleven();
            case 12:
                return new Twelve();
            case 13:
                return new Thirteen();
            case 14:
                return new Fourteen();
            case 15:
                return new Fifteen();    
            case 16:
                return new Sixteen();
            case 17:
                return new Seventeen();
            case 18:
                return new Eighteen();
            case 19:
                return new Nineteen();  
            case 20:
                return new Twenty();
            case 21:
                return new TwentyOne();                                               
            default:
                return new Bust();
        }
    }
}