package restpack.restaurant_project_gui;

import MenuPack.Menu;
import MenuPack.MenuItem;
import MenuPack.MenuSection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import restLogic.*;

public class TableGui {
    Scene scene , dineInScene;
    Button back;

    HBox layout = new HBox();
    VBox col_l= new VBox() ,  col_r = new VBox();

    public Scene createScene(Stage window, Restaurant asuResto, int tableId) {
        Table table = asuResto.getTables()[tableId];
        Menu menu = asuResto.getMainMenu();
        back = new Button("Back");
    DineIn dineIn = new DineIn();

//        dineInScene = ;
        back.setOnAction(e ->{
            window.setScene(dineIn.createScene(window,asuResto));
        } );
        /////////////// for test only ///////////////////////////////////
        Label titleSection = new Label("Drinks     ");
        MenuItem item = new MenuItem("coka       ", 12.3, 1);
        MenuItem item1 = new MenuItem("stella     ", 40, 1);
        MenuItem item2 = new MenuItem("cockaine   ", 100, 1);
        MenuItem[] arr = new MenuItem[3];
        arr[0] = item;
        arr[1] = item1;
        arr[2] = item2;
        //////////////////////////////////////////////////////////////////
        Button order = new Button("order"),
                receipt = new Button("receipt");
        order.setOnAction(e -> {
            System.out.println("order are pressed ");
        });
        receipt.setOnAction(e -> {
            System.out.println("receipt are pressed ");
        });

        GridPane menuGrid = itemsViewer(arr) ;



        col_l.getChildren().addAll(back,menuGrid);
        layout.getChildren().addAll(col_l , col_r );
//        layout.setAlignment(Pos.center);
        scene = new Scene(layout);
        return scene;
    }

    GridPane itemsViewer(MenuItem[] items) {
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(2);
        grid.setPadding(new Insets(15, 15, 15, 15));
        //TODO: Print the title of each section
        Label titleSection = new Label("Drinks"); // for test only it will be automated
        grid.setConstraints(titleSection, 0, 0);
        grid.getChildren().addAll(titleSection);
        for (int j = 0 ; j < items.length ; j++ ) {
            Label labelName = new Label("   "+ items[j].getName());
            Button plus = new Button("+"),
                    minus = new Button("-");
            int finalJ = j;
            plus.setOnAction(e -> {
                // table.addItemInOrder();
                System.out.println("plus are pressed "+ Integer.toString(finalJ));
            });
            minus.setOnAction(e -> {
                // table.removeItemInOrder(); TODO:
                System.out.println("minus are pressed "+Integer.toString(finalJ));
            });
            Label labelPrice = new Label(Double.toString(items[j].getPrice()));

            grid.setConstraints(labelName, 0, j+1);
            grid.setConstraints(minus, 5, j+1);
            grid.setConstraints(plus, 8, j+1);
            grid.setConstraints(labelPrice, 12, j+1);
            grid.getChildren().addAll(labelName, minus, plus, labelPrice);
        }
        return grid;
    }
}
