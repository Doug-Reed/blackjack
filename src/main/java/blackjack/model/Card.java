package blackjack.model;

public class Card {
    private Suit suit;
    private int value;
    private String name;

    public Suit getSuit(){
        return this.suit;
    }

    public int getValue(){
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setValue (int value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name + " of " + this.suit;
    }

}