package restpack.restaurant_project_gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import restLogic.Restaurant;


public class Home {

    Button takeAwayBut = new Button("TakeAway"),
            dineIn = new Button("DineIn"),
            settings = new Button("Settings");

    HBox layout = new HBox();
    Alert alertMsg = new Alert();
    Login login = new Login();
    Signup signup = new Signup();

    public Scene createScene(Stage window, Restaurant asuResto) {
        Scene scene;
        TakeAway takeAwayObj = new TakeAway();
        DineIn dineInObj = new DineIn();
        SettingsGui settingsGuiObj = new SettingsGui();

        //Scene takeAwayScene = takeAwayObj.createScene(window);
        takeAwayBut.setOnAction(e -> {
            if (login.display()) {
                window.setScene(takeAwayObj.createScene(window, asuResto));
            }
        });
        dineIn.setOnAction(e -> {
            if (login.display()) {
                Scene tmp = dineInObj.createScene(window, asuResto);
                window.setScene(tmp);
            }
        });
//        manager.setOnAction(e -> alertMsg.display ("Under Construction" , "Thank you for using our service! \n           Under construction") );
        settings.setOnAction(e -> {
            signup.display();

//            if (login.display()) {
//                Scene tmp = settingsGuiObj.createScene(window, asuResto);
//                window.setScene(tmp);
//            }
        });
        layout.setId("hbox");
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().removeAll();
        layout.getChildren().addAll(dineIn, takeAwayBut, settings);
        scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("Home.css").toExternalForm());
        return scene;
    }

}
