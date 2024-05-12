package restpack.restaurant_project_gui;

import MenuPack.*;
import MenuPack.Menu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import restLogic.*;

import java.util.List;

public class TableGui extends OrderView {
    Table table;

    public TableGui() {
        firstBtnInit();
        secondBtnInit();
    }

    public Scene createScene(Stage window, Restaurant asuResto, int tableId) {
        table = asuResto.getTables().get(tableId);
        orderToView = table.getOrder();

        col_l = new VBox();
        col_r = new VBox();
        System.out.println("table refrence is " + asuResto);
        Menu menu = asuResto.getMainMenu();
        back = new Button("Back");
        DineIn dineIn = new DineIn();

        back.setOnAction(e -> {
            window.setScene(dineIn.createScene(window, asuResto));
        });
        firstBtn.getStyleClass().add("button-order");
        secondBtn.getStyleClass().add("button-receipt");

        firstBtn.setOnAction(e -> {
            System.out.println("order are pressed = " + table.getBill());
            ConfirmBox checkOrdering = new ConfirmBox();
            Boolean chck = checkOrdering.display("Reciept Request", "Are You Sure want to get Receipt and t7asb");
            if (chck) {
                asuResto.setAvailableCash(asuResto.getAvailableCash() + table.getBill());
                table.clearTable();
                update();
            }
        });

        List<MenuSection> arr = menu.getSections();
        menuGrid = menuItemsViewer(arr, table.getOrder());
        orderedGrid = orderedItemsViewer(table.getOrderItemList(), table.getOrder());

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

    @Override
    public void firstBtnInit() {
        firstBtn.setText("Reciept");
    }

    @Override
    public void secondBtnInit() {
        secondBtn.setText("Order");
        secondBtn.setOnAction(e -> {
            alert.display("Completed Succefully ", "the order is getting prepared");
            System.out.println("receipt are pressed ");

        });
    }

    @Override
    public void setOrderToView() {
        orderToView = asuResto.getTakeaway();
    }
}