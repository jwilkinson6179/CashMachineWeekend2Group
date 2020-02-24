// Blue wave image from VectorStock
// https://www.vectorstock.com/royalty-free-vector/blue-wave-vector-60954

package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author ZipCodeWilmington -- Corey Williams, Sandy Setiawan, James Wilkinson, and Maurice Russ' fork
 */
public class CashMachineApp extends Application {

    private TextArea field = new TextArea();


    private CashMachine cashMachine = new CashMachine(new Bank());
    Stage window;

    // TODO: Requires beautificati
    private Parent userScene() {

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 35, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        grid2.setStyle("-fx-background-image: url(\"bankapp.jpg\");");
        double height = 83;
        double width = 200;
        field.setPrefHeight(height);
        field.setPrefWidth(width);
        field.setStyle("-fx-background-color: #ffd65b, #e68400,#ffef84, #f2ba44,#ffea6a, #efaa22");




        Label welcomeLabel = new Label("Welcome back. "  );
        welcomeLabel.setStyle("-fx-font-size: 25px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #ffd65b,#ffef84, #f2ba44");
        GridPane.setConstraints(welcomeLabel, 2, 0);
        TextField welcomeInput = new TextField();
        GridPane.setConstraints(welcomeInput, 1, 0);

        Button btnDeposit = new Button("Deposit");
        GridPane.setConstraints(btnDeposit, 2, 2);
        Button btnWithdraw = new Button("Withdraw");
        GridPane.setConstraints(btnWithdraw, 2, 3);
        Button btnLogout = new Button("Log Out");
        GridPane.setConstraints(btnLogout, 3, 20);



        btnDeposit.setStyle("    -fx-background-color: \n" +
                "        linear-gradient(#ffd65b, #e68400),\n" +
                "        linear-gradient(#ffef84, #f2ba44),\n" +
                "        linear-gradient(#ffea6a, #efaa22),\n" +
                "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n" +
                "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,2,3,0;\n" +
                "    -fx-text-fill: #654b00;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 14px;\n" +
                "    -fx-padding: 10 20 10 20;");

        btnWithdraw.setStyle("    -fx-background-color: \n" +
                "        linear-gradient(#ffd65b, #e68400),\n" +
                "        linear-gradient(#ffef84, #f2ba44),\n" +
                "        linear-gradient(#ffea6a, #efaa22),\n" +
                "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n" +
                "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,2,3,0;\n" +
                "    -fx-text-fill: #654b00;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 14px;\n" +
                "    -fx-padding: 10 20 10 20;");

        btnLogout.setStyle("    -fx-background-color: \n" +
                "        linear-gradient(#ff5400, #be1d00);" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,2,3,0;\n" +
                "    -fx-text-fill: #654b00;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 14px;\n" +
                "    -fx-padding: 10 20 10 20;");



        grid2.getChildren().addAll(field,welcomeLabel, btnDeposit, btnWithdraw, btnLogout);

        btnDeposit.setOnAction(e -> {
            Float amount = Float.parseFloat(field.getText());
            cashMachine.deposit(amount);
            field.clear();

         field.setText(cashMachine.toString());
    });

        btnWithdraw.setOnAction(e -> {
            Float amount = Float.parseFloat(field.getText());
            cashMachine.withdraw(amount);
            field.clear();

            field.setText(cashMachine.toString());
        });

        btnLogout.setOnAction(e -> {
            cashMachine.exit();
            Scene loginSplash = new Scene(loginScene(), 300, 200);
            window.setScene(loginSplash);
        });

        return grid2;
    }

    private Parent loginScene()
    {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 100, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setStyle("-fx-background-image: url(\"File:loginBackground.png\");");

        Label acctLabel = new Label("Account Number: ");
        acctLabel.setStyle("-fx-font-size: 12px;" +
        "-fx-font-weight: bold;" +
        "-fx-text-fill: #333333;");
        GridPane.setConstraints(acctLabel, 0, 0);
        TextField acctInput = new TextField();
        GridPane.setConstraints(acctInput, 1, 0);

        Label pinLabel = new Label("PIN: ");
        pinLabel.setStyle("-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #333333;");
        GridPane.setConstraints(pinLabel, 0, 1);
        PasswordField pinInput = new PasswordField();
        GridPane.setConstraints(pinInput, 1, 1);

        Button btnLogin = new Button("Log In");
        GridPane.setConstraints(btnLogin, 1, 2);
        Button btnSignUp = new Button("New User");
        GridPane.setConstraints(btnSignUp, 1, 3);

        //btnLogin.setStyle("-fx-background-color: linear-gradient(#f0ff35, #a9ff00), radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%); -fx-background-radius: 6, 5; -fx-background-insets: 0, 1; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 ); -fx-text-fill: #395306;");
        btnLogin.setStyle("    -fx-background-color: \n" +
                "        linear-gradient(#ffd65b, #e68400),\n" +
                "        linear-gradient(#ffef84, #f2ba44),\n" +
                "        linear-gradient(#ffea6a, #efaa22),\n" +
                "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n" +
                "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,2,3,0;\n" +
                "    -fx-text-fill: #654b00;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 14px;\n" +
                "    -fx-padding: 10 20 10 20;");

        btnLogin.setOnAction(e ->
        {
            int id = Integer.parseInt(acctInput.getText());
            int pin = Integer.parseInt(pinInput.getText());
            if (cashMachine.getBank().getAccountByPin(pin, id)) {
                cashMachine.login(id);
            }
            field.clear();


            if(!cashMachine.toString().equals("Try account 1000 or 2000 and click submit.")) {
                window.setScene(new Scene(userScene()));
            } else {
                PopupWindow.Popup("Error", "Invalid pin!\n Please try a different pin!");
            }
        });

        btnSignUp.setStyle("    -fx-background-color: \n" +
                "        linear-gradient(#ffd65b, #e68400),\n" +
                "        linear-gradient(#ffef84, #f2ba44),\n" +
                "        linear-gradient(#ffea6a, #efaa22),\n" +
                "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n" +
                "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,2,3,0;\n" +
                "    -fx-text-fill: #654b00;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 14px;\n" +
                "    -fx-padding: 10 20 10 20;");


        grid.getChildren().addAll(acctLabel, acctInput, pinLabel, pinInput, btnLogin, btnSignUp);

        return grid;
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        window = stage;
        window.setScene(new Scene(loginScene(), 300, 200));

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}