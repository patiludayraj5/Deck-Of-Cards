import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static void main(String[] args) {
        List<String> deck = initializeDeck();
        shuffleDeck(deck);

        // Number of players and cards to distribute
        int numPlayers = 4;
        int cardsPerPlayer = 9;

        // 2D array to store cards for each player
        String[][] playersCards = new String[numPlayers][cardsPerPlayer];

        // Distribute cards to players
        distributeCards(deck, numPlayers, cardsPerPlayer, playersCards);

        // Print cards received by each player
        printPlayerCards(playersCards);
    }

    private static List<String> initializeDeck() {
        List<String> deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(rank + " of " + suit);
            }
        }
        return deck;
    }

    private static void shuffleDeck(List<String> deck) {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    private static void distributeCards(List<String> deck, int numPlayers, int cardsPerPlayer, String[][] playersCards) {
        int cardIndex = 0;
        for (int player = 0; player < numPlayers; player++) {
            for (int card = 0; card < cardsPerPlayer; card++) {
                playersCards[player][card] = deck.get(cardIndex++);
            }
        }
    }

    private static void printPlayerCards(String[][] playersCards) {
        for (int player = 0; player < playersCards.length; player++) {
            System.out.println("Player " + (player + 1) + " cards:");
            for (int card = 0; card < playersCards[player].length; card++) {
                System.out.println(playersCards[player][card]);
            }
            System.out.println();
        }
    }
}
