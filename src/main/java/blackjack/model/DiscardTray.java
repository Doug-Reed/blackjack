package blackjack.model;

import java.util.ArrayList;

public class DiscardTray {

    private int numberOfDecks;
    private ArrayList<Card> discarded = new ArrayList<Card>();

    public void setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
    }

    public void discard(ArrayList<Card> discards) {
        discarded.addAll(discards);
    }

    public int trueCount() {
        double decksDiscardedExact = discarded.length()/ 52;
        int decksDiscardedFloored = (int) decksDiscardedExact;

        double rawDivide = runningCount()/decksDiscardedFloored;

        int returnVal = (int) rawDivide;

        return returnVal;
    }

    public int runningCount() {
        int runningCount = 0;
        for (Card card : discarded) {
            if (card.getValue() < 7) {
                runningCount++;
            }
            if (card.getValue() > 9) {
                runningCount--;
            }
        }

        return runningCount;
    }
}