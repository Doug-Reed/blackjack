package headsUpSim.game;

public class APlayer {
    private long EV = 0;
    private long AV = 0;
    private long handsWon = 0;
    private long handsLost = 0;
    private long handsPushed = 0;
    private long bankroll = 10000;
    private long highThisShoe;
    private long lowThisShoe;
    private Wong wong = new DefaultWong();

    public void setWong(Wong wong){
        this.wong = wong;
    }

    public void newShoe(){
        highThisShoe = bankroll;
        lowThisShoe = bankroll;
    }

    public void win(){
        handsWon++;
    }

    public void lose(){
        handsLost++;
    }

    public void push(){
        handsPushed++;
    }

    public void addToEV(long moreEV){
        this.EV += moreEV;
    }

    public void addToAV(long moreAV){
        this.AV += moreAV;
    }

    public void impactBankroll(double wonLost){
        this.bankroll += wonLost;
        if(bankroll > highThisShoe){
            highThisShoe = bankroll;
        }

        if(bankroll < lowThisShoe){
            lowThisShoe = bankroll;
        }
    }
}