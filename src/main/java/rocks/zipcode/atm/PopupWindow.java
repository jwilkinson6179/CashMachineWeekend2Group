// Created with tutorial by Bucky Roberts at
// https://www.youtube.com/watch?v=SpL3EToqaXA

package rocks.zipcode.atm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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

        Button closeButton = new Button("I understand");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene popup = new Scene(layout);
        window.setScene(popup);
        window.showAndWait();
    }
}
