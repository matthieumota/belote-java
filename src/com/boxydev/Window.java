package com.boxydev;

import com.boxydev.card.Card;
import com.boxydev.card.CardPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private JPanel board = new JPanel();
    public CardPackage cards;

    public Window() {
        setTitle("Window");
        setSize(400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("ok");
        button.addActionListener(this);
        board.add(button);
        setContentPane(board);
        //this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.print(actionEvent);
        for(Card card : cards.getCards()) {
            System.out.println(card.getCard());
        }
        /*for(Card card : cards.getCards()) {
            JLabel label = new JLabel(card.getCard());
            this.board.add(label);
        }
        this.board.revalidate();
        this.board.repaint();*/
    }
}
