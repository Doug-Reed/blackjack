package headsUpSim.game;

import java.util.ArrayList;



import blackjack.model.CardFactory;
import blackjack.model.Deck;
import blackjack.model.DiscardTray;
import blackjack.model.Hand;
import blackjack.rules.HouseRules;
import blackjack.strategy.StrategyChart;
import blackjack.strategy.StrategyChartFactory;
import blackjack.action.BLACKJACK;
import blackjack.action.DOUBLE;
import blackjack.action.HIT;
import blackjack.action.PlayerAction;
import blackjack.action.SPLIT;
import blackjack.action.STAND;
import blackjack.action.SURRENDER;
import blackjack.model.Card;
import headsUpSim.game.APlayer;

public class Game {
        APlayer dogchip = new APlayer();      
        APlayer baron = new APlayer();

        int bet = 0;
        Deck shoe;
        DiscardTray discardTray = new DiscardTray();
        StrategyChartFactory factory = new StrategyChartFactory();
        HouseRules houseRules = new HouseRules();

    public Game() {
        gameSetup();
    }

    public void gameSetup() {
       CardFactory factory = new CardFactory();
       shoe = factory.getSixDecks();
    }
    
    public void iterateThroughRounds() {
       for (int i = 0; i < 5; i++) {
           System.out.println("In the loop");
           shoe.shuffle();
           APlayer player = dogchip;
           playRound(player);
           discardTray.reset(shoe);
           player = baron;
           playRound(player);
       }
    }

    
    public double calculateBet(DiscardTray tray) {
        if(tray.trueCount()< -10) return 0;
        if(tray.trueCount()> 6) return 125;
        switch(tray.trueCount()) {
            case -10:
            case -9:
            case -8:
            case -7:
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
                 return 0;
            case -1:
                return 5;
            case 0:
                 return 10;
            case 1:
                return 15;
            case 2:
                return 25;
            case 3:
                return 50;
            case 4:
                return 75;
            case 5:
                return 100;
            case 6:
                return 125;
            default:
                return 0;
        }
    }
    public void playRound(APlayer player){
        
        Hand dealer = new Hand();
        ArrayList<Hand> playerHands = new ArrayList<Hand>();
        playerHands.add(new Hand());
        Hand playerInitialHand = playerHands.get(0);
        playerInitialHand.addToHand(shoe.draw());
        dealer.addToHand(shoe.draw());
        playerInitialHand.addToHand(shoe.draw());
        dealer.addToHand(shoe.draw());

        double bet = calculateBet(discardTray);
        playerInitialHand.setBet(bet);

        if(dealer.dealerUpcard().getValue() == 11) {
            if(discardTray.trueCount() >=3 ){
                if(dealer.valueOfHand()!= 21){
                    player.impactBankroll(bet * -.5);
                } 
            }
            playerInitialHand.isResolved();  
        }
        
        StrategyChart chart = StrategyChartFactory.getCorrectPlay(playerInitialHand);
        PlayerAction action = chart.correctPlay(houseRules, discardTray,playerInitialHand, dealer.dealerUpcard());
        
        boolean canSplit = false;
        if(action.getClass().isInstance(SPLIT.class) && !playerInitialHand.isResolved()){
            canSplit = true;
        }
        int splitCount = 0;
        while(canSplit) {
            for(Hand h: playerHands) {
                PlayerAction hAction = chart.correctPlay(houseRules, discardTray, h, dealer.dealerUpcard());
                if(hAction.getClass().isInstance(SPLIT.class)){
                    splitCount++;
                    if(splitCount> houseRules.numberOfSplits){
                        h.noSplit();
                        canSplit = false;
                    } else {
                        playerHands = resolveSplits(playerHands, dealer.dealerUpcard());
                    }
                }
            }
            canSplit = false;
            for(Hand h: playerHands) {
                PlayerAction hAction = chart.correctPlay(houseRules, discardTray, h, dealer.dealerUpcard());
                if(hAction.getClass().isInstance(SPLIT.class)){
                    canSplit = true;
                }
            }
        }
//Done with splits

       for (Hand h:playerHands) {
           while(!h.isResolved()) {
             PlayerAction hAction = chart.correctPlay(houseRules, discardTray, h, dealer.dealerUpcard());
                if(hAction.getClass().isInstance(BLACKJACK.class)){
                    h.resolveHand();
                };

                if(hAction.getClass().isInstance(STAND.class)){
                    h.resolveHand();
                };

                if(hAction.getClass().isInstance(DOUBLE.class)) {
                     Double doubleBet = h.getBet() * 2;
                     h.setBet(doubleBet);
                     h.addToHand(shoe.draw());
                     h.resolveHand();
                }

                if(hAction.getClass().isInstance(SURRENDER.class)) {
                     Double halfBet = h.getBet() * .5;
                     h.setBet(halfBet); 
                     h.resolveHand();
                }

                if(hAction.getClass().isInstance(HIT.class)) {
                    h.addToHand(shoe.draw());
                }
           }
       } 

       for(Hand h:playerHands) {
            PlayerAction hAction = chart.correctPlay(houseRules, discardTray, h, dealer.dealerUpcard());
            if(hAction.getClass().isInstance(SURRENDER.class)){
                player.impactBankroll(h.getBet() *-1);
            } else {
               
            }
       }     
    }
 

public ArrayList<Hand> resolveSplits(ArrayList<Hand> playerHands, Card upcard) {
     for(Hand h: playerHands) {
        if(h.isPair()){
           StrategyChart chart = factory.getCorrectPlay(h);
           PlayerAction action = chart.correctPlay(houseRules, discardTray,h, upcard);
           if(action.getClass().isInstance(SPLIT.class)){
                Card c = h.removeCard();
                Hand j = new Hand();
                j.addToHand(c);
                h.addToHand(shoe.draw());
                j.addToHand(shoe.draw());
                playerHands.add(j);
           }
           if(action.getClass().isInstance(STAND.class)){
               h.resolveHand();
           }
       }
    }
    return playerHands;
}

    public void playHand() {

    }
}