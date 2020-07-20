import java.io.*;
import java.util.StringTokenizer;

public class MorseToText
{
    private File input;
    private File output;
    private StringBuilder result;

    public MorseToText(File input, File output)
    {
        this.result = new StringBuilder();
        this.input = input;
        this.output = output;
    }

    public void translate()
    {
        // File reading streams
        String morse = "";
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));

            morse = bufferedReader.readLine();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        StringTokenizer st = new StringTokenizer(morse, "  ");
        while (st.hasMoreElements())
        {
            String val= st.nextToken();
            if (val.equals(Alphabet.A.getMorseRepresentation()))
            {
                result.append(Alphabet.A.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.B.getMorseRepresentation()))
            {
                result.append(Alphabet.B.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.C.getMorseRepresentation()))
            {
                result.append(Alphabet.C.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.D.getMorseRepresentation()))
            {
                result.append(Alphabet.D.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.E.getMorseRepresentation()))
            {
                result.append(Alphabet.E.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.F.getMorseRepresentation()))
            {
                result.append(Alphabet.F.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.G.getMorseRepresentation()))
            {
                result.append(Alphabet.G.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.H.getMorseRepresentation()))
            {
                result.append(Alphabet.H.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.I.getMorseRepresentation()))
            {
                result.append(Alphabet.I.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.J.getMorseRepresentation()))
            {
                result.append(Alphabet.J.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.K.getMorseRepresentation()))
            {
                result.append(Alphabet.K.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.L.getMorseRepresentation()))
            {
                result.append(Alphabet.L.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.M.getMorseRepresentation()))
            {
                result.append(Alphabet.M.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.N.getMorseRepresentation()))
            {
                result.append(Alphabet.N.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.O.getMorseRepresentation()))
            {
                result.append(Alphabet.O.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.P.getMorseRepresentation()))
            {
                result.append(Alphabet.P.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.Q.getMorseRepresentation()))
            {
                result.append(Alphabet.Q.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.R.getMorseRepresentation()))
            {
                result.append(Alphabet.R.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.S.getMorseRepresentation()))
            {
                result.append(Alphabet.S.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.T.getMorseRepresentation()))
            {
                result.append(Alphabet.T.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.U.getMorseRepresentation()))
            {
                result.append(Alphabet.U.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.V.getMorseRepresentation()))
            {
                result.append(Alphabet.V.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.W.getMorseRepresentation()))
            {
                result.append(Alphabet.W.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.X.getMorseRepresentation()))
            {
                result.append(Alphabet.X.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.Y.getMorseRepresentation()))
            {
                result.append(Alphabet.Y.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.Z.getMorseRepresentation()))
            {
                result.append(Alphabet.Z.getLatinRepresentation());
            }
            else if (val.equals(Alphabet.SPACE.getMorseRepresentation()))
            {
                result.append(Alphabet.SPACE.getLatinRepresentation());
            }
            else
            {
                result.append("Err");
            }

        }

        System.out.println(result.toString());

    }


    private enum Alphabet
    {
        A(".-", "a"), B("-...", "b"), C("-.-.", "c"), D("-..", "d"), E(".", "e"), F("..-.", "f"),
        G("--.", "g"), H("....", "h"), I("..", "i"), J(".---", "j"), K("-.-", "k"), L(".-..", "l"),
        M("--", "m"), N("-.", "n"), O("---", "o"), P(".--.", "p"), Q("--.-", "q"), R(".-.", "r"),
        S("...", "s"), T("-", "t"), U("..-", "u"), V("..-", "v"), W("--", "w"), X("-..-", "x"),
        Y("-.--", "y"), Z("--..", "z"), SPACE("/", " ");

        private String morseCode;
        private String latin;

        private Alphabet(String morseCode, String latin)
        {
            this.morseCode = morseCode;
            this.latin = latin;
        }

        public String getMorseRepresentation()
        {
            return morseCode;
        }

        public String getLatinRepresentation()
        {
            return latin;
        }
    }


}
