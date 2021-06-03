package sample;

import static sample.Main.*;

public class Konwersje extends Thread{

    static String buffor = "";

    boolean bin;
    boolean dec;
    boolean hex;
    String zawartosc;

    /**
     * @param bin konwersja do binarnego
     * @param dec konwersja do dziesiętnego
     * @param hex konwersja do szesnastkowego
     * @param zawartosc liczba do skonwertowania
     */
    public Konwersje(boolean bin, boolean dec, boolean hex, String zawartosc)
    {
        this.bin = bin;
        this.dec = dec;
        this.hex = hex;
        this.zawartosc = zawartosc;
    }

    /**
     * wykonanie konwersji
     */
    @Override
    public void run()
    {
        zawartosc = WytnijOdZnaku(zawartosc);
        if(fromDec)
        {
            if(bin)
            {
                try{
                    buffor = DecOnBin(Double.parseDouble(zawartosc));
                }catch(NumberFormatException ignored){}
                fromDec = false;
                fromBin = true;
                fromHex = false;
            }
            if(hex)
            {
                try{
                    buffor = DecToHex(Double.parseDouble(zawartosc));
                }catch(NumberFormatException | NullPointerException ignored){}
                fromDec = false;
                fromBin = false;
                fromHex = true;
            }
        }
        else if(fromBin)
        {
            if(dec)
            {
                try{
                    buffor = String.valueOf(BinOnDec(Double.parseDouble(zawartosc)));
                }catch(NumberFormatException ignored){}
                fromDec = true;
                fromBin = false;
                fromHex = false;
            }
            if(hex)
            {
                buffor = BinToHex(zawartosc);
                fromDec = false;
                fromBin = false;
                fromHex = true;
            }
        }
        else if(fromHex)
        {
            if(dec)
            {
                try{
                    buffor = String.valueOf(HexToDec(zawartosc));
                }catch(NumberFormatException ignored){}
                fromDec = true;
                fromBin = false;
                fromHex = false;
            }
            if(bin)
            {
                buffor = HextoBin(zawartosc);
                fromDec = false;
                fromBin = true;
                fromHex = false;
            }
        }
        try {
            sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param n liczba w systemie dziesiętnym
     * @return liczba w systemie binarnym
     */
    String DecOnBin(double n)
    {
        StringBuilder wynik= new StringBuilder();
        String help;
        int zawartosc = (int)n;
        while(zawartosc!=0)
        {
            help = wynik.toString();
            wynik = new StringBuilder(zawartosc % 2 + help);
            zawartosc = zawartosc/2;
        }
        zawartosc = (int)n;
        if((n - zawartosc) != 0)
        {
            wynik.append(".");
            double reszta = n - zawartosc;
            int i = 5;
            while(reszta!=1 && i != 0)
            {
                reszta = reszta*2;
                if(reszta>1)
                {
                    wynik.append("1");
                    reszta = reszta - 1;
                }
                else if(reszta<1) wynik.append("0");
                else if(reszta == 1) wynik.append("1");
                i--;
            }

        }
        return wynik.toString();
    }

    /**
     * @param n liczba w systemie binarnym
     * @return liczba w systemie decymalnym
     */
    static double BinOnDec(double n)
    {
        double wynik = 0;
        int zawartosc = (int)n;
        int potega = 0;
        while(zawartosc!=0)
        {
            wynik = wynik + (zawartosc%10)*Math.pow(2, potega);
            zawartosc = zawartosc/10;
            potega++;
        }
        zawartosc = (int)n;
        if((n - zawartosc) != 0)
        {
            float reszta = (float) (n - zawartosc);
            reszta = reszta *100000;
            potega = -5;
            while(reszta>1)
            {
                wynik = wynik + (int)(reszta%10)*Math.pow(2, potega);
                reszta = reszta/10;
                potega++;
            }
        }
        return wynik;
    }

    /**
     * @param n liczba w systemie hexadecymalnym
     * @return liczba w systemie binarnym
     */
    String HextoBin(String n)
    {
        StringBuilder wynik= new StringBuilder();
        for(int i=0;i<n.length();i++)
        {
            if(n.charAt(i) == 'A') wynik.append("1010");
            else if(n.charAt(i) == 'B') wynik.append("1011");
            else if(n.charAt(i) == 'C') wynik.append("1100");
            else if(n.charAt(i) == 'D') wynik.append("1101");
            else if(n.charAt(i) == 'E') wynik.append("1110");
            else if(n.charAt(i) == 'F') wynik.append("1111");
            else if(n.charAt(i) == '1') wynik.append("0001");
            else if(n.charAt(i) == '2') wynik.append("0010");
            else if(n.charAt(i) == '3') wynik.append("0011");
            else if(n.charAt(i) == '4') wynik.append("0100");
            else if(n.charAt(i) == '5') wynik.append("0101");
            else if(n.charAt(i) == '6') wynik.append("0110");
            else if(n.charAt(i) == '7') wynik.append("0111");
            else if(n.charAt(i) == '8') wynik.append("1000");
            else if(n.charAt(i) == '9') wynik.append("1001");
            else if(n.charAt(i) == '0') wynik.append("0000");
        }
        return wynik.toString();
    }

    /**
     * @param n liczba w systemie binarnym
     * @return liczba w systemie hexadecymalnym
     */
    String BinToHex(String n)
    {
        String wynik="";
        int suma = 0;
        int potega = 3;
        if(n.length()<4) potega = n.length()%4 - 1;
        for(int i=0;i<n.length();i++)
        {
            suma = (int) (suma + (n.charAt(i)-48)*Math.pow(2, potega));
            if(potega == 0)
            {
                wynik = wyciagnijLitere(wynik, suma);
                suma = 0;
                potega = 3;
            }
            else potega--;
        }
        if(suma!=0)
        {
            wynik = wyciagnijLitere(wynik, suma);
        }
        return wynik;
    }

    private String wyciagnijLitere(String wynik, int suma)
    {
        if(suma<10) wynik = wynik + suma;
        else if(suma==10) wynik = wynik + "A";
        else if(suma==11) wynik = wynik + "B";
        else if(suma==12) wynik = wynik + "C";
        else if(suma==13) wynik = wynik + "D";
        else if(suma==14) wynik = wynik + "E";
        else if(suma==15) wynik = wynik + "F";
        return wynik;
    }

    /**
     * @param n liczba w systemie hexaddecymalnym
     * @return liczba w systemie dzisiętnym
     */
    static int HexToDec (String n)
    {
        int potega = n.length() -1;
        int wynik = 0;
        for(int i=0;i<n.length();i++)
        {
            if(n.charAt(i) == 'A') wynik = (int) (wynik + 10*Math.pow(16, potega));
            else if(n.charAt(i) == 'B') wynik = (int) (wynik + 11*Math.pow(16, potega));
            else if(n.charAt(i) == 'C') wynik = (int) (wynik + 12*Math.pow(16, potega));
            else if(n.charAt(i) == 'D') wynik = (int) (wynik + 13*Math.pow(16, potega));
            else if(n.charAt(i) == 'E') wynik = (int) (wynik + 14*Math.pow(16, potega));
            else if(n.charAt(i) == 'F') wynik = (int) (wynik + 15*Math.pow(16, potega));
            else wynik = (int) (wynik + (n.charAt(i)-48)*Math.pow(16, potega));
            potega--;
        }
        return wynik;
    }

    /**
     * @param n liczba w systemie dziesiętnym
     * @return liczba w systemie hexadecymalnym
     */
    String DecToHex(double n)
    {
        String wynik = "";
        int help;
        while(n>1)
        {
            help = (int)(n%16);
            wynik = wyciagnijLitere(wynik, help);
            n = n/16;
        }
        return wynik;
    }

    /**
     * @param zawartosc zawartosc konsoli kalkulatora
     * @return liczba do zamiany na inny system
     */
    static String WytnijOdZnaku(String zawartosc)
    {
        String policz = zawartosc;
        String znaki = "+—/x%-";
        for(int i=0;i<znaki.length();i++)
        {
            for(int j=0;j<zawartosc.length();j++)
            {
                if(zawartosc.charAt(j) == znaki.charAt(i))
                {
                        policz = zawartosc.substring(j+1);
                }
            }
        }
        return policz;
    }

}
