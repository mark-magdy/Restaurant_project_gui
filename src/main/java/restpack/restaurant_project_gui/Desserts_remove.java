package restpack.restaurant_project_gui;

import MenuPack.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import restLogic.Restaurant;

public class Desserts_remove {
    Scene desserts_Gui, scene;

    Desserts_gui gui = new Desserts_gui();

    TableView<Desserts> table;
    TableColumn<Desserts,String> namecoulmn= new TableColumn<>("ItemName");
    TableColumn <Desserts,Double> pricecoulmn= new TableColumn<>("ItemPrice");
    TableColumn <Desserts,Integer> quantitycoulmn= new TableColumn<>("ItemQuantity");
    TextField nameinput,priceinput,quantityinput;
    public Scene createScene(Stage window, Restaurant asuResto) {
        Button back = new Button("Back");
        back.getStyleClass().add("button_back");
        desserts_Gui = gui.createScene(window, asuResto);
        back.setOnAction(e -> {
            window.setScene(desserts_Gui);
        });
        namecoulmn.setMinWidth(200);
        namecoulmn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pricecoulmn.setMinWidth(200);
        pricecoulmn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantitycoulmn.setMinWidth(200);
        quantitycoulmn.setCellValueFactory(new PropertyValueFactory<>("stockQuantity"));

        table=new TableView<>();
        table.setItems(getitems(asuResto));
        table.getColumns().addAll(namecoulmn,pricecoulmn,quantitycoulmn);

        nameinput=new TextField();
        nameinput.setPromptText("Name");
        nameinput.setMinWidth(100);


        Button removeButton=new Button("Remove");
        removeButton.getStyleClass().add("button_add_remove");

        removeButton.setOnAction(e->deleteButtonCliced(asuResto));


        HBox down=new HBox();
        down.setPadding(new Insets(5,5,5,5));
        down.setSpacing(20);
        down.setAlignment(Pos.CENTER);
        down.getChildren().addAll(nameinput,removeButton);


        VBox v=new VBox();
        HBox up=new HBox();
        up.getChildren().add(back);
        v.getChildren().addAll(up,table,down);
        scene=new Scene(v);
        scene.getStylesheets().add(getClass().getResource("Settings.css").toExternalForm());
        return scene;

    }
    public ObservableList<Desserts> getitems(Restaurant asuResto){
        ObservableList<Desserts> items= FXCollections.observableArrayList();
        for(int i =0;i<asuResto.getMainMenu().getSections().get(3).getItems().size();i++)
            items.add((Desserts) asuResto.getMainMenu().getSections().get(3).getItems().get(i));
        return items;
    }
    public void deleteButtonCliced(Restaurant asuResto){
        String name =nameinput.getText();
        Boolean exist=false;
        for (MenuSection sec : asuResto.getMainMenu().getSections()) {
            for (int i = 0; i < sec.getSectionSize(); i++) {
                MenuItem m = sec.getItems().get(i);
                if (m.getName().equals(name)) {
                    exist = true;
                    MenuItem selected =m;
                    if (exist == true){
                        asuResto.getMainMenu().removeItem(name);
                    getitems(asuResto).remove(m);

                       }

                    nameinput.clear();
                }}}}}
