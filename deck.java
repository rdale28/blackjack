import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class deck {

  String[] SUITS = {
            "C", "D", "H", "S"
        };

  String[] RANKS = {
      "2", "3", "4", "5", "6", "7", "8", "9", "10",
      "J", "Q", "K", "A"
  };

  int n = SUITS.length * RANKS.length;
  String[] deck = new String[n];

  public deck() {

    for (int i = 0; i < RANKS.length; i++) {
      for (int j = 0; j < SUITS.length; j++) {
          deck[SUITS.length*i + j] = RANKS[i] + "" + SUITS[j];
      }
    }
  }

  public static void shuffleDeck(int decks, String[] deck) {
    int n = 52 * decks;
    for (int i = 0; i < n; i++) {
    int r = i + (int) (Math.random() * (n-i));
    String temp = deck[r];
    deck[r] = deck[i];
    deck[i] = temp;
    }
  }

  public static void printDeck(String[] deck) {
    for (int i = 0; i < deck.length; i++) {
      System.out.println(deck[i]);
    }
    System.out.println(deck.length);
  }

  public String[] getDeck() {
    return deck;
  }

  public static String[] combineDecks(String[] first, String[] second) {
    String[] response = Stream.concat(Arrays.stream(first), Arrays.stream(second)).toArray(String[]::new);
    return response;
  }

}
