import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Deck {

  String[] SUITS = {
            "C", "D", "H", "S"
        };

  String[] RANKS = {
      "2", "3", "4", "5", "6", "7", "8", "9", "10",
      "J", "Q", "K", "A"
  };

  int n = SUITS.length * RANKS.length;
  String[] deck = new String[n];

  public Deck() {

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
  }

  public String[] getDeck() {
    return deck;
  }

  public static String[] combineDecks(String[] first, String[] second) {
    String[] response = Stream.concat(Arrays.stream(first), Arrays.stream(second)).toArray(String[]::new);
    return response;
  }

  public static int getPoints(String card) {
    if (card.contains("2"))
      return 2;
    else if (card.contains("3"))
      return 3;
    else if (card.contains("4"))
      return 4;
    else if (card.contains("5"))
      return 5;
    else if (card.contains("6"))
      return 6;
    else if (card.contains("7"))
      return 7;
    else if (card.contains("8"))
      return 8;
    else if (card.contains("9"))
      return 9;
    else if (card.contains("10") || card.contains("J") || card.contains("Q") || card.contains("K"))
      return 10;
    else if (card.contains("A"))
      return 11;

    return -1;
  }

}
