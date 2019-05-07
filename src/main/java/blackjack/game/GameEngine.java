package blackjack.game;

import java.math.BigInteger;

import blackjack.model.CardFactory;

import blackjack.model.Player;
import blackjack.model.Table;
import blackjack.rules.HouseRules;

public class GameEngine {
  public void headToHead() {
    Table table = new Table();
    HouseRules houseRules = new HouseRules();
    System.out.println("Head to head");
    //setup rules
    table.setupTable(houseRules);

  };
  //Round
  //Deal
  //Per player, get action
  //If action = split 
     // make new hand(s)
  //Draw own hand
  //Give payouts
};