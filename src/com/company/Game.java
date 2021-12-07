package com.company;

public class Game {
    private static Window win = new Window();
    private static String word;
    private static int wrongs;


    static void Init() {
        win.InitWin();
    }

    static void run() {
        word = createWord();
        wrongs = 0;
        win.createShowWord(word.length());
        boolean won = false;
        while (wrongs < 10) {
            System.out.println("I don't know why, but with this it works");
            if (word.equals(win.showWord)) {
                won = true;
                break;
            }
        }
        if (won) {
            win.youWon();
        } else {
            win.youLose();
        }
    }

    static String createWord() {
        //return random word from file
        return "test";
    }

    void letterPressed(String letter) {
        if (checkLetterInWord(letter)) {
            findLetters(letter);
        } else {
            wrongLetter();
        }
    }

    boolean checkLetterInWord(String letter) {
        return word.contains(letter);
    }

    void findLetters(String letter) {
        int index = 0;
        while (index < word.length()) {
            index = word.indexOf(letter, index);
            if (index == -1) {
                break;
            }
            showLetter(index);
            index++;
        }
    }

    void showLetter(int index) {
        win.showLetter(word.charAt(index), index);
    }

    void wrongLetter() {
        drawLine(wrongs);
        wrongs++;
    }

    void drawLine(int count) {
        switch (count) {
            case 0:
                win.drawLine(20, 180, 120, 180);
                break;
            case 1:
                win.drawLine(70, 180, 70, 20);
                break;
            case 2:
                win.drawLine(70, 20, 200, 20);
                break;
            case 3:
                win.drawLine(200, 20, 200, 60);
                break;
            case 4:
                win.drawCircle();
                break;
            case 5:
                win.drawLine(200, 100, 200, 150);
                break;
            case 6:
                win.drawLine(200, 150, 150, 180);
                break;
            case 7:
                win.drawLine(200, 150, 250, 180);
                break;
            case 8:
                win.drawLine(200, 110, 130, 140);
                break;
            case 9:
                win.drawLine(200, 110, 270, 140);
                break;
        }
    }
}
