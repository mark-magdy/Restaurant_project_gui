package restpack.restaurant_project_gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import restLogic.Restaurant;


public class Home {
    Button takeAwayBut = new Button("TakeAway"),
            dineIn = new Button("DineIn"),
            settings = new Button("Settings"),
            signupBtn = new Button("Sign-Up "),
            loginBtn = new Button();

    HBox layout = new HBox(), firstRow = new HBox();
    VBox col = new VBox();
    Alert alertMsg = new Alert();
    Login login = new Login();
    Signup signup = new Signup();

    public Scene createScene(Stage window, Restaurant asuResto) {
        Scene scene;
        TakeAway takeAwayObj = new TakeAway();
        DineIn dineInObj = new DineIn();
        SettingsGui settingsGuiObj = new SettingsGui();

        takeAwayBut.setOnAction(e -> {
            if (enterWindow('T',asuResto.getStateOfLogin())) {
                window.setScene(takeAwayObj.createScene(window, asuResto));
            }else {
                alertMsg.display("need permission " ,"                   you are not allowed enter\nif you think this is an error contact the support team \n        Or Login first with account have permission");
            }
        });
        dineIn.setOnAction(e -> {
            if (enterWindow('D',asuResto.getStateOfLogin())) {
                Scene tmp = dineInObj.createScene(window, asuResto);
                window.setScene(tmp);
            }else {
                alertMsg.display("need permission " ,"                   you are not allowed enter\nif you think this is an error contact the support team \n        Or Login first with account have permission");
            }
        });
        settings.setOnAction(e -> {
            if (enterWindow('S',asuResto.getStateOfLogin())) {
                Scene tmp = settingsGuiObj.createScene(window, asuResto);
                window.setScene(tmp);
            }else {
                alertMsg.display("need permission " ,"                   you are not allowed enter\nif you think this is an error contact the support team \n        Or Login first with account have permission");
            }
        });
        signupBtn.setOnAction(e -> {
            signup.display();
        });
        loginBtn.setOnAction(e -> {
            if (asuResto.getStateOfLogin() == 0) {
                asuResto.setStateOfLogin(login.display());
                System.out.println(asuResto.getStateOfLogin());
                if (asuResto.getStateOfLogin()>0)loginBtn.setText("Logout");
            } else {
                asuResto.setStateOfLogin(0);
                loginBtn.setText("Login");
            }
        });
        loginBtn.setText((asuResto.getStateOfLogin()>0?"Logout" : "Login"));
        firstRow.getChildren().addAll(loginBtn,signupBtn);
        firstRow.setSpacing(10);
        signupBtn.setAlignment(Pos.TOP_RIGHT);
        firstRow.setAlignment(Pos.TOP_RIGHT);
        settings.getStyleClass().add("button-big");
        takeAwayBut.getStyleClass().add("button-big");
        dineIn.getStyleClass().add("button-big");
        signupBtn.setId("bb-signup");
        Image icon = new Image(getClass().getResourceAsStream("iconR .png"));
        ImageView imageView = new ImageView(icon);
        StackPane st = new StackPane();
        st.getChildren().add(imageView);
        st.setAlignment(Pos.CENTER);
        col.getChildren().addAll(firstRow,st, layout);
        layout.setId("hbox");
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().removeAll();
        layout.getChildren().addAll(dineIn, takeAwayBut, settings);
        col.setSpacing(20);
        scene = new Scene(col);
        scene.getStylesheets().add(getClass().getResource("Home.css").toExternalForm());
        return scene;
    }

    Boolean enterWindow(char c, int stateOfLogin) {
        if (stateOfLogin == 0) {
            return false;
        } else if ((stateOfLogin == 1||stateOfLogin==2) && (c == 'D' || c == 'T')) return true;
        else if (stateOfLogin == 2 && c == 'S') return true;
        else return false;
    }
}
