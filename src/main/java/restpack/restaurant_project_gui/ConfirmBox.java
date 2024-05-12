package restpack.restaurant_project_gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
     boolean answer = false ;
    public boolean display(String title , String msg  ) {
        Stage window = new Stage () ;
        window.initModality(Modality.APPLICATION_MODAL);
        Image icon = new Image(getClass().getResourceAsStream("iconR .png"));
        window.getIcons().add(icon);
        window.setTitle(title);
        window.setMinWidth(400);

        Label label = new Label();
        label.setText(msg);

        Button yesButton = new Button("YES");
        Button noButton = new Button("NO");

        yesButton.setOnAction(e -> {
            answer =true; window.close();
        } );
        noButton.setOnAction(e -> {
            answer = false; window.close();
        } );


        yesButton.setId("yesButton");
        VBox layout = new VBox() ;
        HBox yesORno = new HBox();
        yesORno.setId("hbox");
        layout.setId("vbox");
        yesORno.getChildren().addAll(yesButton,noButton) ;
        yesORno.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,yesORno);
        layout.setAlignment(Pos.CENTER);
        //layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("ConfirmBox.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
        return answer ;
    }
}