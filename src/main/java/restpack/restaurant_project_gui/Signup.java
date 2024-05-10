package restpack.restaurant_project_gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
        Stage SignUpStage = new Stage();
        Button SignupButton = new Button("Signup");
        GridPane grid2 = new GridPane();

        Label Name = new Label("Name:");
        TextField nameField = new TextField();
        Label Password = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Label CheckPassword = new Label("Confirm Password:");
        PasswordField CPasswordField = new PasswordField();
        Label Job = new Label("Job:");
        TextField JobField = new TextField();

        Button Back = new Button("Back");

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
        grid2.setHgap(50);
        grid2.setVgap(50);
        grid2.setPadding(new Insets(50));

        SignupButton.setOnAction(event -> {

            String nameInput = nameField.getText();
            String passwordInput = passwordField.getText();
            String checkPasswordInput = CPasswordField.getText();
            String jobInput = JobField.getText();
            String line = nameInput + " " + passwordInput + "" + jobInput;
            try {
                if (!nameInput.isEmpty() && !passwordInput.isEmpty()) {

                    if (passwordInput.equals(checkPasswordInput)) {
                        StringBuilder contentBuilder = new StringBuilder();
                        contentBuilder.append("\n").append(line);
                        Files.write(Paths.get("login.txt"), contentBuilder.toString().getBytes(), StandardOpenOption.APPEND);
                        SignUpStage.close();
                    } else {
                        Label wrongPasswordLabel = new Label("Unmatched Password");
                        grid2.add(wrongPasswordLabel, 0, 3);
                    }
                } else {
                    Label putDataLabel = new Label("Please, Input data");
                    grid2.add(putDataLabel, 0, 3);
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        });
        SignUpStage.show();
    }
}
