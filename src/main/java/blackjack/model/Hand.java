package blackjack.model;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private boolean soft = false;

    public void addToHand(Card c) {
        hand.add(c);
    }

    public boolean firstTwoCards() {
        if(hand.size() ==2) {
            return true;
        }

        return false;
    }

    public boolean isSoft() {
         int theLogicIsInTheOtherMethodSoIWillMakeAUselessVariableNameHere = valueOfHand();
         return this.soft;
    }

    public boolean isPair() {

        if (hand.size() != 2) {
            return false;
        }

        if (hand.get(0).getValue() == hand.get(1).getValue()) {
            return true;
        }

        return false;
    }

    public int size() {
        return hand.size();
    }

    @Override
    public String toString() {
        String retVal = "";
        for (Card c : hand) {
            retVal = retVal + " " + c.toString();
        }

        retVal = retVal + " Value: " + valueOfHand();
        return retVal;
    }

    public int valueOfHand() {

        int value = 0;
        ArrayList<Card> aces = new ArrayList<Card>();

        for (Card card : hand) {
            value += card.getValue();
            if (card.getName().equalsIgnoreCase("ACE")) {
                soft = true;
                aces.add(card);
            }
        }

        if (value > 21) {
            int aceCount = aces.size();
            for (Card ace : aces) {
                aceCount--;
                value = value - 10;
                if (aceCount == 0) {
                    soft = false;
                }

                if (value < 21) {
                    return value;
                }
            }
        }

        return value;
    }

}