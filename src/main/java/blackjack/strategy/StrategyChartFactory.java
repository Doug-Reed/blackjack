package blackjack.strategy;

import  blackjack.model;

public class StrategyChartFactory {
    public static StrategyChart getCorrectPlay (Hand playerHand) {
        switch (playerHand.valueOfHand()) {
            case 4:
                return new Four();
                break;
            case 5:
                return new Five();
                break; 
            case 6:
                return new SIX();
                break;
            case 7:
                return new Seven();
                break;     
            case 8:
                return new Eight();
                break;
            case 9:
                return new Nine();
                break; 
            case 10:
                return new Ten();
                break;
            case 11:
                return new Eleven();
                break;
            case 12:
                return new Twelve();
                break;
            case 13:
                return new Thirteen();
                break; 
            case 14:
                return new Fourteen();
                break;
            case 15:
                return new Fifteen();
                break;     
            case 16:
                return new Sixteen();
                break;
            case 17:
                return new Seventeen();
                break; 
            case 18:
                return new Eighteen();
                break;
            case 19:
                return new Nineteen();
                break;   
            case 20:
                return new Twenty();
                break;
            case 21:
                return new TwentyOne();
                break;                                                  
            default:
                return null;
                break;
        }
    }
}