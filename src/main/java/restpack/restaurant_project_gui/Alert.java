package restpack.restaurant_project_gui;

import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Alert {
    public void display(String title , String msg  ) {
        Stage window = new Stage () ;
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(500);
        Image icon = new Image(getClass().getResourceAsStream("iconR .png"));
        window.getIcons().add(icon);

        // label Alert msg
        Label label = new Label();
        label.setText(msg);
        GridPane.setConstraints(label , 0 , 0);
        GridPane.setHalignment(label, HPos.CENTER); // Horizontally center the label in its cell
        GridPane.setValignment(label, VPos.CENTER); // Vertically center the label in its cell

        //close button
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());
        GridPane.setConstraints(closeButton , 0 , 1);
        GridPane.setHalignment(closeButton, HPos.CENTER); // Horizontally center the label in its cell
        GridPane.setValignment(closeButton, VPos.CENTER); // Vertically center the label in its cell

        //layout
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        //scene
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
    }
}
