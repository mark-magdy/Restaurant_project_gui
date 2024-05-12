//package restpack.restaurant_project_gui;
//
//import MenuPack.Food;
//import MenuPack.Menu;
//import MenuPack.MenuItem;
//import MenuPack.MenuSection;
//import javafx.geometry.*;
//import javafx.scene.control.Label;
//import javafx.scene.*;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//import javafx.scene.control.Button;
//import restLogic.Order;
//import restLogic.OrderItem;
//import restLogic.Restaurant;
//import restLogic.Table;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TakeAway {
//    Scene scene, dineInScene;
//    Button back, orderBut, VISA;
//    //    Label totalAmount ;
//    Order takeAwayOrder;
//    HBox layout = new HBox();
//    VBox col_l , col_r ;
//    GridPane orderedGrid, menuGrid;
//    HBox btns = new HBox();
//    Alert alert =new Alert();
//
//    public Scene createScene(Stage window, Restaurant asuResto) {
//        takeAwayOrder = asuResto.getTakeaway();
//        col_l = new VBox(); col_r = new VBox();
//        System.out.println("table refrence is " + asuResto);
//        Menu menu = asuResto.getMainMenu();
//        back = new Button("Back");
//        Home home = new Home();
//
////        dineInScene = ;
//        back.setOnAction(e -> {
//            window.setScene(home.createScene(window, asuResto));
//        });
//
//
//
//        orderBut = new Button("Cash");
//        VISA = new Button("VISA");
//        orderBut.getStyleClass().add("button-order");
//        VISA.getStyleClass().add("button-receipt");
//        orderBut.setOnAction(e -> {
//            System.out.println("order are pressed = " + takeAwayOrder.getBill());
//            ConfirmBox checkOrdering = new ConfirmBox();
//            Boolean chck = checkOrdering.display("Reciept Request" , "Are You Sure want to get Receipt and t7asb");
//            if (chck){
//                //TODO: decrease stock Items
//                asuResto.setAvailableCash(asuResto.getAvailableCash()+takeAwayOrder.getBill());
//                takeAwayOrder.clearOrder();
//                update();
//            }
//        });
//        VISA.setOnAction(e -> {
//            alert.display("Uner Condtruction" , "It's not working yet");
//            System.out.println("receipt are pressed ");
//
//        });
//
//        List<MenuSection> arr = menu.getSections();
//        menuGrid = menuItemsViewer(arr, takeAwayOrder);
//        orderedGrid = orderedItemsViewer(takeAwayOrder.getOrderItemList(), takeAwayOrder);
//
//        col_l.getChildren().addAll(back, menuGrid);
//
//        btns.getChildren().addAll(orderBut, VISA);
//        btns.setSpacing(20);
//        btns.setAlignment(Pos.CENTER);
//        col_r.getChildren().addAll(orderedGrid, btns);
//        layout.getChildren().addAll(col_l, col_r);
//        layout.setSpacing(100);
//        layout.setAlignment(Pos.CENTER);
//        scene = new Scene(layout);
//
//        scene.getStylesheets().add(getClass().getResource("OrderView.css").toExternalForm());
//
//        return scene;
//    }
//    GridPane menuItemsViewer(List<MenuSection> sections, Order takeAwayOrder) {
//        GridPane grid = new GridPane();
//        grid.setHgap(8);
//        grid.setVgap(2);
//        grid.setPadding(new Insets(15, 15, 15, 15));
//        int lstRowIndex = 0 ;
//        for (int i = 0 ; i < sections.size();i++){
//            List<MenuItem> items= sections.get(i).getMenuItems();
//            Label titleSection = new Label(sections.get(i).getName()); // for test only it will be automated
//            titleSection.getStyleClass().add("label-title");
//
//            grid.setConstraints(titleSection, 0, lstRowIndex++);
//            grid.getChildren().addAll(titleSection);
//            for (int j = 0; j < items.size(); j++ , lstRowIndex++) {
//                Label labelName = new Label("     - " + items.get(j).getName());
//                Button plus = new Button("+"),
//                        minus = new Button("-");
//                plus.getStyleClass().add("button-add");
//                minus.getStyleClass().add("button-remove");
//                int finalJ = j;
//                plus.setOnAction(e -> {
//                    System.out.println("plus are pressed " + Integer.toString(finalJ));
//                    takeAwayOrder.addItem(items.get(finalJ));
//                    update();
//                });
//                minus.setOnAction(e -> {
//                    System.out.println("minus are pressed " + Integer.toString(finalJ));
//                    takeAwayOrder.removeItem(items.get(finalJ));
//                    update();
//                });
//                Label labelPrice = new Label(Double.toString(items.get(j).getPrice()));
//
//                grid.setConstraints(labelName, 0, lstRowIndex);
//                grid.setConstraints(minus, 5, lstRowIndex);
//                grid.setConstraints(plus, 8, lstRowIndex);
//                grid.setConstraints(labelPrice, 12, lstRowIndex);
//                grid.getChildren().addAll(labelName, minus, plus, labelPrice);
//            }
//        }
//        return grid;
//    }
//
//
//    GridPane orderedItemsViewer(List<OrderItem> items, Order takeAwayOrder) {
//        GridPane grid = new GridPane();
//        grid.setHgap(8);
//        grid.setVgap(2);
//        grid.setPadding(new Insets(15, 15, 15, 15));
//        Label titleSection = new Label("Total Invoice"); // for test only it will be automated
//        grid.setConstraints(titleSection, 0, 0);
//        grid.getChildren().addAll(titleSection);
//        for (int j = 0; j < items.size(); j++) {
//            Label labelName = new Label("     - " + items.get(j).getName());
//            Label labelQuantity = new Label("x" + items.get(j).getQuantity());
//
//            Label labelPrice = new Label(Double.toString(items.get(j).getPrice()));
//            grid.setConstraints(labelName, 0, j + 1);
//            grid.setConstraints(labelQuantity, 2, j + 1);
//            grid.setConstraints(labelPrice, 12, j + 1);
//            grid.getChildren().addAll(labelName, labelQuantity, labelPrice);
//        }
//        Label totalAmountLabel = new Label("Total Amount : ");
//
//        Label totalPriceLabel = new Label(Double.toString(takeAwayOrder.getBill()));
//        grid.setConstraints(totalAmountLabel, 0, items.size() + 1);
//        grid.setConstraints(totalPriceLabel, 12, items.size() + 1);
//        grid.getChildren().addAll(totalAmountLabel, totalPriceLabel);
//
//        titleSection.getStyleClass().add("label-title");
//        totalAmountLabel.getStyleClass().add("label-title");
//
//        return grid;
//    }
//
//    void update() {
//        orderedGrid = orderedItemsViewer(takeAwayOrder.getOrderItemList(), takeAwayOrder);
//        layout.getChildren().remove(col_r);
//        col_r = new VBox();
//        col_r.getChildren().addAll(orderedGrid, btns);
//        layout.getChildren().add(col_r);
//    }
//}
package restpack.restaurant_project_gui;
public class TakeAway extends OrderView {
    public TakeAway() {
        firstBtnInit();
        secondBtnInit();
    }

    @Override
    public void firstBtnInit() {
        firstBtn.setText("Cash");
        firstBtn.setOnAction(e -> {
            System.out.println("order are pressed = " + orderToView.getBill());
            ConfirmBox checkOrdering = new ConfirmBox();
            Boolean chck = checkOrdering.display("Reciept Request" , "Are You Sure want to get Receipt and t7asb");
            if (chck){
                asuResto.setAvailableCash(asuResto.getAvailableCash()+ orderToView.getBill());
                orderToView.finishOrder();
                update();
            }
        });
    }
    @Override
    public void secondBtnInit() {
        secondBtn.setText("VISA");
        secondBtn.setOnAction(e -> {
            alert.display("Uner Condtruction" , "It's not working yet");
            System.out.println("receipt are pressed ");

        });
    }

    @Override
    public void setOrderToView() {
//        orderToView = asuResto.getTakeaway();
    }
}