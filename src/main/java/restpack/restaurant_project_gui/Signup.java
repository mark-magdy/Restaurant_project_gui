package restpack.restaurant_project_gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Signup {
    public void display() {
        //System.out.println("works");
        Stage SignUpStage = new Stage();
        GridPane grid2 = new GridPane();

        SignUpStage.setWidth(600);
        SignUpStage.setHeight(400);

        Label Name = new Label("Name:");
        TextField nameField = new TextField();
        Label Password = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Label CheckPassword = new Label("Confirm Password:");
        PasswordField CPasswordField = new PasswordField();
        Label Job = new Label("Job:");
        TextField JobField = new TextField();

        Button Back = new Button("Back");
        Button SignupButton = new Button("Signup");

        grid2.add(Name, 1, 0);
        grid2.add(nameField, 2, 0);
        grid2.add(Password, 1, 1);
        grid2.add(passwordField, 2, 1);
        grid2.add(CheckPassword, 1, 2);
        grid2.add(CPasswordField, 2, 2);
        grid2.add(Job, 1, 3);
        grid2.add(JobField, 2, 3);

        grid2.add(Back, 1, 4);
        grid2.add(SignupButton, 4, 4);
        grid2.setHgap(20);
        grid2.setVgap(20);
        grid2.setPadding(new Insets(50));

        SignupButton.setOnAction(event -> {

            String nameInput = nameField.getText();
            String passwordInput = passwordField.getText();
            String checkPasswordInput = CPasswordField.getText();
            String jobInput = JobField.getText();
            String line = nameInput + " " + passwordInput + " " + jobInput;
            try {
                if (!nameInput.isEmpty() && !passwordInput.isEmpty()) {

                    if (passwordInput.equals(checkPasswordInput)) {
                       // new Thread(() -> {
                        StringBuilder contentBuilder = new StringBuilder();
                        contentBuilder.append("\n").append(line);
                        Files.write(Paths.get("C:\\Users\\hp\\IdeaProjects\\Restaurant_project_gui\\src\\main\\resources\\restpack\\restaurant_project_gui\\login.txt"), contentBuilder.toString().getBytes(), StandardOpenOption.APPEND);
                       // Platform.runLater(SignUpStage::close);
                        Label doneLabel = new Label("Registered");
                        grid2.add(doneLabel, 1, 5);
                    } else {
                        Label wrongPasswordLabel = new Label("Unmatched Password");
                        grid2.add(wrongPasswordLabel, 0, 2);
                    }
                } else {
                    Label putDataLabel = new Label("Please, Input data");
                    grid2.add(putDataLabel, 0, 3);
                }
            } catch (IOException e) {
                System.out.println("An error occurred at Signup.");
                e.printStackTrace();
            }
           // }).start();
        });

        Scene sceneSignup = new Scene(grid2, 300, 150);
        SignUpStage.setScene(sceneSignup);
        SignUpStage.setTitle("SignUp");
        SignUpStage.show();
    }
}
