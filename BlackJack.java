
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BlackJack extends JPanel {

  public static void main(String[] args) {
    artificialplayer ap = new artificialplayer("Hello");
    Dealer dealer = new Dealer();
    Player player = new Player();

    for (int i = 0; i < dealer.masterDeck.length - 20;) {
      //Deal the first cards to dealer and player
      player.hand.setCardone(dealer.deal());
      dealer.hand.setCardone(dealer.deal());

      //Deal the second card to dealer and player
      player.hand.setCardTwo(dealer.deal());
      dealer.hand.setCardTwo(dealer.deal());

      //Show dealer card
      System.out.println("Dealer Cards:");
      System.out.println(dealer.hand.getCardOne());

      //Show Player card
      System.out.println("Player cards:");
      System.out.println(player.hand.getCardOne());
      System.out.println(player.hand.getCardTwo());

      i = dealer.getDeckPosition();
    }

  }
}
