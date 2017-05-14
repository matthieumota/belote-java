package com.boxydev.belote;

import com.boxydev.belote.card.CardPackage;
import com.boxydev.belote.gui.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame implements ActionListener {
    private JMenuBar menu = new JMenuBar();
    private Board board = new Board();

    private CardPackage cards = new CardPackage();
    private Player player = new Player();
    private List<Player> bots = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private Integer distributor = 0;

    public App() {
        setTitle("Belote");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(menu);
        JMenuItem close = new JMenuItem("Fermer");
        menu.add(close);
        close.addActionListener(this);
        setContentPane(board);
        setVisible(true);
    }

    public void run() {
        // Generate player
        player.askName();
        // player.setName("Matthieu");

        // Generate bots
        for (int i = 1; i < 4; i++) {
            bots.add(new Bot());
        }

        // Organize player and bots in players list
        players.add(player);
        players.addAll(bots);

        // Mixing cards and cut
        // @todo Maybe ask to current distributor n for cut
        cards.mixing();
        cards.cut();

        for (int i = 0; i < 4; i++) {
            distributor++;
            if (distributor > 3) distributor = 0;
            cards.distribute(players.get(distributor), 3); // Give 3 cards next distributor
        }

        board.addPlayers(players);
        /*Card cardPlaying = null;
        while(cardPlaying == null) {
            cardPlaying = board.getCardPlaying();
            System.out.println(cardPlaying);
        }*/
        System.out.println("Lance l'application");
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }
}
