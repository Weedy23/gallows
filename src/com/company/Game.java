package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Window win = new Window();
    private static String word;
    private static JOptionPane start;

    private static String path = "C:\\Users\\Administrator\\IdeaProjects\\gallows\\src\\com\\company\\1-1000.txt";

    static void start() {
        initStart();
    }

    public static void initStart() {
        Object startT = "Start";

        start = new JOptionPane();
        int action = start.showConfirmDialog(win.window, "Start Gallows");

        if (action == JOptionPane.OK_OPTION) {
            startPressed();
        }
    }

    public static void startPressed() {
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
