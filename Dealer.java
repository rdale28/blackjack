

public class Dealer {

  public String[] masterDeck = null;
  private int deckPosition;
  public Hand hand;

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
    deckPosition = 0;
    hand = new Hand();
  }

  public void printDeck() {
    Deck.printDeck(masterDeck);
  }

  public int getDeckPosition() {
    return deckPosition;
  }

  public String deal() {
    return masterDeck[deckPosition++];
  }

}
