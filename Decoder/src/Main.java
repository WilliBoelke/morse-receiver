import java.io.*;

public class Main
{

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("F:\\OneDrive\\Desktop\\output");
        FileInputStream fin = new FileInputStream(file);
        BufferedInputStream bin = new BufferedInputStream(fin);
        DataInputStream din = new DataInputStream(bin);

        int count = (int) (file.length() / 4);
        int[] values = new int[count];
        for (int i = 0; i < count; i++) {
            try
            {
                values[i] = din.readInt();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

            int newLineCounter = 0;
        for (int i : values)
        {
            if(1 == 3)
            {

            }
            else if(i != 0)
            {
                System.out.print(1);
            }
            else
            {
                System.out.print(" ");
            }
            System.out.print(" ");

            if(newLineCounter == 20)
            {
                System.out.println("");
                newLineCounter = 0;
            }
            newLineCounter++;

        }
    }


    private enum Code
    {

    }
}
