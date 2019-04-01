package Task2;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.lang.String;

public class AppTask2 extends Application {

    Stage window;
    Scene Main;

    public static int counter = (int) (new File("src/Task2/data.txt").length() / 40);
    public static int pos = 0;
    Address address;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setResizable(false);

        Label l_fName = new Label("First Name: ");
        Label l_lName = new Label("Last Name: ");
        Label l_city = new Label("City: ");
        Label l_prov = new Label("Province: ");
        Label l_postal = new Label("Postal Code: ");

        TextField txt_fName = new TextField();
        TextField txt_lName = new TextField();
        TextField txt_city = new TextField();
        TextField txt_postal = new TextField();

        Button b_add = new Button("Add");
        Button b_first = new Button("First");
        Button b_next = new Button("Next");
        Button b_prev = new Button("Previous");
        Button b_last = new Button("Last");
        Button b_upd = new Button("Update");

        ChoiceBox<String> c_prov = new ChoiceBox<>();

        c_prov.getItems().addAll("Select Province", "AB", "BC", "MB", "NB", "NL", "NS", "ON", "PE", "QC", "SK", "NT",
                "NU", "YT");
        c_prov.setValue("Select Province");

        Group group = new Group();
        {
            l_fName.setLayoutX(20);
            l_fName.setLayoutY(20);
            txt_fName.setLayoutX(100);
            txt_fName.setLayoutY(16);

            l_lName.setLayoutX(20);
            l_lName.setLayoutY(60);
            txt_lName.setLayoutX(100);
            txt_lName.setLayoutY(56);

            l_city.setLayoutX(20);
            l_city.setLayoutY(120);
            txt_city.setLayoutX(55);
            txt_city.setLayoutY(116);

            l_prov.setLayoutX(180);
            l_prov.setLayoutY(120);
            c_prov.setLayoutX(240);
            c_prov.setLayoutY(116);

            l_postal.setLayoutX(380);
            l_postal.setLayoutY(120);
            txt_postal.setLayoutX(460);
            txt_postal.setLayoutY(116);

            b_add.setLayoutX(5);
            b_add.setLayoutY(160);

            b_first.setLayoutX(98);
            b_first.setLayoutY(160);

            b_next.setLayoutX(191);
            b_next.setLayoutY(160);

            b_prev.setLayoutX(284);
            b_prev.setLayoutY(160);

            b_last.setLayoutX(377);
            b_last.setLayoutY(160);

            b_upd.setLayoutX(470);
            b_upd.setLayoutY(160);

            txt_fName.setPrefWidth(450);
            txt_lName.setPrefWidth(450);
            txt_city.setPrefWidth(120);
            txt_postal.setPrefWidth(90);

            b_add.setPrefWidth(90);
            b_first.setPrefWidth(90);
            b_next.setPrefWidth(90);
            b_prev.setPrefWidth(90);
            b_last.setPrefWidth(90);
            b_upd.setPrefWidth(90);

            group.getChildren().add(l_fName);
            group.getChildren().add(txt_fName);

            group.getChildren().add(l_lName);
            group.getChildren().add(txt_lName);

            group.getChildren().add(l_city);
            group.getChildren().add(txt_city);

            group.getChildren().add(l_prov);
            group.getChildren().add(c_prov);

            group.getChildren().add(l_postal);
            group.getChildren().add(txt_postal);

            group.getChildren().add(b_add);
            group.getChildren().add(b_first);
            group.getChildren().add(b_next);
            group.getChildren().add(b_prev);
            group.getChildren().add(b_last);
            group.getChildren().add(b_upd);
        }

        address = new Address();

        if (counter > 0) {
            address = Address.ReadAddress(1);
            pos = 1;
            txt_fName.setText(address.fname);
            txt_lName.setText(address.lname);
            txt_city.setText(address.city);
            c_prov.setValue(address.prov);
            txt_postal.setText(address.postcode);
        }

        b_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (txt_fName.getText().equals("") || txt_lName.getText().equals("") || txt_city.getText().equals("")
                        || c_prov.getValue().equals("Select Province") || txt_postal.getText().equals("")) {
                } else {
                    address.fname = txt_fName.getText();
                    address.lname = txt_lName.getText();
                    address.city = txt_city.getText();
                    if (c_prov.getValue() == "Select Province") {
                        address.prov = "";
                    } else {
                        address.prov = c_prov.getValue();
                    }
                    address.prov = c_prov.getValue();
                    address.postcode = txt_postal.getText();
                    counter++;
                    address.WriteAddress(counter);
                    address.Clear();
                    txt_fName.setText("");
                    txt_lName.setText("");
                    txt_city.setText("");
                    c_prov.setValue("Select Province");
                    txt_postal.setText("");
                }
            }
        });

        b_first.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Here");
                if (counter != 0) {
                    address = Address.ReadAddress(1);
                    pos = 1;
                }
                txt_fName.setText(address.fname);
                txt_lName.setText(address.lname);
                txt_city.setText(address.city);
                c_prov.setValue(address.prov);
                txt_postal.setText(address.postcode);
            }
        });

        b_next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (txt_fName.getText().equals("") || txt_lName.getText().equals("") || txt_city.getText().equals("")
                        || c_prov.getValue().equals("Select Province") || txt_postal.getText().equals("")) {

                } else {
                    if (pos + 1 <= counter) {
                        pos++;
                        address = Address.ReadAddress(pos);
                    } else {
                        address.Clear();
                    }
                    txt_fName.setText(address.fname);
                    txt_lName.setText(address.lname);
                    txt_city.setText(address.city);
                    c_prov.setValue(address.prov);
                    txt_postal.setText(address.postcode);
                }
            }
        });

        b_prev.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (pos - 1 >= 1) {
                    pos--;
                    address = Address.ReadAddress(pos);
                    txt_fName.setText(address.fname);
                    txt_lName.setText(address.lname);
                    txt_city.setText(address.city);
                    c_prov.setValue(address.prov);
                    txt_postal.setText(address.postcode);
                }
            }
        });

        b_last.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (counter != 0) {
                    address = Address.ReadAddress(counter);
                    pos = counter;
                } else {
                    address.Clear();
                    pos = counter;
                }
                txt_fName.setText(address.fname);
                txt_lName.setText(address.lname);
                txt_city.setText(address.city);
                c_prov.setValue(address.prov);
                txt_postal.setText(address.postcode);
            }
        });

        b_upd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (txt_fName.getText().equals("") || txt_lName.getText().equals("") || txt_city.getText().equals("")
                        || c_prov.getValue().equals("Select Province") || txt_postal.getText().equals("")) {
                } else {
                    address.fname = txt_fName.getText();
                    address.lname = txt_lName.getText();
                    address.city = txt_city.getText();
                    if (c_prov.getValue().equals("Select Province")) {
                        address.prov = "";
                    } else {
                        address.prov = c_prov.getValue();
                    }
                    address.prov = c_prov.getValue();
                    address.postcode = txt_postal.getText();
                    address.WriteAddress(pos);
                }
            }
        });

        Main = new Scene(group, 565, 190);

        window.setScene(Main);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
