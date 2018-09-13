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
        return 0;
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