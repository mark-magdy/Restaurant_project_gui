package restpack.restaurant_project_gui;

import MenuPack.Appetizers;
import MenuPack.Drinks;
import MenuPack.Food;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import restLogic.Restaurant;

public class SettingsGui {
    Scene homeScene,scene;
    Home home = new Home();
    Button Foods =new Button("FOODS");
    Button Drinks =new Button("Drinks");
    Button Desserts =new Button("Desserts");
    Button Appetizer=new Button("Appetizers");

    Button back=new Button();

    BorderPane borderPane = new BorderPane();
    public Scene createScene (Stage window , Restaurant asuResto){

        Appetizers_Gui app_o=new Appetizers_Gui();
        Desserts_gui  dess_o=new Desserts_gui();

        Appetizer.setOnAction(e -> {
            Scene tmp = app_o.createScene(window,asuResto);
            window.setScene(tmp);});
        Desserts.setOnAction(e -> {
            Scene tmp =dess_o.createScene(window,asuResto);
            window.setScene(tmp);});


        Button back = new Button("Back");
        back.getStyleClass().add("button_back");
        homeScene = home.createScene(window,asuResto);


        back.setOnAction(e ->{
            window.setScene(homeScene);
        } );







        GridPane settings =new GridPane ();

        settings.setVgap(50);
        settings.setHgap(50);
        settings.setPadding(new Insets(50,50,130,220));
        settings.setConstraints(Foods,0,0);
        settings.setConstraints(Drinks,1,0);
        settings.setConstraints(Desserts,0,1);
        settings.setConstraints(Appetizer,1,1);
        settings.getChildren().addAll(Foods,Drinks,Desserts,Appetizer);


        borderPane.setTop(back);
        borderPane.setCenter(settings);
        BorderPane.setAlignment(back,Pos.TOP_LEFT);
        BorderPane.setAlignment(settings,Pos.CENTER);
        scene =new Scene(borderPane) ;
        scene.getStylesheets().add(getClass().getResource("Settings.css").toExternalForm());
        return scene;
        }
    }
