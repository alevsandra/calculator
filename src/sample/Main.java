package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static boolean fromBin;
    static boolean fromHex;
    static boolean fromDec;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        primaryStage.setTitle("Kalkulator");
        primaryStage.setScene(new Scene(root, 600, 660));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Metoda uruchamiająca watek oraz konczaca jego prace
     * @param t uruchamiany watek
     */
    static void UruchomWatek(Thread t)
    {
        t.start();
        try
        {
            t.join();
        } catch (InterruptedException ignored) {}
    }

}
