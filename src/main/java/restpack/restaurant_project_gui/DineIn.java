package restpack.restaurant_project_gui;

import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class DineIn {
    Button back , table;
    Scene homeScene , scene;
    Home home = new Home();
    GridPane grid = new GridPane() ;
    Button [] buttons = new Button[9] ;
    BorderPane borderPane = new BorderPane();

    public  Scene createScene (Stage window){
        // back button to return the prev scene
        back = new Button("Back");
        homeScene = home.createScene(window);
        back.setOnAction(e ->{
            window.setScene(homeScene);
        } );
        for (int i = 0 ; i <= 2 ; i++) {
            for (int j = 1 ; j<=3 ;j++){
                buttons[i*3+j-1] = new Button("Table"+(i*3+j));
                buttons[i*3+j-1].setId("buttonTable");
                grid.add(buttons[i*3+j-1], j+1, i+1);
            }
        }

        grid.setVgap(30);grid.setHgap(75);
        borderPane.setTop(back);
        borderPane.setLeft(grid);
        BorderPane.setAlignment(back,Pos.TOP_LEFT);
//        grid.setAlignment(Pos.CENTER);
        scene =new Scene(borderPane) ;
        back.setId("backBtn");
        scene.getStylesheets().add(getClass().getResource("DineIn.css").toExternalForm());
        return scene;
    }
}