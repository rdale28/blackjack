
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BlackJack extends JPanel {
  public BlackJack() {
    super(new GridLayout(5, 1));

    JPanel actions = new JPanel();
    String[] params = {"Deal", "Hit", "Stay", "Quit"};
    Functions f = new Functions();
    actions = f.panelRow(params);

    Dealer dealer = new Dealer();

    add(text);
    add(actions);

  }

  public static JTextArea text = new JTextArea(5,5);

  public static void main(String[] args) {

    JFrame frame = new JFrame("BlackJack");
    // JFrame instructions = new JFrame("Instructions");

    frame.setSize(600, 450);
    // instructions.setSize(600, 400);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new BlackJack());
    frame.setVisible(true);

  }
}
