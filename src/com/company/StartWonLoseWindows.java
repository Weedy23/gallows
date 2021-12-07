package com.company;

import javax.swing.*;
import java.awt.*;

public class StartWonLoseWindows extends Main {
    private static JFrame start;
    private static JFrame lose;
    private static JFrame won;
    private static JLabel startText;
    private static JButton startButton;
    private static JLabel loseText;
    //private static JButton loseButton;
    private static JLabel wonText;
    //private static JButton wonButton;

    public static void initStart() {
        start = new JFrame();
        start.setBounds(100, 100, 750, 300);
        start.setLayout(null);
        start.setBackground(Color.WHITE);
        start.setVisible(true);

        startText = new JLabel();
        startText.setBounds(20, 0, 700, 150);
        startText.setLayout(null);
        startText.setBackground(Color.WHITE);
        startText.setVisible(true);
        startText.setFont(new Font("Calibre", Font.BOLD, 71));
        startText.setText("Welcome to Gallows");

        start.add(startText);

        startButton = new JButton();
        startButton.setBounds(120, 150, 500, 100);
        startButton.setLayout(null);
        startButton.setBackground(Color.WHITE);
        startButton.setVisible(true);
        startButton.setFont(new Font("Calibre", Font.BOLD, 60));
        startButton.setText("Start");
        startButton.addActionListener(evt -> startPressed());

        start.add(startButton);
    }

    public static void startPressed() {
        start.dispose();
        startGame();
    }

    public static void initWon() {
        won = new JFrame();
        won.setBounds(100, 100, 750, 200);
        won.setLayout(null);
        won.setBackground(Color.WHITE);
        won.setVisible(true);

        wonText = new JLabel();
        wonText.setBounds(200, 0, 700, 150);
        wonText.setLayout(null);
        wonText.setBackground(Color.WHITE);
        wonText.setVisible(true);
        wonText.setFont(new Font("Calibre", Font.BOLD, 71));
        wonText.setText("You Won");

        won.add(wonText);
    }

    public static void initLose() {
        lose = new JFrame();
        lose.setBounds(100, 100, 750, 200);
        lose.setLayout(null);
        lose.setBackground(Color.WHITE);
        lose.setVisible(true);

        loseText = new JLabel();
        loseText.setBounds(200, 0, 700, 150);
        loseText.setLayout(null);
        loseText.setBackground(Color.WHITE);
        loseText.setVisible(true);
        loseText.setFont(new Font("Calibre", Font.BOLD, 71));
        loseText.setText("You Lose");

        lose.add(loseText);
    }
}
