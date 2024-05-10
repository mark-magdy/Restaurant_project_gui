package restpack.restaurant_project_gui;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login {



    public boolean display() {
        AtomicBoolean userExists = new AtomicBoolean(false);
        AtomicBoolean passwordCorrect = new AtomicBoolean(false);
        Stage LoginStage = new Stage();
        // Create UI elements
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();
        Button loginButton = new Button("Login");

        // Set up the layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);
        // action for clicking login button
        loginButton.setOnAction(event -> {

            String nameInput = nameField.getText();
            String passwordInput = passwordField.getText();

            try {
                String resourceUrl = getClass().getResource("login.txt").getPath();
                System.out.println("path ="+resourceUrl);

                Scanner scanner = new Scanner(getClass().getResourceAsStream("login.txt"));
                while (scanner.hasNextLine()) {
                    String row = scanner.nextLine();
                    System.out.println("row ="+row);

                    String[] arrOfStr = row.split(" ", 2);
                    if (arrOfStr[0].equals(nameInput)) {
                        userExists.set(true);
                        if (arrOfStr[1].equals(passwordInput)) {
                            passwordCorrect.set(true);
                            break;
                        } else if (arrOfStr[1].equals(passwordInput) == false) {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                //e.printStackTrace();
            }
            if (!userExists.get()) {
                System.out.println("User name doesn't exist");
                Label nouserLabel = new Label("Wrong Username");
                gridPane.add(nouserLabel, 0, 3);
            } else if (!passwordCorrect.get()) {
                System.out.println("Wrong Password");
                Label wrongPasswordLabel = new Label("Wrong Password");
                gridPane.add(wrongPasswordLabel, 0, 3);
            }
            if ((userExists.get() && passwordCorrect.get())){
                LoginStage.close();
            }
        });

        // Set up the scene
        Scene scene = new Scene(gridPane, 300, 150);
        LoginStage.setScene(scene);
        LoginStage.setTitle("Login");
        LoginStage.showAndWait();
        if(userExists.get() && passwordCorrect.get()) {
            return true;
        } else {
            return false;
        }
    }
}
