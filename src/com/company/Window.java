package com.company;

import javax.swing.*;
import java.awt.*;

public class Window {
    private Game game;
    private JFrame window;
    private JPanel screen;
    private JPanel jLetters;
    private JPanel jWord;
    private JButton[] letters;
    private JLabel word;
    private int[] lettersHaveBeenPressed;
    private int next = 0;

    public void InitWin() {
        window = new JFrame();
        InitWinProperties();
        InitWinStruct();
    }

    public void InitWinProperties() {
        window.setBounds(100, 100, 300, 500);
        window.setLayout(null);
        window.setBackground(Color.WHITE);
        window.setVisible(true);
    }

    public void InitWinStruct() {
        screen = new JPanel();
        screen.setBounds(0, 0, 300, 200);
        screen.setLayout(null);
        screen.setBackground(Color.GRAY);
        screen.setVisible(true);

        window.add(screen);

        jLetters = new JPanel();
        jLetters.setBounds(0, 200, 300, 100);
        jLetters.setLayout(null);
        jLetters.setBackground(Color.lightGray);
        jLetters.setVisible(true);

        createLetters();

        window.add(jLetters);

        jWord = new JPanel();
        jWord.setBounds(0, 300, 300, 100);
        jWord.setLayout(null);
        jWord.setBackground(Color.lightGray);
        jWord.setVisible(true);

        word = new JLabel();
        word.setBounds(20, 20, 260, 60);
        word.setLayout(null);
        word.setVisible(true);

        jWord.add(word);

        window.add(jWord);
    }

    public void createLetters() {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        letters = new JButton[26];
        for (int i = 0; i < 26; i++) {
            letters[i] = new JButton();
            letters[i].setText(alphabet[i]);
            if (i < 13) {
                letters[i].setBounds(i*(20) + 20, 20, 20, 20);
            } else {
                letters[i].setBounds(i*(20) + 20, 60, 20, 20);
            }
            jLetters.add(letters[i]);
            int finalI = i;
            letters[i].addActionListener(evt -> letterPressed(finalI));
        }
    }

    public void letterPressed(int letterIndex) {
        if (!letterCheck(letterIndex)) {
            game.letterPressed(letters[letterIndex].getText());
            letters[letterIndex].setText("_");
            lettersHaveBeenPressed[next] = letterIndex;
            next++;
        }
    }

    public boolean letterCheck(int letterIndex) {
        for (int i = 0; i < next; i++) {
            if (lettersHaveBeenPressed[i] == letterIndex) {
                return true;
            }
        }
        return false;
    }

    public void youWon() {

    }

    public void youLose() {

    }
}
