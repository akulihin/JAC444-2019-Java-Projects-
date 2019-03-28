package Task2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppTask2 extends Application {

    @Override
    public void start(Stage stage) {
        init(stage);
    }
    public static void main(String[] args) {
        launch(args);
    }

    private void init(Stage stage) {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Scene scene = new Scene(grid, 300, 200, Color.WHITE);

        Label l_year = new Label("Enter the Year:");
        Label l_gender = new Label("Enter the Gender:");
        Label l_name = new Label("Enter the Name:");
        Label l_leftSide = new Label("");
        Label l_rightSide = new Label("");

        TextField txt_year = new TextField();
        TextField txt_gender = new TextField();
        TextField txt_name = new TextField();

        Button b_exit = new Button("Exit");
        Button b_submit = new Button("Submit");

        txt_year.setPromptText("1996");
        txt_year.setPrefColumnCount(4);
        txt_year.getText();

        txt_gender.setPromptText("M");
        txt_gender.setPrefColumnCount(1);
        txt_gender.getText();

        txt_name.setPromptText("Artem");
        txt_name.setPrefColumnCount(15);
        txt_name.getText();

        b_submit.setOnAction(e -> {
            if (txt_year.getText() != null && !txt_year.getText().isEmpty() && txt_gender.getText() != null
                    && !txt_gender.getText().isEmpty() && txt_name.getText() != null && !txt_name.getText().isEmpty()) {

                boolean gender = true; //girl
                int rank = 0;

                if (txt_gender.getText().toLowerCase().equals("m")) {
                    gender = false; //boi = false
                }

                try {
                    rank = getRank(txt_name.getText(), Integer.parseInt(txt_year.getText()), gender);
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found!");
                }

                if (gender) {
                    l_leftSide.setText("Girl's name " + txt_name.getText());
                } else {
                    l_leftSide.setText("Boy's name " + txt_name.getText());
                }

                if (rank == 0) {
                    l_rightSide.setText("Was not found");
                } else {
                    l_rightSide.setText("Was ranked #" + rank + " In the year " + txt_year.getText());
                }

            } else {
                l_leftSide.setText("Invalid!");
            }
        });

        b_exit.setOnAction(e -> System.exit(0));

        grid.getChildren().add(l_year);
        GridPane.setConstraints(l_year, 0, 0);

        grid.getChildren().add(l_gender);
        GridPane.setConstraints(l_gender, 0, 1);

        grid.getChildren().add(l_name);
        GridPane.setConstraints(l_name, 0, 2);

        grid.getChildren().add(l_leftSide);
        GridPane.setConstraints(l_leftSide, 0, 4);
        grid.getChildren().add(l_rightSide);
        GridPane.setConstraints(l_rightSide, 1, 4);

        grid.getChildren().add(txt_year);
        GridPane.setConstraints(txt_year, 1, 0);

        grid.getChildren().add(txt_gender);
        GridPane.setConstraints(txt_gender, 1, 1);

        grid.getChildren().add(txt_name);
        GridPane.setConstraints(txt_name, 1, 2);

        grid.getChildren().add(b_submit);
        GridPane.setConstraints(b_submit, 0, 3);

        grid.getChildren().add(b_exit);
        GridPane.setConstraints(b_exit, 1, 3);

        stage.setTitle("Search Name Ranking Application");
        stage.setScene(scene);
        stage.show();
    }


    public static int getRank(String name, int year, boolean gender) throws FileNotFoundException {
        String rank = "error";
        String nameB, qtyB, nameG, qtyG;
        boolean found = false;
        var path = "C:\\Users\\Octopus\\Desktop\\JAC444\\Workshop_5\\out\\production\\Workshop 5\\Task2\\babynamesranking"
                + year + ".txt";
        File file = new File(path);
        Scanner line = new Scanner(file);

        while (line.hasNextLine() && found == false) {
            rank = line.next();
            nameB = line.next();
            qtyB = line.next();
            nameG = line.next();
            qtyG = line.next();

            System.out.println(rank + "+" + nameB + "+" + qtyB + "+" + nameG + "+" + qtyG);

            //boi = false
            if (!gender && nameB.equals(name)) {
                found = true;
            }

            if(gender && nameG.equals(name)){
                    found = true;
            }
        }

        line.close();
        if (rank != "error") {
            return (Integer.parseInt(rank));
        }
        return 0;
    }
}
