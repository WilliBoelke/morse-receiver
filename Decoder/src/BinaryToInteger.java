import java.io.*;

public class BinaryToInteger
{
    private File input;
    private File output;

    public BinaryToInteger(File input, File output)
    {
        this.input = input;
        this.output = output;
    }

    /**
     * Reads Integers from the binary "output" file
     * and writes them into the "readableOutput" file
     */
    public void translate()
    {
        // File reading streams
        FileInputStream fileInputStream = null;
        try
        {
            fileInputStream = new FileInputStream(input);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);

        //Reading from "output"
        int count = (int) (input.length() / 4);
        int[] values = new int[count];
        for (int i = 0; i < count; i++)
        {
            try
            {
                values[i] = dataInputStream.readInt();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }


        // File writing Streams
        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter(output);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        BufferedWriter writer = new BufferedWriter(fileWriter);

        //Writing to the readableOutput
        int newLineCounter = 0;
        for (int i : values)
        {
            try
            {
                if (i != 0)
                {
                    writer.write("1");
                }
                else
                {
                    writer.write("0");
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            if (newLineCounter == 20)
            {
                try
                {
                    writer.newLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                newLineCounter = 0;
            }
            newLineCounter++;
        }

        try
        {
            writer.flush();
            writer.close();
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
