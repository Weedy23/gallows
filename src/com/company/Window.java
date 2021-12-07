package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends Game{
    private static StartWonLoseWindows startWonLoseWindows = new StartWonLoseWindows();

    protected  JFrame window;
    protected  JPanel screen;
    protected  JPanel jLetters;
    protected  JButton[] letters;
    protected  JLabel word;
    public String showWord;
    protected Graphics g;

    public void InitWin() {
        System.out.println("LOL");
        window = new JFrame();
        InitWinProperties();
        InitWinStruct();
    }

    public void InitWinProperties() {
        System.out.println("LOL1");
        window.setBounds(100, 100, 600, 500);
        window.setLayout(null);
        window.setVisible(true);
    }

    public void InitWinStruct() {
        System.out.println("LOL2");
        screen = new JPanel();
        screen.setBounds(0, 0, window.getWidth(), 200);
        //screen.setLayout(null);
        screen.setBackground(Color.GRAY);
        screen.setVisible(true);

        window.add(screen);

        jLetters = new JPanel();
        jLetters.setBounds(0, 300, window.getWidth() - 20, 100);
        //jLetters.setLayout(null);
        jLetters.setBackground(Color.lightGray);
        jLetters.setVisible(true);

        createLetters();

        window.add(jLetters);

        JPanel jWord = new JPanel();
        jWord.setBounds(0, 200, window.getWidth(), 100);
        //jWord.setLayout(null);
        jWord.setBackground(Color.lightGray);
        jWord.setVisible(true);

        word = new JLabel();
        word.setBounds(20, 20, window.getWidth() - 40, 60);
        //word.setLayout(null);
        word.setFont(new Font("Calibre", Font.PLAIN, 40));
        word.setVisible(true);

        jWord.add(word);

        window.add(jWord);
    }

    public void createLetters() {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int width = (jLetters.getWidth() - 40) / 13;
        int height = (jLetters.getHeight() - 40) / 2;
        letters = new JButton[26];
        for (int i = 0; i < 26; i++) {
            letters[i] = new JButton();
            letters[i].setFont(new Font("Calibre", Font.BOLD, 10));
            letters[i].setText(alphabet[i]);
            letters[i].setVisible(true);
            if (i < 13) {
                letters[i].setBounds(i*width, 20, width, height);
            } else {
                letters[i].setBounds((i - 13)*width, 40 + height, width, height);
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
        startWonLoseWindows.initWon();
    }

    public void youLose() {
        window.dispose();
        startWonLoseWindows.initLose();
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
