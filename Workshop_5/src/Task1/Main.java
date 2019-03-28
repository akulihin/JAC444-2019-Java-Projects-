package Task1;

import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.util.Optional;

public class Main extends Application {

    Stage window;
    Scene scene_start_page, scene_confirm_page;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        final Account[] account = { null };

        window.setTitle("ATM");
        window.setResizable(false);

        // Label
        Label l_accountNumber = new Label("Enter an Account number:");
        Label l_welcome = new Label();
        Label l_menuOptionions = new Label("What would you like to do?");
        // end Label

        // Buttons
        Button b_submit = new Button("Submit");
        Button b_checkBalance = new Button("Check Balance");
        Button b_withdrawMoney = new Button("Withdraw Money");
        Button b_depositMoney = new Button("Deposit Money");
        Button b_exit = new Button("Exit the Account");
        // end Buttons

        // Text
        TextField txt_AccountNumber = new TextField();
        // end Text

        b_submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (txt_AccountNumber.getText().isEmpty()) {
                    return;
                }
                int account_no = Integer.parseInt(txt_AccountNumber.getText());
                account[0] = Data.Check(account_no);
                if (account[0].getId() != -1 && account[0].getPin() != 0) {
                    l_welcome.setText("Welcome Account " + account[0].getId());

                    TextInputDialog dialog = new TextInputDialog("");
                    dialog.setTitle("Login");
                    dialog.setHeaderText(null);
                    dialog.setContentText("Enter pin code: ");

                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        int pin = Integer.parseInt(result.get());
                        if (account[0].getPin() == pin) {
                            window.setScene(scene_confirm_page);
                        } else {
                            new Alert(Alert.AlertType.ERROR, "Wrong pin code").showAndWait();
                        }

                    }
                }
                if (account[0].getId() != -1 && account[0].getPin() == 0) {
                    TextInputDialog dialog = new TextInputDialog("");
                    dialog.setTitle("Welcome");
                    dialog.setHeaderText(null);
                    dialog.setContentText("Create pin for your account: ");

                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        int pin = Integer.parseInt(result.get());
                        account[0].setPin(pin);
                        window.setScene(scene_confirm_page);
                    }

                    result.ifPresent(name -> System.out
                            .println("Account" + account[0].getId() + " pin code has changed: " + name));
                }
                if (account[0].getId() == -1) {
                    new Alert(Alert.AlertType.ERROR, "Error:: Account does not exist ").showAndWait();
                }
            }
        });

        b_exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Data.Update(account[0]);
                account[0] = null;
                window.setScene(scene_start_page);
            }
        });

        b_checkBalance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                new Alert(Alert.AlertType.INFORMATION, "Your balance: " + account[0].getBalance()).showAndWait();
            }
        });

        b_depositMoney.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Deposit Money");
                dialog.setHeaderText(null);
                dialog.setContentText("Please enter deposit amount:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    double amount = Double.parseDouble(result.get());
                    account[0].deposit(amount);
                }

                result.ifPresent(name -> System.out.println("Deposited amount: " + name));
            }
        });

        b_withdrawMoney.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Withdraw Money");
                dialog.setHeaderText(null);
                dialog.setContentText("Please enter withdraw amount:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    double amount = Double.parseDouble(result.get());
                    account[0].withdraws(amount);
                }

                result.ifPresent(name -> System.out.println("Withdraw amount: " + name));
            }
        });

        Group group = new Group();

        l_accountNumber.setLayoutX(100);
        l_accountNumber.setLayoutY(100);

        txt_AccountNumber.setLayoutX(270);
        txt_AccountNumber.setLayoutY(95);

        b_submit.setLayoutX(270);
        b_submit.setLayoutY(170);

        txt_AccountNumber.setPrefWidth(250);

        b_submit.setPrefWidth(100);

        group.getChildren().add(l_accountNumber);
        group.getChildren().add(txt_AccountNumber);
        group.getChildren().add(b_submit);

        scene_start_page = new Scene(group, 600, 300);

        window.setScene(scene_start_page);
        window.show();

        Group group1 = new Group();

        l_welcome.setLayoutX(240);
        l_welcome.setLayoutY(30);

        l_menuOptionions.setLayoutX(220);
        l_menuOptionions.setLayoutY(60);

        b_checkBalance.setLayoutX(245);
        b_checkBalance.setLayoutY(100);

        b_depositMoney.setLayoutX(245);
        b_depositMoney.setLayoutY(150);

        b_withdrawMoney.setLayoutX(240);
        b_withdrawMoney.setLayoutY(200);

        b_exit.setLayoutX(242);
        b_exit.setLayoutY(250);

        group1.getChildren().add(l_welcome);
        group1.getChildren().add(l_menuOptionions);
        group1.getChildren().add(b_checkBalance);
        group1.getChildren().add(b_depositMoney);
        group1.getChildren().add(b_withdrawMoney);
        group1.getChildren().add(b_exit);

        scene_confirm_page = new Scene(group1, 600, 400);
        window.show();
    }

    public static void main(String[] args) {
        Data.Print();
        launch(args);
    }
}
