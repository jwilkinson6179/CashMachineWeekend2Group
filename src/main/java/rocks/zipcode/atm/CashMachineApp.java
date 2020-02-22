package rocks.zipcode.atm;

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

    private Stage window;
    Scene loginScene;
    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());


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

    @Override
    public void start(Stage stage) throws Exception {

            stage.setScene(new Scene(userScene()));
            stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}