import java.io.*;
import java.util.regex.Pattern;

/**
 *
 */
public class IntegerToMorse
{
    // The following values aren`t exact and will differ each time, while decoding the should be used as rough
    // approximations
    // while decoding there should be room for 2-3 lines more or less per unit

    /**
     * Number of lines (in the readableOutput file ) per "dit" (Short Morse sign)
     * for 20 WPM
     */
    private int ditSize = 20;
    /**
     * Number of lines (in the readableOutput file ) per "Dah" (Long Morse sign)
     * for 20 WPM
     */
    private int dahSize = 48; // Its really 42
    /**
     * Number of lines (in the readableOutput file ) per intra character space
     * (Space between dahs and dits within a single characters code)
     */
    private int intraCharacterSpaceSize = 10;
    /**
     * Number of lines (in the readableOutput file ) per inter character space
     * (Space between two character codes)
     */
    private int interCharacterSpaceSize = 40;
    private File input;
    private File output;
    private StringBuilder result;

    public IntegerToMorse(File input, File output)
    {
        this.input = input;
        this.output = output;
        result = new StringBuilder();
    }

    /**
     * Reads the readableOutputFile line by line
     */
    public void translate()
    {
        Boolean state = false;
        //Pattern pattern = new Pattern.compile("1", Pattern.CASE_INSENSITIVE);
        //String regex "1"

        // File reading streams
        String line = null;
        int counter = 0;
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
            while ((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
                if (isLineWithPatter(line) && state == true)
                {
                    counter++;
                }
                else if (isLineWithPatter(line) == false && state == true)
                {
                    if (checkResult(counter, state))
                    {
                        counter = 0;
                        state = false;
                    }

                }
                else if (isLineWithPatter(line) == false && state == false)
                {
                    counter++;
                }
                else if (isLineWithPatter(line) && state == false)
                {
                    if (checkResult(counter, state))
                    {

                        counter = 0;
                        state = true;
                    }

                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        publishResults();
    }

    private void publishResults()
    {
        System.out.println("=================================");
        System.out.println("Result = " + result.toString());
        System.out.println("=================================");

        try
        {
            FileWriter fileWriter  = new FileWriter(output);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(result.toString());
            writer.flush();
            writer.close();
            fileWriter.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
        e.printStackTrace();
    }
    }

    private boolean checkResult(int counter, Boolean state)
    {
        if (state == true)
        {
            if (counter < ditSize + 6 && counter > ditSize - 7)
            {
                result.append(".");
                return true;
            }
            else if (counter < dahSize + 6 && counter > dahSize - 7)
            {
                result.append("-");
                return true;
            }
        }
        else
        {
            if (counter < intraCharacterSpaceSize + 6 && counter > intraCharacterSpaceSize - 7)
            {
                result.append("");
                return true;
            }
            else if (counter < interCharacterSpaceSize + 6 && counter > interCharacterSpaceSize - 7)
            {
                result.append("   ");
                return true;
            }
            else if (counter > interCharacterSpaceSize * 2)
            {
                result.append("  /  ");
                return true;
            }
        }
        return false;
    }

    /**
     * Determine if a single line matches the definition of a line of a "dit" or "dah"
     * which is = at least 3 ones
     *
     * @param line
     *
     * @return
     */
    private boolean isLineWithPatter(String line)
    {
        if (line.matches("0*10*10*10*(1|0)*"))
        {
            return true;
        }
        return false;
    }
}
