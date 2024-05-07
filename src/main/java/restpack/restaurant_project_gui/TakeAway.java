package restpack.restaurant_project_gui;

import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class TakeAway {
    Scene homeScene,scene;
    Home home = new Home();
    StackPane lay = new StackPane();

    public Scene createScene (Stage window){
        Button back = new Button("Back");
        homeScene = home.createScene(window);
        back.setOnAction(e ->{
            window.setScene(homeScene);
        } );
        lay.getChildren().addAll(back);
        scene =new Scene(lay) ;
        scene.getStylesheets().add(getClass().getResource("takeaway.css").toExternalForm());
        return scene;
    }
}
