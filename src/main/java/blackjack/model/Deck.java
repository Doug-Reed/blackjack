package blackjack.model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards = new ArrayList<Card>();
    private int cardIndex = 0;

    public void addCards(ArrayList<Card> theCards) {
        cards.addAll(theCards);
    }

    public void shuffle(){
        Collections.shuffle(cards);
        cardIndex = 0;
    }

    public Card draw(){
        try {
            Card retVal = cards.get(cardIndex);
            cardIndex++;
            System.out.println("Drew " + retVal.toString());
            return retVal;
        } catch (Exception e) {
            return null;
        }
    }
}