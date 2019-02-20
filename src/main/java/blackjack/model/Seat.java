package blackjack.model;

public class Seat {
    private Table table;
    private Player player;
    private int bet;

    public Seat (Table table) {
        this.table = table;
    }

    public boolean hasPlayer() {
        if(player instanceof Player) {
            return true;
        }

        return false;
    }

    public Player getPlayer() {
        return this.player; 
    }

    public Seat sit(Player player) {
        this.player = player;
        return this;
    }
    public Table getTable(){
        return table;
    }
}