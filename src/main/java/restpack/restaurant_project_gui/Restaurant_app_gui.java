package restpack.restaurant_project_gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Restaurant_app_gui extends Application {

    Stage window;
    Home home =new Home();
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        window= stage ;
        window.setWidth(800);window.setHeight(500);
        window.setTitle("ASU Restaurant");
        Image icon = new Image(getClass().getResourceAsStream("icon .jpeg"));
        window.getIcons().add(icon);
        window.setOnCloseRequest(e -> {
            e.consume();
            closePrograme();
        });

        Scene homeScene =home.createScene(window) ;
        window.setScene(homeScene);
        window.show();
    }
    private void closePrograme(){
        ConfirmBox confirmBox = new ConfirmBox();
        Boolean res = confirmBox.display("Exit Request","Are you sure want to quit ?!");
        if (res)window.close() ;
        else return;
    }
}