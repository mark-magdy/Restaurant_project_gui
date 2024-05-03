package restpack.restaurant_project_gui;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Home {

    public  Scene createScene(Stage window){
        Scene scene;
        Alert alertMsg = new Alert ();
        TakeAway takeAwayObj = new TakeAway();
        DineIn dineInObj = new DineIn();

        //Scene takeAwayScene = takeAwayObj.createScene(window);
        Button takeAwayBut = new Button("TakeAway") , dineIn = new Button("DineIn") , manager  = new Button("Manager");
        takeAwayBut.setOnAction(e -> {
            window.setScene(takeAwayObj.createScene(window));
            window.close();
            window.show();
        });
        dineIn.setOnAction(e -> {
            window.setScene(dineInObj.createScene(window));
            window.close();
            window.show();
        });
        manager.setOnAction(e -> alertMsg.display ("Under Construction" , "Thank you for using our service! \n           Under construction") );
        HBox layout = new HBox() ;
        layout.setId("hbox");
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(dineIn,takeAwayBut, manager);
        scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("Home.css").toExternalForm());
        return scene;
    }

}
