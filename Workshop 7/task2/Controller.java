package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label l_titile, l_add, l_sub, l_multi, l_div, l_corr, l_incorr;

    @FXML
    private TextField txt_add, txt_sub, txt_multi, txt_div;

    @FXML
    void initialize() {
        Main.genNewNumbers();
        changeLabels();
        clearFields();

        txt_add.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txt_add.getText() != null) && (txt_add.getText().length() > 0) && newValue.compareTo(".") != 0
                    && newValue.compareTo("-") != 0 && Main.answers.contains(Double.parseDouble(newValue))) {
                Main.resBool[0] = true;
                txt_add.setDisable(true);
            } else {
                Main.resBool[0] = false;
            }

            update();
        });

        txt_sub.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txt_sub.getText() != null) && (txt_sub.getText().length() > 0) && newValue.compareTo(".") != 0
                    && newValue.compareTo("-") != 0 && (Main.answers.contains(Double.parseDouble(newValue)))) {
                Main.resBool[1] = true;
                txt_sub.setDisable(true);
            } else {
                Main.resBool[1] = false;
            }

            update();
        });

        txt_multi.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txt_multi.getText() != null) && (txt_multi.getText().length() > 0) && newValue.compareTo(".") != 0
                    && newValue.compareTo("-") != 0 && (Main.answers.contains(Double.parseDouble(newValue)))) {
                Main.resBool[2] = true;
                txt_multi.setDisable(true);
            } else {
                Main.resBool[2] = false;
            }

            update();
        });

        txt_div.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txt_div.getText() != null) && (txt_div.getText().length() > 0) && newValue.compareTo(".") != 0
                    && newValue.compareTo("-") != 0 && (Main.answers.contains(Double.parseDouble(newValue)))) {
                Main.resBool[3] = true;
                txt_div.setDisable(true);
            } else {
                Main.resBool[3] = false;
            }

            update();
        });
    }

    @FXML
    void newQuiz() {
        Main.genNewNumbers();
        changeLabels();
        clearFields();
    }

    void changeLabels() {
        l_titile.setText(String.format("Two randomly generated numbers are: %.2f and %.2f", Main.x, Main.y));
        l_add.setText(String.format("%.2f + %.2f = ", Main.x, Main.y));
        l_sub.setText(String.format("%.2f - %.2f = ", Main.x, Main.y));
        l_multi.setText(String.format("%.2f * %.2f = ", Main.x, Main.y));
        l_div.setText(String.format("%.2f / %.2f = ", Main.x, Main.y));

        l_corr.setText("Number of correct answers: ");
        l_incorr.setText("Number of incorrect answers: ");
    }

    void update() {
        Main.count = 0;
        for (boolean b : Main.resBool) {
            Main.count = b ? Main.count + 1 : Main.count;
        }

        l_corr.setText("Number of correct answers: " + Main.count);
        l_incorr.setText("Number of incorrect answers: " + (4 - Main.count));
    }

    void clearFields() {
        txt_add.setDisable(false);
        txt_sub.setDisable(false);
        txt_multi.setDisable(false);
        txt_div.setDisable(false);

        txt_add.setText(null);
        txt_sub.setText(null);
        txt_div.setText(null);
        txt_multi.setText(null);

    }
}