package restpack.restaurant_project_gui;

import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class DineIn {
    Scene homeScene;
    public  Scene createScene (Stage window){
        Button back = new Button("Back");
        Scene scene ;
        Home home = new Home();
        homeScene = home.createScene(window);
        StackPane lay = new StackPane();
        back.setOnAction(e ->{
            window.setScene(homeScene);
            window.close();
            window.show ();
        } );
        lay.getChildren().addAll(back);
        scene =new Scene(lay) ;
        return scene;
    }
}