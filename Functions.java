import javax.swing.*;
import java.awt.event.*;

public class Functions {

  static Dealer dealer = new Dealer();
  static Player player = new Player();

  public JPanel panelRow(String params[]) {
      JButton[] buttons = new JButton[4];

      for (int i = 0; i < params.length; i++) {
          buttons[i] = newButton(params[i]);
          buttons[i].addActionListener(new newActionListener());
      }
      return panelAdd(buttons);
  }

  private JButton newButton(String text) {
    JButton button_one = new JButton(text);
    return button_one;
  }

  private JPanel panelAdd(JButton[] buttons) {
    JPanel panel = new JPanel();
    for (int i = 0; i < buttons.length; i++) {
      panel.add(buttons[i]);
    }
    return panel;
  }

  private static class newActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {

      if (e.getActionCommand().equals("Deal")) {
        player.hand = new Hand();
        dealer.hand = new Hand();

        player.hand.setCardone(dealer.deal());
        dealer.hand.setCardone(dealer.deal());

        //Deal the second card to dealer and player
        player.hand.setCardTwo(dealer.deal());
        dealer.hand.setCardTwo(dealer.deal());

        BlackJack.text.setText("Your Total:" + dealer.checkIfBust(player.hand) + "\nDealer total: " + dealer.checkIfBust(dealer.hand));
      }
      if (e.getActionCommand().equals("Hit")) {
        if (player.hand.getCardThree() == null) {
          player.hand.setCardThree(dealer.deal());
          System.out.println(player.hand.getCardThree());
        } else if (player.hand.getCardFour() == null) {
          player.hand.setCardFour(dealer.deal());
        } else if (player.hand.getCardFive() == null) {
          player.hand.setCardFive(dealer.deal());
        } else if (player.hand.getCardSix() == null) {
          player.hand.setCardSix(dealer.deal());
        }

        if (dealer.checkIfBust(player.hand) > 21) {
          BlackJack.text.setText("You Lose!\nHouse wins.");
        } else {
          BlackJack.text.setText("Your Total:" + dealer.checkIfBust(player.hand) + "\nDealer total: " + dealer.checkIfBust(dealer.hand));
        }

      }
      if (e.getActionCommand().equals("Stay")) {
        BlackJack.text.setText("Stay!");

        int dealerTotal = dealer.checkIfBust(dealer.hand);
        int playerTotal = dealer.checkIfBust(player.hand);

        while (playerTotal > dealerTotal) {
          if (dealer.hand.getCardThree() == null) {
            dealer.hand.setCardThree(dealer.deal());
          } else if (dealer.hand.getCardFour() == null) {
            dealer.hand.setCardFour(dealer.deal());
          } else if (dealer.hand.getCardFive() == null) {
            dealer.hand.setCardFive(dealer.deal());
          } else if (dealer.hand.getCardSix() == null) {
            dealer.hand.setCardSix(dealer.deal());
          }
          dealerTotal = dealer.checkIfBust(dealer.hand);
        }

        if (dealerTotal > 21) {
          BlackJack.text.setText("You Win!\nHouse loses.");
        } else if (dealerTotal == playerTotal) {
          BlackJack.text.setText("You Tied!\nNo one wins.");
        } else if (dealerTotal > playerTotal) {
          BlackJack.text.setText("You Lose!\nHouse wins.");
        }

      }
      if (e.getActionCommand().equals("Quit")) {
        System.exit(0);
      }
    }
  }

}
