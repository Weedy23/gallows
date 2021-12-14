package com.company;

import javax.swing.*;
import java.awt.*;

public class Window {

    protected  JFrame window;
    protected  JPanel screen;
    protected  JPanel jLetters;
    protected  JButton[] letters;
    protected  JLabel word;
    public int wrongs = 0;
    public String endWord;
    public String showWord;
    protected Graphics g;

    private static JFrame lose;
    private static JFrame won;
    private static JLabel loseText;
    //private static JButton loseButton;
    private static JLabel wonText;
    //private static JButton wonButton;

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
        screen.setLayout(null);
        screen.setBackground(Color.GRAY);
        screen.setVisible(true);

        window.add(screen);

        jLetters = new JPanel();
        jLetters.setBounds(0, 300, window.getWidth() - 20, 100);
        jLetters.setLayout(null);
        jLetters.setBackground(Color.lightGray);
        jLetters.setVisible(true);

        createLetters();

        window.add(jLetters);

        JPanel jWord = new JPanel();
        jWord.setBounds(0, 200, window.getWidth(), 100);
        jWord.setLayout(null);
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
        check(letters[letterIndex].getText());
        letters[letterIndex].setEnabled(false);
    }

    void check(String letter) {
        if (checkLetterInWord(letter)) {
            findLetters(letter);
        } else {
            wrongLetter();
        }
    }

    boolean checkLetterInWord(String letter) {
        return endWord.contains(letter);
    }

    void findLetters(String letter) {
        int index = 0;
        while (index < endWord.length()) {
            index = endWord.indexOf(letter, index);
            if (index == -1) {
                break;
            }
            showLetter(letter, index);
            index++;
        }
    }

    public void showLetter(String letter, int index) {
        showWord = showWord.substring(0, index) + letter + showWord.substring(index + 1);
        updateWord();
    }

    public void wrongLetter() {
        draw();
        wrongs++;
    }

    void draw() {
        switch (wrongs) {
            case 0:
                drawLine(20, 180, 120, 180);
                break;
            case 1:
                drawLine(70, 180, 70, 20);
                break;
            case 2:
                drawLine(70, 20, 200, 20);
                break;
            case 3:
                drawLine(200, 20, 200, 60);
                break;
            case 4:
                drawCircle();
                break;
            case 5:
                drawLine(200, 100, 200, 150);
                break;
            case 6:
                drawLine(200, 150, 150, 180);
                break;
            case 7:
                drawLine(200, 150, 250, 180);
                break;
            case 8:
                drawLine(200, 110, 130, 140);
                break;
            case 9:
                drawLine(200, 110, 270, 140);
                break;
        }
    }

    public void enterWord(String word) {
        endWord = word;
    }

    public void createShowWord(int len) {
        showWord = "-".repeat(len);
        updateWord();
    }

    public void updateWord() {
        word.setText(showWord);
     }

    public void startGame() {
        boolean won = false;
        while (wrongs < 10) {
            System.out.println("I don't know why, but with this it works");
            if (endWord.equals(showWord)) {
                won = true;
                break;
            }
        }
        if (won) {
            youWon();
        } else {
            youLose();
        }
    }

    public void youWon() {
        window.dispose();
        initWon();
    }

    public void youLose() {
        window.dispose();
        initLose();
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

    public void drawLine(int x1, int y1,int x2, int y2) {
        g = screen.getGraphics();
        g.drawLine(x1, y1, x2, y2);
    }

    public void drawCircle() {
        g = screen.getGraphics();
        g.drawOval(180, 60, 40, 40);
    }
}
