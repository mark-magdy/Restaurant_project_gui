package restpack.restaurant_project_gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import restLogic.Restaurant;

public class ShowTotalInput {
    Scene settings, scene;

    SettingsGui gui = new SettingsGui();

    public Scene createScene(Stage window, Restaurant asuResto) {
        Button back = new Button("Back");
        back.getStyleClass().add("button_back");
        settings = gui.createScene(window, asuResto);
        back.setOnAction(e -> {
            window.setScene(settings);
        });

        Label label=new Label("The total input is " + asuResto.getAvailableCash());

        HBox h=new HBox();
        h.getChildren().add(back);
        VBox v=new VBox(h,label);
        scene=new Scene(v);
        scene.getStylesheets().add(getClass().getResource("Settings.css").toExternalForm());
        return scene;

    }
}
