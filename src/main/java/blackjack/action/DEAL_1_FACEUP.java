package blackjack.action;
import blackjack.model.Hand;
import blackjack.model.Player;
import blackjack.model.Table;

public class DEAL_1_FACEUP extends DealerAction {
    @Override
    public void go(Table table, Player player) {
       for(int i=0; i < player.numberOfHands(); i++){
           Hand hand = player.hand(i);
           hand.addToHand(table.draw());
       }
    }
}