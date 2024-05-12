package restpack.restaurant_project_gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import restLogic.Restaurant;

public class Showinput {
    Scene Settings,scene;
    SettingsGui setgui=new SettingsGui();

    public Scene createScene (Stage window , Restaurant asuResto){


        Button back = new Button("Back");
        back.getStyleClass().add("button_back");
        Settings = setgui.createScene(window,asuResto);
        back.setOnAction(e ->{
            window.setScene(Settings);
        } );
        scene =new Scene(back) ;
        scene.getStylesheets().add(getClass().getResource("Settings.css").toExternalForm());
        return scene;
}}
