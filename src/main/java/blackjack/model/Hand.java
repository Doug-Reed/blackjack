package blackjack.model;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>();

    public void addToHand(Card c) {
        hand.add(c);
    }

    public int size(){
        return hand.size();
    }
    @Override
    public String toString() {
        String retVal = "";
        for(Card c: hand) {
            retVal = retVal + " " + c.toString();
        }

        retVal = retVal + " Value: " + valueOfHand();
        return retVal;
    }

    public int valueOfHand() {
   
         int value = 0;
         ArrayList<Card> aces = new ArrayList<Card>();

         for (Card card: hand) {
             value += card.getValue();
             if(card.getName().equalsIgnoreCase("ACE")){
                 aces.add(card);
             }
        }

        if (value > 21) {
            for(Card ace: aces) {
                value = value - 10;
                if(value < 21) {
                    return value;
                }
            }
        }

        return value;
    }
}