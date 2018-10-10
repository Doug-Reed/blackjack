package blackjack.model;

import java.util.ArrayList;

public class ChipStack{
    private ArrayList<Chip> chips = new ArrayList<Chip>();

    public void initialize(int numberOfUnits) {
        chips = new ArrayList<Chip>();
        for(int x =0; x<= numberOfUnits; x++) {
            chips.add(new Chip());
        }
    }

    public ChipStack() {

    }

    public ChipStack(int numberOfUnits) {
        initialize(numberOfUnits);
    }

    public int size() {
        return chips.size();
    }

    public ChipStack bet(int numberOfUnits) {
         for(int y = 0; y <= (numberOfUnits-1);y++ ){
             System.out.println("Betting " + numberOfUnits + ". " + chips.size() + " remaining.");
             chips.remove(chips.size()-1);
         }
         return new ChipStack(numberOfUnits);
    }


}