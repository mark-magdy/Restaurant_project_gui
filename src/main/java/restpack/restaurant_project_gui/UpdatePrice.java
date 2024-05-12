package restpack.restaurant_project_gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import restLogic.Restaurant;

public class UpdatePrice {
    Scene settings, scene;
    SettingsGui gui = new SettingsGui();
    public Scene createScene(Stage window, Restaurant asuResto) {
        Button back = new Button("Back");
        back.getStyleClass().add("button_back");
        back.getStyleClass().add("button_back");
        settings = gui.createScene(window, asuResto);
        back.setOnAction(e -> {
            window.setScene(settings);
        });
        HBox h=new HBox();
        h.getChildren().add(back);
        scene=new Scene(h);
        scene.getStylesheets().add(getClass().getResource("Settings.css").toExternalForm());
        return scene;

    }
}
