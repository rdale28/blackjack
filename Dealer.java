

public class Dealer {

  public String[] masterDeck = null;

  public Dealer() {
    Deck[] decks = new Deck[6];
    for (int i = 0; i < 6; i++) {
      decks[i] = new Deck();
    }

    masterDeck = decks[0].getDeck();
    for (int i = 1; i < 6; i++) {
      masterDeck = Deck.combineDecks(masterDeck, decks[i].getDeck());
    }

    Deck.shuffleDeck(6, masterDeck);
  }

  public void printDeck() {
    Deck.printDeck(masterDeck);
  }

}
