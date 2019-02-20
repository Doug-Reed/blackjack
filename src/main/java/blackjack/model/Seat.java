package blackjack.model;

public class Seat {
    private Table table;
    private Player player;
    private int bet;

    public Seat (Table table) {
        this.table = table;
    }

    public Seat sit(Player player) {
        this.player = player;
        return this;
    }
    public Table getTable(){
        return table;
    }
}