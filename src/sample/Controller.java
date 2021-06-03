package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static sample.Dodawanie.dodaj;
import static sample.Dzielenie.dziele;
import static sample.Konwersje.*;
import static sample.Main.*;
import static sample.Mnozenie.mnoze;
import static sample.Negacja.negacja;
import static sample.Odejmowanie.odejmij;
import static sample.Modulo.model;

public class Controller{

    static int dzialania = 0;
    int nawiasyOn = 0;

    static Thread konwertuj;

    @FXML Button cyfra0;
    @FXML Button cyfra1;
    @FXML Button cyfra2;
    @FXML Button cyfra3;
    @FXML Button cyfra4;
    @FXML Button cyfra5;
    @FXML Button cyfra6;
    @FXML Button cyfra7;
    @FXML Button cyfra8;
    @FXML Button cyfra9;

    @FXML Button A;
    @FXML Button B;
    @FXML Button C;
    @FXML Button D;
    @FXML Button E;
    @FXML Button F;

    @FXML Button zapisz;
    @FXML Button odczytaj;

    @FXML Button clear;

    @FXML Button rownasie;
    @FXML Button modulo;
    @FXML Button plus;
    @FXML Button minus;
    @FXML Button dziel;
    @FXML Button mnoz;
    @FXML Button przecinek;
    @FXML Button nawias;
    @FXML Button nawiasP;
    @FXML Button nawiasL;

    @FXML TextArea pamiec;
    @FXML TextArea tlo;

    @FXML TextField ekran;

    @FXML RadioButton dec;
    @FXML RadioButton hex;
    @FXML RadioButton bin;

    @FXML Label decNum;
    @FXML Label hexNum;
    @FXML Label binNum;


    /**
     * Uruchamiana przy odpalaniu aplikacji - ustala parametry graficzne i stany 3 zmiennych globanych
     */
    @FXML
    private void initialize()
    {
        ekran.setStyle("-fx-background-color:black; -fx-prompt-text-fill: white; -fx-font-size: 50px;");

        pamiec.setStyle("-fx-control-inner-background:#000000; " +
                         "-fx-highlight-fill: #ffffff; " +
                         "-fx-highlight-text-fill: #000000; " +
                         "-fx-text-fill: #ffffff; " +
                         "-fx-focus-color: transparent; " +
                         "-fx-text-box-border: transparent");
        fromDec = true;
        fromBin = false;
        fromHex = false;
    }

    //***********************CYFERKI*********************************************

