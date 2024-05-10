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
import restLogic.Restaurant;
import restLogic.Table;

public class DineIn {
    Button back ;
    Label label = new Label("Dine-In");
    Scene homeScene , scene;
    Home home = new Home();
    GridPane grid = new GridPane() ;
    Button [] buttons = new Button[9] ;
    VBox borderPane = new VBox();
    TableGui tableGui = new TableGui();

    public  Scene createScene (Stage window , Restaurant asuResto){
        // back button to return the prev scene
        back = new Button("Back");
        homeScene = home.createScene(window,asuResto);
        back.setOnAction(e ->{
            window.setScene(homeScene);
        } );
        for (int i = 0 ; i <= 2 ; i++) {
            for (int j = 1 ; j<=3 ;j++){
                final int tableID = i*3+j-1 ;
                buttons[tableID] = new Button("Table"+(tableID));
                if (asuResto.getTables().get(tableID).getState()== Table.State.HAVE_ORDER) {
                    buttons[tableID].setId("buttonOrderedTable");

                }else if (asuResto.getTables().get(tableID).getState() == Table.State.EMPTY){
                    buttons[tableID].setId("buttonTable");
                }else {
                    buttons[tableID].setId("buttonTable");
                }
                grid.add(buttons[tableID], j-1, i);

                buttons[i*3+j-1].setOnAction(e->{
                    window.setScene(tableGui.createScene(window, asuResto,tableID));
                });

            }
        }

        grid.setVgap(30);grid.setHgap(75);
        grid.setAlignment(Pos.CENTER);
        borderPane.getChildren().addAll(back,grid);;
//        grid.setAlignment(Pos.CENTER);
        scene =new Scene(borderPane) ;
        back.setId("backBtn");
        scene.getStylesheets().add(getClass().getResource("DineIn.css").toExternalForm());
        return scene;
    }
}