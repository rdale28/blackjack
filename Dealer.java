

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
    if (deckPosition >= masterDeck.length) {
      Deck.shuffleDeck(6, masterDeck);
      deckPosition = 0;
    }
    return masterDeck[deckPosition++];
  }

  public int checkIfBust(Hand hand) {
    int total = Deck.getPoints(hand.getCardOne());
    total += Deck.getPoints(hand.getCardTwo());

    if (hand.getCardThree() != null) {
      total += Deck.getPoints(hand.getCardThree());
    }
    if (hand.getCardFour() != null) {
      total += Deck.getPoints(hand.getCardFour());
    }
    if (hand.getCardFive() != null) {
      total += Deck.getPoints(hand.getCardFive());
    }
    if (hand.getCardSix() != null) {
      total += Deck.getPoints(hand.getCardSix());
    }

    return total;

  }

}
