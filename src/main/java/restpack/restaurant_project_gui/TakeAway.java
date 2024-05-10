package restpack.restaurant_project_gui;

import MenuPack.Food;
import MenuPack.Menu;
import MenuPack.MenuItem;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import restLogic.Order;
import restLogic.OrderItem;
import restLogic.Restaurant;
import restLogic.Table;

import java.util.ArrayList;
import java.util.List;

public class TakeAway {
    Scene scene, dineInScene;
    Button back, orderBut, receipt;
    //    Label totalAmount ;
    Order takeAwayOrder;
    HBox layout = new HBox();
    VBox col_l , col_r ;
    GridPane orderedGrid, menuGrid;

    public Scene createScene(Stage window, Restaurant asuResto) {
        takeAwayOrder = asuResto.getTakeaway();
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
        orderBut.setOnAction(e -> {
            System.out.println("order are pressed = " + takeAwayOrder.getBill());
            ConfirmBox checkOrdering = new ConfirmBox();
            Boolean chck = checkOrdering.display("Reciept Request" , "Are You Sure want to get Receipt and t7asb");
            if (chck){
                //TODO: decrease stock Items
                asuResto.setAvailableCash(asuResto.getAvailableCash()+takeAwayOrder.getBill());
                takeAwayOrder.clearOrder();
                update();
            }
        });
        receipt.setOnAction(e -> {
            System.out.println("receipt are pressed ");
        });

        menuGrid = menuItemsViewer(arr, takeAwayOrder);
        orderedGrid = orderedItemsViewer(takeAwayOrder.getOrderItemList(), takeAwayOrder);

        col_l.getChildren().addAll(back, menuGrid);
        col_r.getChildren().addAll(orderedGrid, orderBut);
        layout.getChildren().addAll(col_l, col_r);
        layout.setSpacing(100);
//        layout.setAlignment(Pos.center);
        scene = new Scene(layout);
        return scene;
    }

    GridPane menuItemsViewer(List<MenuItem> items, Order takeAwayOrder) {
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(2);
        grid.setPadding(new Insets(15, 15, 15, 15));
        //TODO: Print the title of each section
        Label titleSection = new Label("Drinks"); // for test only it will be automated
        grid.setConstraints(titleSection, 0, 0);
        grid.getChildren().addAll(titleSection);
        for (int j = 0; j < items.size(); j++) {
            Label labelName = new Label("     - " + items.get(j).getName());
            Button plus = new Button("+"),
                    minus = new Button("-");
            int finalJ = j;
            plus.setOnAction(e -> {
                // table.addItemInOrder();
                System.out.println("plus are pressed " + Integer.toString(finalJ));
                takeAwayOrder.addItem(items.get(finalJ));
                update();
            });
            minus.setOnAction(e -> {
                // table.removeItemInOrder(); TODO:
                System.out.println("minus are pressed " + Integer.toString(finalJ));
                takeAwayOrder.removeItem(items.get(finalJ));
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

    GridPane orderedItemsViewer(List<OrderItem> items, Order takeAwayOrder) {
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(2);
        grid.setPadding(new Insets(15, 15, 15, 15));
        Label titleSection = new Label("Total Invoice"); // for test only it will be automated
        grid.setConstraints(titleSection, 0, 0);
        grid.getChildren().addAll(titleSection);
        for (int j = 0; j < items.size(); j++) {
            Label labelName = new Label("     - " + items.get(j).getName());
            Label labelQuantity = new Label(" x" + items.get(j).getQuantity());

            Label labelPrice = new Label(Double.toString(items.get(j).getPrice()));
            grid.setConstraints(labelName, 0, j + 1);
            grid.setConstraints(labelQuantity, 2, j + 1);
            grid.setConstraints(labelPrice, 12, j + 1);
            grid.getChildren().addAll(labelName, labelQuantity, labelPrice);
        }
        Label totalAmountLabel = new Label("Total Amount : ");

        Label totalPriceLabel = new Label(Double.toString(takeAwayOrder.getBill()));
        grid.setConstraints(totalAmountLabel, 0, items.size() + 1);
        grid.setConstraints(totalPriceLabel, 12, items.size() + 1);
        grid.getChildren().addAll(totalAmountLabel, totalPriceLabel);
        return grid;
    }

    void update() {
        orderedGrid = orderedItemsViewer(takeAwayOrder.getOrderItemList(), takeAwayOrder);
        layout.getChildren().remove(col_r);
        col_r = new VBox();
        col_r.getChildren().addAll(orderedGrid,orderBut);
        layout.getChildren().add(col_r );
    }
}
