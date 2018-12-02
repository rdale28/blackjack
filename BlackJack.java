
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BlackJack extends JPanel {

  public static void main(String[] args) {
    artificialplayer ap = new artificialplayer("Hello");
    Dealer dealer = new Dealer();

    dealer.printDeck();

  }
}
