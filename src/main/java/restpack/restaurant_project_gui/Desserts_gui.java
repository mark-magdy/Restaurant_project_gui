package restpack.restaurant_project_gui;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import restLogic.Restaurant;

public class Desserts_gui {
    Scene Settrngs,scene;
    Home home = new Home();
    Button additem =new Button("AddItem");
    Button removeitem =new Button("RemoveItem");
    Button updatePrice =new Button("UpdatePrice");
    Button showTotalinput=new Button("ShowTotalInput");

    BorderPane borderPane = new BorderPane();
    public Scene createScene (Stage window , Restaurant asuResto){

       // UpdatePrice update=new UpdatePrice();
        Desserts_remove remove= new Desserts_remove();
        //ShowTotalInput show =new ShowTotalInput();
        Desserts_additem add =new Desserts_additem();

       /* updatePrice.setOnAction(e -> {
            Scene tmp = update.createScene(window,asuResto);
            window.setScene(tmp);
        });*/
        removeitem.setOnAction(e -> {
            Scene tmp = remove.createScene(window,asuResto);
            window.setScene(tmp);
        });
        additem.setOnAction(e -> {
            Scene tmp = add.createScene(window,asuResto);
            window.setScene(tmp);
        });
       /* showTotalinput.setOnAction(e -> {
            Scene tmp = show.createScene(window,asuResto);
            window.setScene(tmp);
        });*/


        Button back = new Button("Back");
        back.setId("backBtn");
        //back.getStyleClass().add("button_back");
        Settrngs = home.createScene(window,asuResto);
        back.setOnAction(e ->{
            window.setScene(Settrngs);
        } );







        GridPane settings =new GridPane ();

        settings.setVgap(50);
        settings.setHgap(50);
        settings.setPadding(new Insets(50,50,130,220));
        settings.setConstraints(additem,0,0);
        settings.setConstraints(removeitem,1,0);
        //settings.setConstraints(updatePrice,0,1);
        // settings.setConstraints(showTotalinput,1,1);
        settings.getChildren().addAll(additem,removeitem);


        borderPane.setTop(back);
        borderPane.setCenter(settings);
        BorderPane.setAlignment(back,Pos.TOP_LEFT);
        BorderPane.setAlignment(settings,Pos.CENTER);
        scene =new Scene(borderPane) ;
        scene.getStylesheets().add(getClass().getResource("Settings.css").toExternalForm());
        return scene;
    }
}
