package org.kangwon.group2;

public class Hangman
{
    StringBuilder[] hangman;
    int fail = 0;
    /**
     * Make Basic Hangman
     * @author CuteIU
     */
    public Hangman() {
        hangman = new StringBuilder[23];
        hangman[0] = new StringBuilder("___________.._______");
        hangman[1] = new StringBuilder("| .__________))______|");
        hangman[2] = new StringBuilder("| | / /      ||");
        hangman[3] = new StringBuilder("| |/ /       ||");
        hangman[4] = new StringBuilder("| | /        ||");
        hangman[5] = new StringBuilder("| |/         ||");
        hangman[6] = new StringBuilder("| |");
        hangman[7] = new StringBuilder("| |");
        hangman[8] = new StringBuilder("| |");
        hangman[9] = new StringBuilder("| |");
        hangman[10] = new StringBuilder("| |");
        hangman[11] = new StringBuilder("| |");
        hangman[12] = new StringBuilder("| |");
        hangman[13] = new StringBuilder("| |");
        hangman[14] = new StringBuilder("| |");
        hangman[15] = new StringBuilder("| |");
        hangman[16] = new StringBuilder("| |");
        hangman[17] = new StringBuilder("| |");
        hangman[18] = new StringBuilder("\"\"\"\"\"\"\"\"\"\"|_`-' `-' |\"\"\"|");
        hangman[19] = new StringBuilder("|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|");
        hangman[20] = new StringBuilder("| |        \\ \\        | |");
        hangman[21] = new StringBuilder(": :         \\ \\       : :");
        hangman[22] = new StringBuilder(". .          `'       . .");
    }
    /**
     * Return img is done.
     * @author CuteIU
     **/
    public boolean done()
    {
        if(fail == 6)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * If you miss, draw.
     * @author CuteIU
     */
    public void fail()
    {
        fail++;
        switch(fail)
        {
            case 1 :
                drawHead();
                break;
            case 2 :
                drawBody();
                break;
            case 3 :
                drawLeftArm();
                break;
            case 4 :
                drawRightArm();
                break;
            case 5 :
                drawLeftLeg();
                break;
            case 6 :
                drawRightLeg();
                break;
        }
    }
    public void drawHead()
    {
        hangman[4] = new StringBuilder("| | /        ||.-''.");
        hangman[5] = new StringBuilder("| |/         |/  _  \\");
        hangman[6] = new StringBuilder("| |          ||  `/,|");
        hangman[7] = new StringBuilder("| |          (\\\\`_.'");
        hangman[8] = new StringBuilder("| |         .-`--'.");
    }
    public void drawBody()
    {
        hangman[9] = new StringBuilder("| |          | . . |");
        hangman[10] = new StringBuilder("| |          |     |");
        hangman[11] = new StringBuilder("| |          |  .  |");
        hangman[12] = new StringBuilder("| |          |____|");
    }
    public void drawLeftArm()
    {
        hangman[9] = new StringBuilder("| |        /Y . .");
        hangman[10] = new StringBuilder("| |       // |   |");
        hangman[11] = new StringBuilder("| |      //  | . | ");
        hangman[12] = new StringBuilder("| |     ')   |   |  ");
    }
    public void drawRightArm()
    {
        hangman[9] = new StringBuilder("| |        /Y . . Y\\");
        hangman[10] = new StringBuilder("| |       // |   | \\\\");
        hangman[11] = new StringBuilder("| |      //  | . |  \\\\");
        hangman[12] = new StringBuilder("| |     ')   |   |   (`");
    }
    public void drawLeftLeg()
    {
        hangman[13] = new StringBuilder("| |          ||'");
        hangman[14] = new StringBuilder("| |          ||");
        hangman[15] = new StringBuilder("| |          ||");
        hangman[16] = new StringBuilder("| |          ||");
        hangman[17] = new StringBuilder("| |         / |");
    }
    public void drawRightLeg()
    {
        hangman[13] = new StringBuilder("| |          ||'||");
        hangman[14] = new StringBuilder("| |          || ||");
        hangman[15] = new StringBuilder("| |          || ||");
        hangman[16] = new StringBuilder("| |          || ||");
        hangman[17] = new StringBuilder("| |         / | | \\");
    }
    public void print()
    {
        for(int i = 0; i < 23; i++)
        {
            System.out.println(hangman[i]);
        }
        System.out.println();
    }
}