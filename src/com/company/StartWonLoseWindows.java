package com.company;

import javax.swing.*;
import java.awt.*;

public class StartWonLoseWindows extends Game {
    private static JFrame start;
    private JFrame lose;
    private JFrame won;
    private static JLabel startText;
    private static JButton startButton;
    private JLabel loseText;
    private JButton loseButton;
    private JLabel wonText;
    private JButton wonButton;

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
        startButton.addActionListener(evt -> startGame());

        start.add(startButton);
    }

    public static void startGame() {
        start.dispose();
        Init();
        run();
    }
}
