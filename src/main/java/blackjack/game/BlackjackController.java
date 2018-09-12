package blackjack.game;

import org.springframework.web.bind.annotation.RestController;

import blackjack.model.CardFactory;
import blackjack.model.Deck;
import blackjack.model.Card;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BlackjackController {
    
    @RequestMapping("/")
    public String index() {
        CardFactory cardFactory = new CardFactory();
        Deck deck = cardFactory.getFullDeck();
        deck.shuffle();
        Card c = deck.draw();
        return "You drew " + c;
    }
    
}