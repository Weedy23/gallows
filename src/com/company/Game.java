package com.company;

public class Game {

    private Window win;
    private String word;
    private int wrongs;
    private int foundedLettersCounter;


    void Init() {
        win.InitWin();
    }

    void run() {
        word = createWord();
        int wordLength = word.length();
        while (wrongs < 5) {
            if (wordLength == foundedLettersCounter) {
                break;
            }
        }
        if (wordLength == foundedLettersCounter) {
            win.youWon();
        } else {
            win.youLose();
        }
    }

    String createWord() {
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
        int index = word.indexOf(letter, 0);
    }

    void wrongLetter() {
        drawLine(wrongs);
        wrongs++;
    }

    void drawLine(int count) {
        switch (count) {
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }
    }


}
