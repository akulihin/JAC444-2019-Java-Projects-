package sample;

import java.util.HashSet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
        primaryStage.show();
    }


    static int count;
    static double x, y;
    static boolean[] resBool = { false, false, false, false };
    static HashSet<Double> answers = new HashSet<>();

    static void genNewNumbers() {
        x = (int) (Math.random() * 101);
        y = x;
        while (x == y) {
            y = (int) (Math.random() * 101);
        }

        count = 0;
        for (int i = 0; i < 4; ++i) {
            resBool[i] = false;
        }

        answers.add(Double.parseDouble(String.format("%.2f", (x + y))));
        answers.add(Double.parseDouble(String.format("%.2f", (x - y))));
        answers.add(Double.parseDouble(String.format("%.2f", (x * y))));
        answers.add(Double.parseDouble(String.format("%.2f", (x / y))));
    }
}