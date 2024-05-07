package restpack.restaurant_project_gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Home {

    Button takeAwayBut = new Button("TakeAway") ,
            dineIn = new Button("DineIn") ,
            manager  = new Button("Manager");

    HBox layout = new HBox() ;
    Alert alertMsg = new Alert ();
    public  Scene createScene(Stage window){
        Scene scene;
        TakeAway takeAwayObj = new TakeAway();
        DineIn dineInObj = new DineIn();

        //Scene takeAwayScene = takeAwayObj.createScene(window);
        takeAwayBut.setOnAction(e -> {
            window.setScene(takeAwayObj.createScene(window));
        });
        dineIn.setOnAction(e -> {
            Scene tmp = dineInObj.createScene(window);
            window.setScene(tmp);
        });
        manager.setOnAction(e -> alertMsg.display ("Under Construction" , "Thank you for using our service! \n           Under construction") );
        layout.setId("hbox");
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().removeAll();
        layout.getChildren().addAll(dineIn,takeAwayBut, manager);
        scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("Home.css").toExternalForm());
        return scene;
    }

}
