package com.boxydev;

import com.boxydev.card.Card;
import com.boxydev.card.CardPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    private Window window = new Window();
    private CardPackage cards = new CardPackage();
    private Player player = new Player();
    private List<Player> bots  = new ArrayList<>();
    private Player distributor;

    private void dispatch() {
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.addAll(bots);

        Random random = new Random();
        distributor = players.get(random.nextInt(4));
        distributor.distribute(cards, players);
    }

    public void run() {
        cards.mixing();
        window.cards = cards;
        player.setName("Matthieu");
        player.setPosition(0);
        for (int i = 1; i < 4; i++) {
            bots.add(new Player("Bot "+i, i));
        }
        /*System.out.println(player.getName());
        for (Player bot : bots) {
            System.out.println(bot.getName());
        }*/
        dispatch();
        System.out.print("Lance l'application");
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
