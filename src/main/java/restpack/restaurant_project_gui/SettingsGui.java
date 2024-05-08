package restpack.restaurant_project_gui;

import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import restLogic.Restaurant;

public class SettingsGui {
    Scene homeScene,scene;
    Home home = new Home();
    StackPane lay = new StackPane();

    public Scene createScene (Stage window , Restaurant asuResto){
        Button back = new Button("Back");
        homeScene = home.createScene(window,asuResto);
        back.setOnAction(e ->{
            window.setScene(homeScene);
        } );
        lay.getChildren().addAll(back);
        scene =new Scene(lay) ;
        return scene;
    }
}
