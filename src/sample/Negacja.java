package sample;

import static sample.Konwersje.BinOnDec;
import static sample.Konwersje.HexToDec;

public class Negacja extends Thread{

    static String negacja = "";

    boolean bin;
    boolean dec;
    boolean hex;
    String zawartosc;

    /**
     * Konstruktor
     * @param bin czy obecny system to system binarny
     * @param dec czy obecny system to system dziesietny
     * @param hex czy obecny system to system szesnastkowy
     * @param zawartosc zmienna do zanegowania
     */
    public Negacja(boolean bin, boolean dec, boolean hex, String zawartosc)
    {
        this.bin = bin;
        this.dec = dec;
        this.hex = hex;
        this.zawartosc = zawartosc;
    }

    /**
     * wykonuje dzialanie negacji
     */
    @Override
    public void run()
    {
        if(dec)
        {
            long zmienna;
            zmienna = Math.negateExact(Long.parseLong(zawartosc));
            negacja = String.valueOf(zmienna);
        }
        if(bin)
        {
            double zmienna = BinOnDec(Double.parseDouble(zawartosc));
            zmienna = Math.negateExact((long) zmienna);
            negacja = Integer.toBinaryString((int) zmienna);
        }
        if(hex)
        {
            double zmienna = HexToDec(zawartosc);
            zmienna = Math.negateExact((long) zmienna);
            negacja = Integer.toHexString((int) zmienna).toUpperCase();
        }
    }
}
