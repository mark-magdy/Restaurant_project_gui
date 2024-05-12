package restpack.restaurant_project_gui;

import MenuPack.Menu;
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

public class Appetizers_remove {
    Scene settings, scene;

    SettingsGui gui = new SettingsGui();

    TableView<Menu> table;
    TableColumn<Menu,String> namecoulmn= new TableColumn<>("ItemName");
    TableColumn <Menu,Double> pricecoulmn= new TableColumn<>("ItemPrice");
    TableColumn <Menu,Integer> quantitycoulmn= new TableColumn<>("ItemQuantity");
    TextField nameinput,priceinput,quantityinput;
    public Scene createScene(Stage window, Restaurant asuResto) {
        Button back = new Button("Back");
        back.getStyleClass().add("button_back");
        settings = gui.createScene(window, asuResto);
        back.setOnAction(e -> {
            window.setScene(settings);
        });
        namecoulmn.setMinWidth(200);
        namecoulmn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pricecoulmn.setMinWidth(200);
        pricecoulmn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantitycoulmn.setMinWidth(200);
        quantitycoulmn.setCellValueFactory(new PropertyValueFactory<>("stockQuantity"));

        table=new TableView<>();
        //table.setItems(getitems());
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

        Button removeButton=new Button("Remove");
        removeButton.getStyleClass().add("button_add_remove");


        HBox down=new HBox();
        down.setPadding(new Insets(5,5,5,5));
        down.setAlignment(Pos.CENTER);
        down.getChildren().add(removeButton);

        VBox v=new VBox();
        HBox up=new HBox();
        up.getChildren().add(back);
        v.getChildren().addAll(up,table,down);
        scene=new Scene(v);
        scene.getStylesheets().add(getClass().getResource("Settings.css").toExternalForm());
        return scene;

    }
}

