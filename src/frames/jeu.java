package frames;

import entities.*;
import javax.swing.*;
import java.awt.*;

public class jeu extends JFrame {
    public jeu() {
        super("BlackJack");
        Game game = new Game();
        this.setSize(800, 600);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        JPanel principal = new JPanel();
        principal.setLayout(new BoxLayout(principal, 3));

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 3));
        JLabel count = new JLabel("Compteur : "+game.getCount());
        JLabel true_count = new JLabel("True Compteur : "+game.getTrue_count());
        JLabel decks = new JLabel("Nombre de decks : "+(8 - game.getCount_cards() / 52));
        top.add(count);
        top.add(true_count);
        top.add(decks);

        principal.add(top);

        JPanel player_cards = new JPanel();
        player_cards.setLayout(new BoxLayout(player_cards, 3));
        JComboBox<String> first_card = new JComboBox<String>();
        first_card.addItem("2");
        first_card.addItem("3");
        first_card.addItem("4");
        first_card.addItem("5");
        first_card.addItem("6");
        first_card.addItem("7");
        first_card.addItem("8");
        first_card.addItem("9");
        first_card.addItem("10");
        first_card.addItem("J");
        first_card.addItem("Q");
        first_card.addItem("K");
        first_card.addItem("A");

        JComboBox<String> second_card = new JComboBox<String>();
        second_card.addItem("2");
        second_card.addItem("3");
        second_card.addItem("4");
        second_card.addItem("5");
        second_card.addItem("6");
        second_card.addItem("7");
        second_card.addItem("8");
        second_card.addItem("9");
        second_card.addItem("10");
        second_card.addItem("J");
        second_card.addItem("Q");
        second_card.addItem("K");
        second_card.addItem("A");

        player_cards.add(first_card);
        player_cards.add(second_card);

        JButton more = new JButton("More Cards");
        more.addActionListener(actionEvent -> {
            JComboBox<String> card = new JComboBox<String>();
            card.addItem("2");
            card.addItem("3");
            card.addItem("4");
            card.addItem("5");
            card.addItem("6");
            card.addItem("7");
            card.addItem("8");
            card.addItem("9");
            card.addItem("10");
            card.addItem("J");
            card.addItem("Q");
            card.addItem("K");
            card.addItem("A");
            player_cards.add(card);
        });

        JButton less = new JButton("Less Cards");
        less.addActionListener(actionEvent -> {
            player_cards.remove(player_cards.getComponentCount() - 1);
        });

        player_cards.add(more);
        player_cards.add(less);

        principal.add(player_cards);

        JPanel dealer_cards = new JPanel();
        dealer_cards.setLayout(new BoxLayout(dealer_cards, 3));

        JComboBox<String> first_card_dealer = new JComboBox<String>();
        first_card_dealer.addItem("2");
        first_card_dealer.addItem("3");
        first_card_dealer.addItem("4");
        first_card_dealer.addItem("5");
        first_card_dealer.addItem("6");
        first_card_dealer.addItem("7");
        first_card_dealer.addItem("8");
        first_card_dealer.addItem("9");
        first_card_dealer.addItem("10");
        first_card_dealer.addItem("J");
        first_card_dealer.addItem("Q");
        first_card_dealer.addItem("K");
        first_card_dealer.addItem("A");

        dealer_cards.add(first_card_dealer);

        principal.add(dealer_cards);

        JButton play = new JButton("Calculate");

        play.addActionListener(actionEvent -> {
            String result = game.strategy();
            JOptionPane.showMessageDialog(null, result);
        });

        principal.add(play);

        this.getContentPane().add(principal);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new jeu();
    }
}
