package restpack.restaurant_project_gui;

import MenuPack.Menu;
import MenuPack.MenuItem;
import MenuPack.MenuSection;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import restLogic.Order;
import restLogic.OrderItem;
import restLogic.Restaurant;

import java.util.List;

public abstract class OrderView  {
    Scene scene, dineInScene;
    Button back, firstBtn= new Button(), secondBtn=new Button();
    //    Label totalAmount ;
    Order orderToView= new Order();
    HBox layout = new HBox();
    VBox col_l , col_r ;
    GridPane orderedGrid, menuGrid;
    HBox btns = new HBox();
    Alert alert =new Alert();
    Restaurant asuResto;

    abstract public void firstBtnInit ();
    abstract public void secondBtnInit ();
    abstract public void setOrderToView();
    public Scene createScene(Stage window, Restaurant asuRest) {
        asuResto=asuRest ;
//        orderToView = asuResto.getTakeaway();
        col_l = new VBox(); col_r = new VBox();
        System.out.println("table refrence is " + asuResto);
        Menu menu = asuResto.getMainMenu();
        back = new Button("Back");
        Home home = new Home();

        back.setOnAction(e -> {
            window.setScene(home.createScene(window, asuResto));
        });

        firstBtn.getStyleClass().add("button-order");
        secondBtn.getStyleClass().add("button-receipt");

        List<MenuSection> arr = menu.getSections();
        menuGrid = menuItemsViewer(arr, orderToView);
        orderedGrid = orderedItemsViewer(orderToView.getOrderItemList(), orderToView);

        col_l.getChildren().addAll(back, menuGrid);

        btns.getChildren().addAll(firstBtn, secondBtn);
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
    GridPane menuItemsViewer(List<MenuSection> sections, Order takeAwayOrder) {
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(2);
        grid.setPadding(new Insets(15, 15, 15, 15));
        int lstRowIndex = 0 ;
        for (int i = 0 ; i < sections.size();i++){
            List<MenuItem> items= sections.get(i).getMenuItems();
            Label titleSection = new Label(sections.get(i).getName()); // for test only it will be automated
            titleSection.getStyleClass().add("label-title");

            grid.setConstraints(titleSection, 0, lstRowIndex++);
            grid.getChildren().addAll(titleSection);
            for (int j = 0; j < items.size(); j++ , lstRowIndex++) {
                Label labelName = new Label("     - " + items.get(j).getName());
                Button plus = new Button("+"),
                        minus = new Button("-");
                plus.getStyleClass().add("button-add");
                minus.getStyleClass().add("button-remove");
                int finalJ = j;
                plus.setOnAction(e -> {
                    System.out.println("plus are pressed " + Integer.toString(finalJ));
                    takeAwayOrder.addItem(items.get(finalJ));
                    update();
                });
                minus.setOnAction(e -> {
                    System.out.println("minus are pressed " + Integer.toString(finalJ));
                    takeAwayOrder.removeItem(items.get(finalJ));
                    update();
                });
                Label labelPrice = new Label(Double.toString(items.get(j).getPrice()));

                grid.setConstraints(labelName, 0, lstRowIndex);
                grid.setConstraints(minus, 5, lstRowIndex);
                grid.setConstraints(plus, 8, lstRowIndex);
                grid.setConstraints(labelPrice, 12, lstRowIndex);
                grid.getChildren().addAll(labelName, minus, plus, labelPrice);
            }
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
            Label labelQuantity = new Label("x" + items.get(j).getQuantity());

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

        titleSection.getStyleClass().add("label-title");
        totalAmountLabel.getStyleClass().add("label-title");

        return grid;
    }

    void update() {
        orderedGrid = orderedItemsViewer(orderToView.getOrderItemList(), orderToView);
        layout.getChildren().remove(col_r);
        col_r = new VBox();
        col_r.getChildren().addAll(orderedGrid, btns);
        layout.getChildren().add(col_r);
    }

}
