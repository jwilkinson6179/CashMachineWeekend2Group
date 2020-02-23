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

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());
    Stage window;

    // TODO: Requires beautificati
    private Parent userScene() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);
        FlowPane flowpane = new FlowPane();
        TextArea areaInfo = new TextArea();
        Button btnDeposit = new Button("Deposit");
        Button btnWithdraw = new Button("Withdraw");
        Button btnLogout = new Button("Logout");
        btnDeposit.setStyle("-fx-background-color: #3c8aff;-fx-border-width: 2px;-fx-text-fill: #ff1815 ");
        btnWithdraw.setStyle("-fx-background-color: #10ff4e; ");
        btnLogout.setStyle("-fx-border-color: #ff0000; -fx-border-width: 2px;-fx-text-fill: #ff1815");
        btnLogout.setTranslateX(340);
        btnWithdraw.setTranslateX(10);

        areaInfo.setText(cashMachine.toString());

        vbox.getChildren().addAll(field, flowpane, areaInfo, btnDeposit, btnWithdraw, btnLogout);

        btnDeposit.setOnAction(e -> {
            Float amount = Float.parseFloat(field.getText());
            cashMachine.deposit(amount);
            field.clear();

            areaInfo.setText(cashMachine.toString());
        });

        btnWithdraw.setOnAction(e -> {
            Float amount = Float.parseFloat(field.getText());
            cashMachine.withdraw(amount);
            field.clear();

            areaInfo.setText(cashMachine.toString());
        });

        btnLogout.setOnAction(e -> {
            cashMachine.exit();
            Scene loginSplash = new Scene(loginScene(), 300, 200);
            window.setScene(loginSplash);
        });

        return vbox;
    }

    private Parent loginScene()
    {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
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