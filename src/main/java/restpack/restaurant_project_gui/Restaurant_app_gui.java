package restpack.restaurant_project_gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Restaurant_app_gui extends Application {

    Stage window;
    Scene scene;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        window= stage ;
        window.setMinWidth(800);window.setMinHeight(500);
        window.setTitle("ASU Restaurant");
        window.setOnCloseRequest(e -> {
            e.consume();
            closePrograme();
        });
        Alert alertMsg = new Alert ();
        TakeAway takeAwaySceneObject = new TakeAway(scene,window);

        Button takeAway = new Button("TakeAway") , dineIn = new Button("DineIn") , manager  = new Button("Manager");
        takeAway.setOnAction(e -> window.setScene(takeAwaySceneObject.getScene()));
        dineIn.setOnAction(e -> alertMsg.display ("Under Construction" , "Thank you for using our service! \n           Under construction") );
        manager.setOnAction(e -> alertMsg.display ("Under Construction" , "Thank you for using our service! \n           Under construction") );
        HBox layout = new HBox() ;
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(dineIn,takeAway , manager);
        scene = new Scene(layout) ;
        window.setScene(scene);
        window.show();
    }
    private void closePrograme(){
        ConfirmBox confirmBox = new ConfirmBox();
        Boolean res = confirmBox.display("Exit Request","Are you sure want to quit ?!");
        if (res)window.close() ;
        else return;
    }
}