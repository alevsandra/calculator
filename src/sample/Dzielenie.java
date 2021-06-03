package sample;

import static sample.Konwersje.BinOnDec;
import static sample.Konwersje.HexToDec;

public class Dzielenie extends Thread{

    static String dziele = "";

    boolean bin;
    boolean dec;
    boolean hex;
    String arg1;
    String arg2;

    /**
     * Konstruktor
     * @param bin czy obecny system to system binarny
     * @param dec czy obecny system to system dziesietny
     * @param hex czy obecny system to system szesnastkowy
     * @param arg1 argument pierwszy dzialania
     * @param arg2 argument drugi dzialania
     */
    public Dzielenie(boolean bin, boolean dec, boolean hex, String arg1, String arg2)
    {
        this.bin = bin;
        this.dec = dec;
        this.hex = hex;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    /**
     * wykonuje dzielenie
     */
    @Override
    public void run()
    {
        if(dec)
        {
            dziele = String.valueOf(Double.parseDouble(arg1) / Double.parseDouble(arg2));
        }
        if(bin)
        {
            double pom = BinOnDec(Double.parseDouble(arg1)) / BinOnDec(Double.parseDouble(arg2));
            dziele = Integer.toBinaryString((int) pom);
        }
        if(hex)
        {
            int pom = HexToDec(String.valueOf(arg1)) / HexToDec(String.valueOf(arg2));
            dziele = Integer.toHexString(pom).toUpperCase();
        }
    }
}