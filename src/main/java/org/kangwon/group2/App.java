package org.kangwon.group2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Simple Hangman Game
 * @author KNU Group 2
 */
public class App
{

   // byeoljubu -> Exception Handling, final modify
    private static boolean correctInput = false;    // check (user input a alphabet)
    private static boolean clear = false;           // game clear

    public static void main( String[] args ) {
        // takgung6820 ->  Specifying Keyword
        String keyword;
        Words words = new Words("keyword.txt"); // Change file path - ydhwa
        keyword = words.getKeyword();
        Scanner input = new Scanner(System.in);

        // CuteIU -> Hangman Ascii art.
        Hangman hangman = new Hangman();
        hangman.print();

        // ydhwa -> Board variables
        char[] guessBoard = new char[keyword.length()];
        char[] alphabetBoard = new char[26];
        initBoards(keyword, guessBoard, alphabetBoard);
        printBoards(guessBoard, alphabetBoard);

        // ydhwa -> Play test.
        while(!isFinished(guessBoard, hangman)) {
            System.out.print(" > ");
            String command = input.next();
            if(command.length() > 1) {
                System.out.println("Wrong input!");
                continue;
            }

            clear = guessBoard(keyword, command.toUpperCase().charAt(0), guessBoard, alphabetBoard);
            if(!clear && correctInput)
            {
                hangman.fail();
            }

            // CuteIU -> Hangman Print
            hangman.print();

            printBoards(guessBoard, alphabetBoard);
        }
        if(clear)
            System.out.println("Game Clear!");

        input.close();
    }


    /**
     * Initialize boards based on the keyword.
     * @param keyword Correct answer keyword
     * @author ydhwa
     */
    public static void initBoards(String keyword, char[] guessBoard, char[] alphabetBoard) {
        Arrays.fill(guessBoard, '_');
        for(int i = 0; i < 26; i++) alphabetBoard[i] = (char) (65 + i);
    }

    /**
     * Guessing.
     * Fill the guess board if the correct letter is presented.
     * Erases the player's character from the alphabet board, whether it is correct or not.
     * @param keyword Correct answer keyword
     * @param character A Character entered by the player
     * @param guessBoard A board the player should fill
     * @param alphabetBoard Alphabet board
     * @return If the character contains in the keyword [true|false]
     * @author ydhwa
     */
    public static boolean guessBoard(String keyword, char character, char[] guessBoard, char[] alphabetBoard) {
        boolean guess = false;
        try{
            if(alphabetBoard[character - 65] == ' ') {  // // Duplicate input.
                System.out.println("The character you already entered!");
                guess = false;
                correctInput = false;
            }
            else {  // Correct input.
                alphabetBoard[character - 65] = ' ';
                for(int i = 0; i < guessBoard.length; i++) {
                    if (keyword.charAt(i) == character) {
                        guessBoard[i] = character;
                        guess = true;
                    }
                }
                correctInput = true;
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Select alphabet");
            correctInput = false;
        }
        return guess;
    }

    /**
     * Print boards.
     * @param guessBoard A board the player should fill
     * @param alphabetBoard Alphabet board
     * @author ydhwa
     */
    public static void printBoards(char[] guessBoard, char[] alphabetBoard) {
        for(int i = 0; i < guessBoard.length; i++) System.out.print(" " + guessBoard[i]);
        System.out.println("\n===========================");
        for(int i = 0; i < alphabetBoard.length; i++) {
            System.out.print(" " + alphabetBoard[i]);
            if(i == 12) System.out.println();
        }
        System.out.println("\n===========================");
    }

    /**
     * Check whether the game is finished or not.
     * Only if the correct answer was correct was done.
     * @return
     * @author ydhwa
     */
    public static boolean isFinished(char[] guessBoard, Hangman hangman) {
        // Life is 0
        if(hangman.done())
        {
            System.out.println("Game Over!");
            return true;
        }

        // Check correct answer
        for(int i = 0; i < guessBoard.length; i++)
            if(guessBoard[i] == '_') return false;
        return true;
    }
}
