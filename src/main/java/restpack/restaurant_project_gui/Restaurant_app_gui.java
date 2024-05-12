package restpack.restaurant_project_gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import restLogic.Restaurant;
import java.io.IOException;

public class Restaurant_app_gui extends Application {
    Stage window;
    Home home =new Home();
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        Restaurant asuResto = new Restaurant("ASU", "Abdo Basha Street",9);
        System.out.println("resto in main table ref"+ asuResto.getTables().get(0));
        window= stage ;
        window.setWidth(900);window.setHeight(600);
        window.setTitle("ASU Restaurant");
        Image icon = new Image(getClass().getResourceAsStream("iconR .png"));
        window.getIcons().add(icon);
        window.setOnCloseRequest(e -> {
            e.consume();
            closePrograme();
        });
        Scene homeScene =home.createScene(window, asuResto) ;
        window.setScene(homeScene);
        window.show();
    }
    private void closePrograme(){
        ConfirmBox confirmBox = new ConfirmBox();
        Boolean res = confirmBox.display("Exit Request","Are you sure want to quit ?!");
        if (res)window.close() ;
    }
}