    /**
     * OnAction po kliknięciu "0"
     */
    @FXML
    void button0Clicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "0");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "1"
     */
    @FXML
    void button1Clicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "1");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "2"
     */
    @FXML
    void button2Clicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "2");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "3"
     */
    @FXML
    void button3Clicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "3");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "4"
     */
    @FXML
    void button4Clicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "4");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "5"
     */
    @FXML
    void button5Clicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "5");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "6"
     */
    @FXML
    void button6Clicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "6");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "7"
     */
    @FXML
    void button7Clicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "7");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "8"
     */
    @FXML
    void button8Clicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "8");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "9"
     */
    @FXML
    void button9Clicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "9");
        zamienNaBoku();
    }

    //**************************HEXA*******************************************

    /**
     * OnAction po kliknięciu "A"
     */
    @FXML
    void buttonAClicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "A");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "B"
     */
    @FXML
    void buttonBClicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "B");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "C"
     */
    @FXML
    void buttonCClicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "C");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "D"
     */
    @FXML
    void buttonDClicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "D");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "E"
     */
    @FXML
    void buttonEClicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "E");
        zamienNaBoku();
    }

    /**
     * OnAction po kliknięciu "F"
     */
    @FXML
    void buttonFClicked()
    {
        ekran.setPromptText(ekran.getPromptText() + "F");
        zamienNaBoku();
    }

    //**********DZIAŁANIA + PRZYCISKI FUNKCYJNE********************************

    /**
     * Clear button method
     */
    @FXML
    void buttoncClicked()
    {
        ekran.setPromptText("");
        dzialania = 0;
        nawiasyOn = 0;
        WyczyscKonwersjeZBoku();
    }

    /**
     * Wykonywanie dzialan po nacisnieciu równa się
     */
    @FXML
    void buttonRownaSieClicked()
    {
        /*try{*/
            double wynik = DzialaniaStart(ekran.getPromptText());
            if (wynik%1 == 0)
            {
                pamiec.setText(ekran.getPromptText() + " = " + (int)(wynik) + "\n" + pamiec.getText());
                ekran.setPromptText(String.valueOf((int)wynik));
            }

            else
            {
                pamiec.setText(ekran.getPromptText() + " = " + wynik + "\n" + pamiec.getText() );
                ekran.setPromptText(String.valueOf(wynik));
            }
        /*}catch(StringIndexOutOfBoundsException e)
        {
            ekran.setPromptText("Error!");
        }*/
        zamienNaBoku();
        dzialania = 0;
        nawiasyOn = 0;
    }

    /**
     * OnAction po kliknięciu "."
     */
    @FXML
    void buttonDotClicked()
    {
        ekran.setPromptText(ekran.getPromptText() + ".");
    }

    /**
     * OnAction po kliknięciu "-"
     */
    @FXML
    void buttonMinusClicked() {
        ekran.setPromptText(ekran.getPromptText() + "—");
        dzialania++;
    }

    /**
     * OnAction po kliknięciu "+"
     */
    @FXML
    void buttonPlusClicked() {
        ekran.setPromptText(ekran.getPromptText() + "+");
        dzialania++;
    }

    /**
     * OnAction po kliknięciu "%"
     */
    @FXML
    void buttonModuloClicked() {
        ekran.setPromptText(ekran.getPromptText() + "%");
        dzialania++;
    }

    /**
     * OnAction po kliknięciu "*"
     */
    @FXML
    void buttonRazyClicked() {
        ekran.setPromptText(ekran.getPromptText() + "x");
        dzialania++;
    }

    /**
     * OnAction po kliknięciu "/"
     */
    @FXML
    void buttonDzielClicked() {
        ekran.setPromptText(ekran.getPromptText() + "/");
        dzialania++;
    }

    /**
     * Dzialanie negacji po kliknieciu przycisku "+/-"
     */
    @FXML
    void buttonNegClicked() {
        Thread neguj;
        neguj = new Negacja(bin.isSelected(), dec.isSelected(), hex.isSelected(), ekran.getPromptText());
        UruchomWatek(neguj);
        pamiec.setText("negate(" + ekran.getPromptText() + ") = "+ negacja + "\n" + pamiec.getText() );
        ekran.setPromptText(negacja);
    }

    //***************NAWIASY*************************

    /**
     * OnAction po kliknięciu "()"
     */
    @FXML
    void buttonNawiasClicked() {
        tlo.setVisible(true);
        nawiasL.setVisible(true);
        nawiasP.setVisible(true);
        synchronized (this)
        {
            AnimateNawias(nawiasL, nawiasP);
        }
    }

    /**
     * Wypisywanie prawego nawiasu
     */
    @FXML
    void buttonNawiasPClicked(){
        synchronized (this)
        {
            AnimateNawiasBack(nawiasL, nawiasP);
        }
        tlo.setVisible(false);
        nawiasL.setVisible(false);
        nawiasP.setVisible(false);

        ekran.setPromptText(ekran.getPromptText() + ")");
    }

    /**
     * Wypisaywanie lewego nawiasu
     */
    @FXML
    void buttonNawiasLClicked(){
        synchronized (this)
        {
            AnimateNawiasBack(nawiasL, nawiasP);
        }
        tlo.setVisible(false);
        nawiasL.setVisible(false);
        nawiasP.setVisible(false);

        nawiasyOn++;
        ekran.setPromptText(ekran.getPromptText() + "(");
    }

    /**
     * Animacja wysuwająca oba nawiasy spod przycisku "()"
     * @param nawiasL nawias lewy
     * @param nawiasP nawias prawy
     */
    void AnimateNawias(Button nawiasL, Button nawiasP)
    {
            Duration duration = Duration.millis(300);
            TranslateTransition transition = new TranslateTransition(duration, nawiasL);
            transition.setByX(-40);
            transition.setByY(-50);
            transition.setCycleCount(1);
            transition.play();


            transition = new TranslateTransition(duration, nawiasP);
            transition.setByX(40);
            transition.setByY(-50);
            transition.setCycleCount(1);
            transition.play();
    }

    /**
     * Animacja wysuwająca oba nawiasy z powrotem pod przycisk "()"
     * @param nawiasL nawias lewy
     * @param nawiasP nawias prawy
     */
    void AnimateNawiasBack(Button nawiasL, Button nawiasP)
    {
        Duration duration = Duration.millis(300);
        TranslateTransition transition = new TranslateTransition(duration, nawiasL);
        transition.setByX(40);
        transition.setByY(50);
        transition.setCycleCount(1);
        transition.play();

        transition = new TranslateTransition(duration, nawiasP);
        transition.setByX(-40);
        transition.setByY(50);
        transition.setCycleCount(1);
        transition.play();
    }

    //*************************PRZESUNIECIA BITOWE***************************

    /**
     * Wykonuje dzialanie przesuniecia w lewo
     */
    @FXML
    void PrzesunLewo()
    {
        if(bin.isSelected())
        {
            String przesuniecie = (ekran.getPromptText()).substring(1);
            ekran.setPromptText(przesuniecie+ "0");
        }
        else
        {
            konwertuj = new Konwersje(true, false, false, ekran.getPromptText());
            UruchomWatek(konwertuj);
            String przesuniecie = buffor.substring(1) + "0";
            if(dec.isSelected())
            {
                konwertuj = new Konwersje(false, true, false, przesuniecie);
                UruchomWatek(konwertuj);
                ekran.setPromptText(buffor);
            }
            if(hex.isSelected())
            {
                konwertuj = new Konwersje(false, false, true, przesuniecie);
                UruchomWatek(konwertuj);
                ekran.setPromptText(buffor);
            }

        }
    }

    /**
     * Wykonuje dzialanie przesuniecia w prawo
     */
    @FXML
    void PrzesunPrawo()
    {
        if(bin.isSelected())
        {
            String przesuniecie = (ekran.getPromptText()).substring(0, (ekran.getPromptText()).length() - 1);
            ekran.setPromptText("0" + przesuniecie);
        }
        else
        {
            konwertuj = new Konwersje(true, false, false, ekran.getPromptText());
            UruchomWatek(konwertuj);
            String przesuniecie = "0" + buffor.substring(0, buffor.length() - 1);
            if(dec.isSelected())
            {
                konwertuj = new Konwersje(false, true, false, przesuniecie);
                UruchomWatek(konwertuj);
                ekran.setPromptText(buffor);
            }
            if(hex.isSelected())
            {
                konwertuj = new Konwersje(false, false, true, przesuniecie);
                UruchomWatek(konwertuj);
                ekran.setPromptText(buffor);
            }
        }
    }

    //*****************KONWERSJE*****************************

    /**
     * Akcje wykonywane po zaznaczeniu Hex check boxa
     */
    @FXML
    void HexOn(){

        DisableLetterButtons(false);
        DisableNotBinNumbers(false);
        przecinek.setDisable(true);
        konwertuj = new Konwersje(false, false, true, ekran.getPromptText());
        UruchomWatek(konwertuj);
        ekran.setPromptText(buffor);
    }

    /**
     * Akcje wykonywane po zaznaczeniu Dec check boxa
     */
    @FXML
    void DecOn(){

        DisableLetterButtons(true);
        DisableNotBinNumbers(false);
        przecinek.setDisable(false);
        konwertuj = new Konwersje(false, true, false, ekran.getPromptText());
        UruchomWatek(konwertuj);
        ekran.setPromptText(buffor);
    }

    /**
     * Akcje wykonywane po zaznaczeniu Bin check boxa
     */
    @FXML
    void BinOn(){

        DisableLetterButtons(true);
        DisableNotBinNumbers(true);
        przecinek.setDisable(false);
        konwertuj = new Konwersje(true, false, false, ekran.getPromptText());
        UruchomWatek(konwertuj);
        ekran.setPromptText(buffor);
    }

    void WyczyscKonwersjeZBoku()
    {
        decNum.setText("0");
        hexNum.setText("0");
        binNum.setText("0");
    }

    void zamienNaBoku()
    {
        if(dec.isSelected())
        {
            decNum.setText(WytnijOdZnaku(ekran.getPromptText()));
            Thread hexa, bina;

            hexa = new Konwersje(false, false, true, ekran.getPromptText());
            bina = new Konwersje(true, false, false, ekran.getPromptText());

            UruchomWatek(hexa);
            fromDec = true;
            fromBin = false;
            fromHex = false;
            hexNum.setText(buffor);

            UruchomWatek(bina);
            fromDec = true;
            fromBin = false;
            fromHex = false;
            binNum.setText(buffor);

        }
        if(bin.isSelected())
        {
            binNum.setText(WytnijOdZnaku(ekran.getPromptText()));
            Thread hexa, deca;

            hexa = new Konwersje(false, false, true, ekran.getPromptText());
            deca = new Konwersje(false, true, false, ekran.getPromptText());

            UruchomWatek(hexa);
            fromDec = false;
            fromBin = true;
            fromHex = false;
            hexNum.setText(buffor);

            UruchomWatek(deca);
            fromDec = false;
            fromBin = true;
            fromHex = false;
            decNum.setText(buffor);
        }
        if(hex.isSelected())
        {
            hexNum.setText(WytnijOdZnaku(ekran.getPromptText()));
            Thread bina, deca;

            bina = new Konwersje(true, false, false, ekran.getPromptText());
            deca = new Konwersje(false, true, false, ekran.getPromptText());

            UruchomWatek(bina);
            fromDec = false;
            fromBin = false;
            fromHex = true;
            binNum.setText(buffor);

            UruchomWatek(deca);
            fromDec = false;
            fromBin = false;
            fromHex = true;
            decNum.setText(buffor);

        }
    }

    /**
     * Włączanie/wyłączenie przycisków liter do systemu hexa
     * @param yeah zmienna mowiąca czy włączyć czy wyłączyć
     */
    void DisableLetterButtons(boolean yeah)
    {
        A.setDisable(yeah);
        B.setDisable(yeah);
        C.setDisable(yeah);
        D.setDisable(yeah);
        E.setDisable(yeah);
        F.setDisable(yeah);
    }

    /**
     * Włączanie/ wyłączenie liter i cyfr, aby przygotować kalkulator do systemu binarnego
     * @param yeah zmienna mowiąca czy włączyć czy wyłączyć
     */
    void DisableNotBinNumbers(boolean yeah)
    {
        cyfra2.setDisable(yeah);
        cyfra3.setDisable(yeah);
        cyfra4.setDisable(yeah);
        cyfra5.setDisable(yeah);
        cyfra6.setDisable(yeah);
        cyfra7.setDisable(yeah);
        cyfra8.setDisable(yeah);
        cyfra9.setDisable(yeah);
    }

    /**
     * Funkcja sprawdzajaca jakie i ile dzialan ma do wykonania kalkulator
     * @param input wprowadzone dzialanie przez uzytkownika
     * @return wynik dzialania
     */
    double DzialaniaStart(String input){
        if(dzialania == 0)
            return Double.parseDouble(input);
        else
        {
            double wynik = 0;
            String arg1;
            String arg2;

            int pierwszenstwoStart = 0;
            int pierszenstwoStop = 0;

            String znaki = "+—/x%";

            if(nawiasyOn!=0)
            {
                for(int a=0;a<nawiasyOn;a++)
                {
                    for(int j=0;j<input.length();j++)
                    {
                        if( input.charAt(j) == '(' )
                        {
                            pierwszenstwoStart = j+1;
                        }
                        if( input.charAt(j) == ')' )
                        {
                            pierszenstwoStop = j;
                        }
                    }
                    for(int j=pierwszenstwoStart;j<pierszenstwoStop;j++)
                    {
                        for(int i=0;i<znaki.length();i++)
                        {
                            if( input.charAt(j) == znaki.charAt(i))
                            {
                                arg1 = input.substring(pierwszenstwoStart, j);
                                arg2 = input.substring(j+1, pierszenstwoStop);
                                wynik = wynik + WykonajDzialanie(znaki.charAt(i), arg1, arg2);
                                j = pierszenstwoStop;
                                i = znaki.length();
                            }
                        }
                    }
                    input = input.substring(0, pierwszenstwoStart-1) + wynik + input.substring(pierszenstwoStop+1);
                    dzialania--;
                    wynik = 0;
                }
            }

            char [][]tab = new char[dzialania][2];
            int d = 0;

            //Kolejnosc wykonywania dzialan
            for(int i=0;i<znaki.length();i++) {
                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(j) == znaki.charAt(i))
                    {
                        tab[d][0] = znaki.charAt(i);
                        tab[d][1] = (char) (j+1);
                        d++;
                    }
                }
            }
            for(int i=0;i<tab.length - 1;i++) {
                if(tab[i][0] == '—' || tab[i][0] == '+')
                {
                    if(tab[i+1][0] == 'x' || tab[i+1][0] == '/' || tab[i+1][0] == '%')
                    {
                        char temp;
                        temp = tab[i][0];
                        tab[i][0] = tab[i+1][0];
                        tab[i+1][0] = temp;

                        temp = tab[i][1];
                        tab[i][1] = tab[i+1][1];
                        tab[i+1][1] = temp;
                    }
                }
            }


            int pozycjaArg1;
            int pozycjaArg2;

            for(int a=0;a<tab.length;a++)
            {
                pozycjaArg1 = 0;
                pozycjaArg2 = input.length();
                for(int j = 0; j <tab[a][1] - 1;j++)
                {
                    for(int i=0;i<znaki.length();i++)
                    {
                        if (znaki.charAt(i) == input.charAt(j)) {
                            pozycjaArg1 = j + 1;
                            break;
                        }
                    }
                }
                for(int j=tab[a][1]+1;j<input.length();j++)
                {
                    for(int i=0;i<znaki.length();i++)
                    {
                        if (znaki.charAt(i) == input.charAt(j)) {
                            pozycjaArg2 = j;
                            break;
                        }
                    }
                }
                arg1 = input.substring(pozycjaArg1, tab[a][1]-1);
                arg2 = input.substring(tab[a][1], pozycjaArg2);
                wynik = wynik + WykonajDzialanie(tab[a][0], arg1, arg2);
                if(a != tab.length - 1)
                {
                    input = input.substring(0, pozycjaArg1) + wynik + input.substring(pozycjaArg2);
                    wynik = 0;
                }
            }

            return wynik;
        }

    }

    /**
     * Funkcja wykonujaca pojedyncze dzialanie
     * @param znak znak dzialania
     * @param arg1 pierwszy argument dzialania
     * @param arg2 drugi argument dzialania
     * @return wynik dzialania
     */
    double WykonajDzialanie(char znak, String arg1, String arg2)
    {
        double wynik;
        if (znak == '+')
        {
            Thread dodawanko;
            dodawanko = new Dodawanie(bin.isSelected(), dec.isSelected(), hex.isSelected(), arg1, arg2);
            UruchomWatek(dodawanko);
            wynik = Double.parseDouble(dodaj);
            return wynik;
        }
        if (znak == '—')
        {
            Thread odejmowanko;
            odejmowanko = new Odejmowanie(bin.isSelected(), dec.isSelected(), hex.isSelected(), arg1, arg2);
            UruchomWatek(odejmowanko);
            wynik = Double.parseDouble(odejmij);
            return wynik;
        }
        if (znak == '/')
        {
            Thread dzielenie;
            dzielenie = new Dzielenie(bin.isSelected(), dec.isSelected(), hex.isSelected(), arg1, arg2);
            UruchomWatek(dzielenie);
            wynik = Double.parseDouble(dziele);
            return wynik;
        }
        if (znak == 'x')
        {
            Thread mnozenie;
            mnozenie = new Mnozenie(bin.isSelected(), dec.isSelected(), hex.isSelected(), arg1, arg2);
            UruchomWatek(mnozenie);
            wynik = Double.parseDouble(mnoze);
            return wynik;
        }
        if (znak == '%')
        {
            Thread modullo;
            modullo = new Modulo(bin.isSelected(), dec.isSelected(), hex.isSelected(), arg1, arg2);
            UruchomWatek(modullo);
            wynik = Double.parseDouble(model);
            return wynik;
        }
        else return 0;
    }

    //*************************ODCZYT ZAPIS DO PLIKU*****************
    @FXML
    void ZapiszDo()
    {
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("kalkulator.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert zapis != null;
        zapis.println(ekran.getPromptText());
        zapis.close();
    }

    @FXML
    void OdczytajZ()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku do odczytu");
        String fileName = scan.nextLine();
        File file = new File(fileName);
        Scanner in = null;
        try {
             in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dzialania = 0;
        String znaki = "+—/x%";
        assert in != null;
        String input = in.nextLine();
        for(int i=0;i<znaki.length();i++) {
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == znaki.charAt(i))
                {
                    dzialania++;
                }
            }
        }

        ekran.setPromptText(input);
    }
}
