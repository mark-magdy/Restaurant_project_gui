package restpack.restaurant_project_gui;

import MenuPack.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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

public class Appe_additem {


    Scene app, scene;
    Appetizers_Gui app_gui=new Appetizers_Gui();

    TableView<Appetizers> table;

    Alert alert =new Alert();
    TableColumn <Appetizers,String> namecoulmn= new TableColumn<>("ItemName");
    TableColumn <Appetizers,Double> pricecoulmn= new TableColumn<>("ItemPrice");
    TableColumn <Appetizers,Integer> quantitycoulmn= new TableColumn<>("ItemQuantity");
    TextField nameinput,priceinput,quantityinput;
    public Scene createScene(Stage window, Restaurant asuResto) {
        Button back = new Button("Back");
        back.getStyleClass().add("button_back");
        app = app_gui .createScene(window, asuResto);
        back.setOnAction(e -> {
            window.setScene(app);
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

        priceinput=new TextField();
        priceinput.setPromptText("Price");
        priceinput.setMinWidth(100);

        quantityinput=new TextField();
        quantityinput.setPromptText("Quantity");
        quantityinput.setMinWidth(100);

        Button addButton=new Button("Add");
        addButton.getStyleClass().add("button_add_remove");
        addButton.setOnAction(e->addbuttonclicked(asuResto));


        HBox down=new HBox();
        down.setPadding(new Insets(5,5,5,5));
        down.setSpacing(20);
        down.getChildren().addAll(nameinput,priceinput,quantityinput,addButton);

        VBox v=new VBox();
        HBox up=new HBox();
        up.getChildren().add(back);
        v.getChildren().addAll(up,table,down);
        scene=new Scene(v);
        scene.getStylesheets().add(getClass().getResource("Settings.css").toExternalForm());
        return scene;
    }


    public  void addbuttonclicked(Restaurant asuResto){

        try{
            String name =nameinput.getText();
            double price=Double.parseDouble(priceinput.getText());
            int quantity=Integer.parseInt(quantityinput.getText());
            Appetizers temp =new Appetizers();
            asuResto.getMainMenu().addItem("Appetizers",nameinput.getText(),Double.parseDouble(priceinput.getText()),Integer.parseInt(quantityinput.getText()));
            temp.setName(nameinput.getText());
            temp.setPrice(Double.parseDouble(priceinput.getText()));
            temp.setStockQuantity(Integer.parseInt(quantityinput.getText()));
            table.getItems().add(temp);
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
            alert.display("Error Input" , "Please Enter valid inputs" );
        }
        nameinput.clear();
        priceinput.clear();
        quantityinput.clear();
    }


    public  ObservableList<Appetizers> getitems(Restaurant asuResto){
        ObservableList<Appetizers> items= FXCollections.observableArrayList();
        for(int i =0;i<asuResto.getMainMenu().getSections().get(0).getItems().size();i++)
            items.add((Appetizers) asuResto.getMainMenu().getSections().get(0).getItems().get(i));
        return items;
    }
}
