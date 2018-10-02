package org.kangwon.group2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Random word extraction
 * @author takgung6820
 */
class Words {
    final int sumWords = 26;    // Number of words in keyword.txt
    private String fileName;
    private Random ran = new Random();  // Make random number

    public Words(String fileName)   {
        this.fileName = fileName;
    }

    /**
     * Import a word from keyword.txt
     * @return
     * @author takgung6820
     */
    public String getKeyword() {
        BufferedReader word = null;

        // Exception setting(FileNotFoundException)
        try {
            word = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException e)   {
            System.out.println("File not found!");
        }

        // Extract a word for any one line.
        int n = ran.nextInt(sumWords);
        return readWord(word, n);
    }

    /**
     *
     * @param word A word on the line
     * @param n The line that corresponds to the word to be questioned
     * @return A word to be a question
     * @author takgung6820
     */
    private String readWord(BufferedReader word, int n) {
        String lineWord = null;
        // Exception setting(IOException)
        try {
            while (n > 0)   {
                lineWord = word.readLine();
                if(lineWord == null)    {
                    break;
                }
                n--;
            }
        }
        catch (IOException e)   {
            System.exit(0);
        }
        return lineWord;
    }
}
