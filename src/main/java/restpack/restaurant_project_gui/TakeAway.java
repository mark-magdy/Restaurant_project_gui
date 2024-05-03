package restpack.restaurant_project_gui;

import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class TakeAway {
    HBox tst ;
    Scene scene  ;
    Label label;
    Button back ;
    public TakeAway(Scene bck , Stage wind ) {
        back = new Button();
        back.setOnAction(e -> wind.setScene(bck));
        tst= new HBox();
        label = new Label ("here Casher will order the takaways ");
        tst.getChildren().addAll(label,back) ;
        scene = new Scene(tst);
    }

    public Scene getScene() {
        return scene;
    }
}
