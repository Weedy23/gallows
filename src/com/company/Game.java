package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Window win = new Window();
    private static String word;
    private static JFrame start;
    private static JLabel startText;
    private static JButton startButton;

    private static String path = "C:\\Users\\Administrator\\IdeaProjects\\gallows\\src\\com\\company\\1-1000.txt";

    static void start() {
        //initStart();
        run();
    }

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
        run();
    }

    static void run() {
        win.InitWin();
        word = createWord();
        win.enterWord(word);
        win.createShowWord(word.length());
        win.startGame();
    }

    static String createWord() {
        Scanner scanner = null;
        String[] words = new String[1000];

        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter("\n");

        int i;
        for (i = 0; scanner.hasNext(); i++) {
            words[i] = scanner.nextLine();
        }

        Random rand = new Random();
        int index = rand.nextInt(i + 1);

        return words[index];
    }


}
