package com.boxydev.belote;

import com.boxydev.belote.card.CardPackage;
import com.boxydev.belote.gui.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App extends JFrame implements ActionListener {
    private JMenuBar menu = new JMenuBar();
    private Board board = new Board();
    private CardPackage cards = new CardPackage();
    private Player player = new Player();
    private List<Player> bots = new ArrayList<>();
    private Player distributor;
    private List<Player> players = new ArrayList<>();

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
        cards.mixing();
        cards.cut();
        player.setName("Matthieu");
        player.setPosition(0);
        for (int i = 1; i < 4; i++) {
            bots.add(new Player("Bot "+i, i));
        }
        players.add(player);
        players.addAll(bots);

        Random random = new Random();
        distributor = players.get(random.nextInt(4));
        distributor.distribute(cards, players);

        board.addPlayers(players);
        /*int cardPlaying = -1;
        while(cardPlaying == -1) {
            cardPlaying = board.getCardPlaying();
            System.out.println("Toujours pas !");
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
