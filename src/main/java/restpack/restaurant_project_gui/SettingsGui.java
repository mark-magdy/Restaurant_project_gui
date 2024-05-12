package restpack.restaurant_project_gui;

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
    Button showTotalInputBtn =new Button();


    VBox borderPane = new VBox();
    public Scene createScene (Stage window , Restaurant asuResto){

        Appetizers_Gui app_o=new Appetizers_Gui();
        Desserts_gui  dess_o=new Desserts_gui();
        ShowTotalInput showTotalInputObj = new ShowTotalInput();

     /*   ShowTotalInput.setOnAction(e->
                );*/
        //ShowTotalInput.getStyleClass().add("button_ShowInput");

        Appetizer.setOnAction(e -> {
            Scene tmp = app_o.createScene(window,asuResto);
            window.setScene(tmp);});
        Desserts.setOnAction(e -> {
            Scene tmp =dess_o.createScene(window,asuResto);
            window.setScene(tmp);});





        Button back = new Button("Back");
        back.setId("backBtn");
        back.getStyleClass().add("button_back");
        homeScene = home.createScene(window,asuResto);


        back.setOnAction(e ->{
            window.setScene(homeScene);
        } );


        HBox h=new HBox();
        showTotalInputBtn.setAlignment(Pos.CENTER);
        h.getChildren().addAll(back, showTotalInputBtn);
        h.setPadding(new Insets(10,10,10,10));
        h.setSpacing(180);
        showTotalInputBtn.setText("Stats");
        showTotalInputBtn.setOnAction(e -> {
            Scene tmp = showTotalInputObj.createScene(window,asuResto);
            window.setScene(tmp);
        });


        GridPane settings =new GridPane ();

        settings.setVgap(50);
        settings.setHgap(50);
        settings.setPadding(new Insets(50,50,130,220));
        settings.setConstraints(Foods,0,0);
        settings.setConstraints(Drinks,1,0);
        settings.setConstraints(Desserts,0,1);
        settings.setConstraints(Appetizer,1,1);
        settings.getChildren().addAll(Foods,Drinks,Desserts,Appetizer);


        borderPane.getChildren().addAll(h,settings);

        scene =new Scene(borderPane) ;
        scene.getStylesheets().add(getClass().getResource("Settings.css").toExternalForm());
        return scene;
        }
    }
