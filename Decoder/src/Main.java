import java.io.*;


public class Main
{

    public static void main(String[] args) throws FileNotFoundException
    {
        File output = new File("..\\Files\\output");
        File readableOutput = new File("..\\Files\\readableOutput.txt");
        File morse = new File("..\\Files\\morseCode.txt");
        File text = new File("..\\Files\\text.txt");

        BinaryToInteger bti = new BinaryToInteger(output, readableOutput);
        bti.translate();

        IntegerToMorse itm = new IntegerToMorse(readableOutput, morse);
        itm.translate();

        MorseToText mtt = new MorseToText(morse, text);
        itm.translate();
    }



}
