// Created with tutorial by Bucky Roberts at
// https://www.youtube.com/watch?v=SpL3EToqaXA

package rocks.zipcode.atm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopupWindow {
    public static void Popup(String title, String warning)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(200);

        Label label = new Label();
        label.setText(warning);
        label.setTextFill(Color.web("red"));
        label.setStyle(
                "h1 { font-family: \"Arial Rounded MT Bold\", \"Helvetica Rounded\", Arial, sans-serif; font-size: 18px; font-style: normal; font-variant: normal; font-weight: bold; line-height: 36px; } h3 { font-family: \"Arial Rounded MT Bold\", \"Helvetica Rounded\", Arial, sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: bold; line-height: 15px; } p { font-family: \"Arial Rounded MT Bold\", \"Helvetica Rounded\", Arial, sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 20px; } blockquote { font-family: \"Arial Rounded MT Bold\", \"Helvetica Rounded\", Arial, sans-serif; font-size: 21px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 30px; } pre { font-family: \"Arial Rounded MT Bold\", \"Helvetica Rounded\", Arial, sans-serif; font-size: 13px; font-style: normal; font-variant: normal; font-weight: bold; line-height: 26px; }"

        );

        Button closeButton = new Button("I understand");
        closeButton.setOnAction(e -> window.close());
        closeButton.setStyle("    -fx-background-color: \n" +
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

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color:#cbf3f5");

        Scene popup = new Scene(layout);
        window.setScene(popup);
        window.showAndWait();
    }
}
