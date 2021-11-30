package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends Game{
    private JFrame window;
    private JPanel screen;
    private JPanel jLetters;
    private JPanel jWord;
    private JButton[] letters;
    private JLabel word;
    public String showWord;
    private Graphics g;

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
        jLetters.setBounds(0, 300, 300, 100);
        jLetters.setLayout(null);
        jLetters.setBackground(Color.lightGray);
        jLetters.setVisible(true);

        createLetters();

        window.add(jLetters);

        jWord = new JPanel();
        jWord.setBounds(0, 200, 300, 100);
        jWord.setLayout(null);
        jWord.setBackground(Color.lightGray);
        jWord.setVisible(true);

        word = new JLabel();
        word.setBounds(20, 20, 260, 60);
        word.setLayout(null);
        word.setFont(new Font("Calibri", Font.PLAIN, 40));
        word.setVisible(true);

        jWord.add(word);

        window.add(jWord);
    }

    public void createLetters() {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        letters = new JButton[26];
        for (int i = 0; i < 26; i++) {
            letters[i] = new JButton();
            letters[i].setFont(new Font("Calinri", Font.PLAIN, 5));
            letters[i].setText(alphabet[i]);
            if (i < 13) {
                letters[i].setBounds(i*(20) + 20, 20, 20, 20);
            } else {
                letters[i].setBounds((i - 13)*(20) + 20, 60, 20, 20);
            }
            jLetters.add(letters[i]);
            int finalI = i;
            letters[i].addActionListener(evt -> letterPressed(finalI));
        }
    }

    public void letterPressed(int letterIndex) {
        letterPressed(letters[letterIndex].getText());
        letters[letterIndex].setEnabled(false);
    }

    public void createShowWord(int len) {
        showWord = "-".repeat(len);
        updateWord();
    }

    public void updateWord() {
        word.setText(showWord);
     }

    public void youWon() {
        window.dispose();
    }

    public void youLose() {
        window.dispose();
    }

    public void showLetter(char letter, int index) {
        showWord = showWord.substring(0, index) + letter + showWord.substring(index + 1);
        updateWord();
    }

    public void drawLine(int x1, int y1,int x2, int y2) {
        g = screen.getGraphics();
        g.drawLine(x1, y1, x2, y2);
    }

    public void drawCircle() {
        g = screen.getGraphics();
        g.drawOval(180, 60, 40, 40);
    }
}
