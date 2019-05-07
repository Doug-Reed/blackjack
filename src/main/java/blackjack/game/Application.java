package blackjack.game;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import blackjack.model.CardFactory;
import blackjack.model.Deck;
import headsUpSim.game.Game;
import blackjack.model.Card;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Game game = new Game();
        game.iterateThroughRounds();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's play blackjack!");
                    CardFactory cardFactory = new CardFactory();
        Deck deck = cardFactory.getFullDeck();
        deck.shuffle();
        Card c = deck.draw();
        System.out.println("You drew " + c); 

        };
    }

}