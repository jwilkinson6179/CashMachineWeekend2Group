package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Signup
{
    Stage window;

    public Signup()
    {
        Stage window = new Stage();
        GridPane grid = new GridPane();
        Label topOfForm = new Label();
        Label nameForm = new Label();
        Label emailForm = new Label();
        Label invalidMessage = new Label();
        TextField nameField = new TextField();
        TextField emailField = new TextField();
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");
        grid.setPadding(new Insets(10, 100, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setStyle("-fx-background-color: linear-gradient(to top, #97befc, #d8e2f2);");
        window.setTitle("New Customer Sign-Up");
        window.setMinWidth(350);
        window.setMinHeight(300);
        final ToggleGroup group = new ToggleGroup();
        RadioButton basicOption = new RadioButton();
        basicOption.setText("Basic Account");
        RadioButton premiumOption = new RadioButton();
        basicOption.setToggleGroup(group);
        basicOption.setSelected(true);
        premiumOption.setText("Premium Account");
        premiumOption.setToggleGroup(group);

        submitButton.setStyle("    -fx-background-color: \n" +
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

        cancelButton.setStyle("    -fx-background-color: \n" +
                "         #c3c4c4," +
                "         linear-gradient(#d6d6d6 50%, white 100%)," +
                "         radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,2,3,0;\n" +
                "    -fx-text-fill: #654b00;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 14px;\n" +
                "    -fx-padding: 10 20 10 20;");

        nameForm.setText("Name: ");
        GridPane.setConstraints(nameForm, 0, 0);
        GridPane.setConstraints(nameField, 1, 0);
        emailForm.setText("E-mail: ");
        invalidMessage.setText("Invalid Information");
        invalidMessage.setTextFill(Color.web("red"));
        GridPane.setConstraints(emailForm, 0, 1);
        GridPane.setConstraints(emailField, 1, 1);
        GridPane.setConstraints(submitButton, 1, 2);
        GridPane.setConstraints(cancelButton, 1, 3);
        GridPane.setConstraints(basicOption, 3,0);
        GridPane.setConstraints(premiumOption,3, 1);
        GridPane.setConstraints(invalidMessage, 3, 2);
        cancelButton.setOnAction(e -> window.close());

        grid.setAlignment(Pos.CENTER);
        grid.getChildren().addAll(topOfForm, nameForm, emailForm, nameField, emailField, submitButton, cancelButton, basicOption, premiumOption);

        Scene submissionPage = new Scene(grid);
        window.setScene(submissionPage);
        window.show();
    }

}
