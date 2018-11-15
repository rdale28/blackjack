
public class blackjack {

  public static void main(String[] args) {
    artificialplayer ap = new artificialplayer("Hello");
    String[] masterDeck = null;
    deck[] decks = new deck[6];
    for (int i = 0; i < 6; i++) {
      decks[i] = new deck();
    }

    for (int i = 0; i < 6; i+=2) {
      masterDeck = deck.combineDecks(decks[i].getDeck(), decks[i+1].getDeck());
    }

    deck.shuffleDeck(6, masterDeck);
    deck.printDeck(masterDeck);
  }
}
