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

    private Parent userScene() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);

        TextArea areaInfo = new TextArea();

        // TODO: This is to login
        Button btnSubmit = new Button("Set Account ID");
        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);

            areaInfo.setText(cashMachine.toString());
        });

        // TODO: Alert user to enter a value > 0 if failed
        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e -> {
            Float amount = Float.parseFloat(field.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });

        // TODO: Alert user that they were unable to withdraw due to insufficient balance on failure
        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            Float amount = Float.parseFloat(field.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
        });

        // TODO: Should be logout instead.  Perhaps draw a new scene for the "Splash" screen asking for a login & pin?
        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
        });

        FlowPane flowpane = new FlowPane();

        flowpane.getChildren().add(btnSubmit);
        flowpane.getChildren().add(btnDeposit);
        flowpane.getChildren().add(btnWithdraw);
        flowpane.getChildren().add(btnExit);
        vbox.getChildren().addAll(field, flowpane, areaInfo);
        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;



        stage.setScene(new Scene(userScene()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}