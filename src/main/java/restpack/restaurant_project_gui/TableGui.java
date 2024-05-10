package restpack.restaurant_project_gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import restLogic.*;

import java.util.ArrayList;
import java.util.List;

public class TableGui {
    Scene scene, dineInScene;
    Button back, orderBut, receipt;
//    Label totalAmount ;
    Table table;
    HBox layout = new HBox();
    VBox col_l , col_r ;
    GridPane orderedGrid, menuGrid;
    HBox btns = new HBox();

    public Scene createScene(Stage window, Restaurant asuResto, int tableId) {
        table = asuResto.getTables().get(tableId);
        col_l = new VBox(); col_r = new VBox();
        System.out.println("table refrence is " + asuResto);
        Menu menu = asuResto.getMainMenu();   // TODO: to be integrated with menuPack
        back = new Button("Back");
        DineIn dineIn = new DineIn();

//        dineInScene = ;
        back.setOnAction(e -> {
            window.setScene(dineIn.createScene(window, asuResto));
        });
        ///////////// for test only ///////////////////////////////////
        Label titleSection = new Label("Drinks     ");
        MenuItem item = new Food("coka       ", 12.3, 1);
        MenuItem item1 = new Food("stella     ", 40, 1);
        MenuItem item2 = new Food("cockaine   ", 100, 1);
        List<MenuItem> arr = new ArrayList<>();
        arr.add(item);
        arr.add(item1);
        arr.add(item2);
        ////////////////////////////////////////////////////////////////
        orderBut = new Button("order");
        receipt = new Button("receipt");
        orderBut.getStyleClass().add("button-order");
        receipt.getStyleClass().add("button-receipt");

        orderBut.setOnAction(e -> {
            System.out.println("order are pressed = " + table.getBill());
            ConfirmBox checkOrdering = new ConfirmBox();
            Boolean chck = checkOrdering.display("Reciept Request" , "Are You Sure want to get Receipt and t7asb");
            if (chck){
                //TODO: decrease stock Items
                asuResto.setAvailableCash(asuResto.getAvailableCash()+table.getBill());
                table.clearTable();
                update();
            }
        });
        receipt.setOnAction(e -> {
            System.out.println("receipt are pressed ");
        });

        menuGrid = menuItemsViewer(arr, table);
        orderedGrid = orderedItemsViewer(table.getOrderItemList(), table);

        col_l.getChildren().addAll(back, menuGrid);

        btns.getChildren().addAll(orderBut,receipt);
        btns.setSpacing(20);
        btns.setAlignment(Pos.CENTER);
        col_r.getChildren().addAll(orderedGrid, btns);
        layout.getChildren().addAll(col_l, col_r);
        layout.setSpacing(100);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout);

        scene.getStylesheets().add(getClass().getResource("OrderView.css").toExternalForm());

        return scene;
    }

    GridPane menuItemsViewer(List<MenuItem> items, Table table) {
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(2);
        grid.setPadding(new Insets(15, 15, 15, 15));
        //TODO: Print the title of each section
        Label titleSection = new Label("Drinks"); // for test only it will be automated
        titleSection.getStyleClass().add("label-title");

        grid.setConstraints(titleSection, 0, 0);
        grid.getChildren().addAll(titleSection);
        for (int j = 0; j < items.size(); j++) {
            Label labelName = new Label("     - " + items.get(j).getName());
            Button plus = new Button("+"),
                    minus = new Button("-");
            plus.getStyleClass().add("button-add");
            minus.getStyleClass().add("button-remove");
            int finalJ = j;
            plus.setOnAction(e -> {
                // table.addItemInOrder();
                System.out.println("plus are pressed " + Integer.toString(finalJ));
                table.addItemInOrder(items.get(finalJ));
                update();
            });
            minus.setOnAction(e -> {
                // table.removeItemInOrder(); TODO:
                System.out.println("minus are pressed " + Integer.toString(finalJ));
                table.removeItemInOrder(items.get(finalJ));
                update();
            });
            Label labelPrice = new Label(Double.toString(items.get(j).getPrice()));

            grid.setConstraints(labelName, 0, j + 1);
            grid.setConstraints(minus, 5, j + 1);
            grid.setConstraints(plus, 8, j + 1);
            grid.setConstraints(labelPrice, 12, j + 1);
            grid.getChildren().addAll(labelName, minus, plus, labelPrice);
        }
        return grid;
    }

    GridPane orderedItemsViewer(List<OrderItem> items, Table table) {
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(2);
        grid.setPadding(new Insets(15, 15, 15, 15));
        Label titleSection = new Label("Total Invoice"); // for test only it will be automated
        grid.setConstraints(titleSection, 0, 0);
        grid.getChildren().addAll(titleSection);
        for (int j = 0; j < items.size(); j++) {
            Label labelName = new Label("     - " + items.get(j).getName());
            Label labelQuantity = new Label("x" + items.get(j).getQuantity());

            Label labelPrice = new Label(Double.toString(items.get(j).getPrice()));
            grid.setConstraints(labelName, 0, j + 1);
            grid.setConstraints(labelQuantity, 2, j + 1);
            grid.setConstraints(labelPrice, 12, j + 1);
            grid.getChildren().addAll(labelName, labelQuantity, labelPrice);
        }
        Label totalAmountLabel = new Label("Total Amount : ");

        Label totalPriceLabel = new Label(Double.toString(table.getBill()));
        grid.setConstraints(totalAmountLabel, 0, items.size() + 1);
        grid.setConstraints(totalPriceLabel, 12, items.size() + 1);
        grid.getChildren().addAll(totalAmountLabel, totalPriceLabel);

        titleSection.getStyleClass().add("label-title");
        totalAmountLabel.getStyleClass().add("label-title");

        return grid;
    }

    void update() {
        orderedGrid = orderedItemsViewer(table.getOrderItemList(), table);
        layout.getChildren().remove(col_r);
        col_r = new VBox();
        col_r.getChildren().addAll(orderedGrid, btns);        layout.getChildren().add(col_r );
    }
}
