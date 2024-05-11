package restpack.restaurant_project_gui;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Login {

    public int display() {
        AtomicInteger returnValue = new AtomicInteger();
        returnValue.set(0);
        Stage LoginStage = new Stage();
        LoginStage.initModality(Modality.APPLICATION_MODAL);

        // Create UI elements
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();

        Label message = new Label();
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
        gridPane.add(message, 0, 3);
        gridPane.add(loginButton,1,2);

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

                    String[] arrOfStr = row.split(" ", 3);
                    if (arrOfStr[0].equals(nameInput)) {
                        if (arrOfStr[1].equals(passwordInput))
                        {
                            if(arrOfStr[2].equals("Manager")) {
                                returnValue.set(2);
                                message.setText("Manager");
                                LoginStage.close();
                                break; }
                            else if (arrOfStr[2].equals("Worker")){
                                returnValue.set(1);
                                message.setText("Worker");
                                LoginStage.close();
                                break;
                            }
                        } else {
                            message.setText("Wrong Password");
                        }
                    }
                }
                message.setText("User not found");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                //e.printStackTrace();
            }
        });

        // Set up the scene
        Scene scene = new Scene(gridPane, 300, 150);
        LoginStage.setScene(scene);
        LoginStage.setTitle("Login");
        LoginStage.showAndWait();
        return returnValue.get();

    }
}
