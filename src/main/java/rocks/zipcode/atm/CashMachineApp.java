package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());
    Stage window;


    // TODO: Requires beautification
    private Parent userScene() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);
        FlowPane flowpane = new FlowPane();
        TextArea areaInfo = new TextArea();
        Button btnDeposit = new Button("Deposit");
        Button btnWithdraw = new Button("Withdraw");
        Button btnLogout = new Button("Logout");
        Button btnLogin = new Button("Login");
        btnDeposit.setStyle("-fx-background-color: #3c8aff;-fx-border-width: 2px;-fx-text-fill: #ff1815 ");
        btnWithdraw.setStyle("-fx-background-color: #10ff4e; ");
        btnLogout.setStyle("-fx-border-color: #ff0000; -fx-border-width: 2px;-fx-text-fill: #ff1815");
        btnLogout.setTranslateX(340);
        btnWithdraw.setTranslateX(10);

        btnLogin.setOnAction(e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);
            field.clear();

            if(cashMachine.toString() != "Try account 1000 or 2000 and click submit.") {
                flowpane.getChildren().add(btnDeposit);
                flowpane.getChildren().add(btnWithdraw);
                flowpane.getChildren().add(btnLogout);
                flowpane.getChildren().removeAll(btnLogin);
                areaInfo.setText(cashMachine.toString());
            } else {
                areaInfo.setText("Enter Valid Account ID and Click Login.");
            }

        });

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
            field.clear();

            areaInfo.setText("You have successfully logged out. \nHave a nice Day!");
            flowpane.getChildren().removeAll(btnDeposit,btnWithdraw,btnLogout);
            vbox.getChildren().removeAll(field);
        });


        flowpane.getChildren().add(btnLogin);

        vbox.getChildren().addAll(field, flowpane, areaInfo);
        return vbox;
    }

    private Parent loginScene()
    {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label acctLabel = new Label("Account Number: ");
        GridPane.setConstraints(acctLabel, 0, 0);
        TextField acctInput = new TextField();
        GridPane.setConstraints(acctInput, 1, 0);

        Label pinLabel = new Label("PIN: ");
        GridPane.setConstraints(pinLabel, 0, 1);
        TextField pinInput = new TextField();
        GridPane.setConstraints(pinInput, 1, 1);

        Button btnLogin = new Button("Log In");
        GridPane.setConstraints(btnLogin, 1, 2);

        btnLogin.setOnAction(e ->
        {
            int id = Integer.parseInt(acctInput.getText());
            cashMachine.login(id);
            field.clear();

            if(cashMachine.toString() != "Try account 1000 or 2000 and click submit.") {
                window.setScene(new Scene(userScene()));
            }
        });

        grid.getChildren().addAll(acctLabel, acctInput, pinLabel, pinInput, btnLogin);

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