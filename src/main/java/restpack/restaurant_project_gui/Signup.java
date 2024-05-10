package restpack.restaurant_project_gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Signup {
    public void display() {
        Stage SignUpStage = new Stage();
        Button SignupButton = new Button("Signup");
        GridPane grid2 = new GridPane();

        grid2.add(Name,1,0);
        grid2.add(namefield,2,0);
        grid2.add(Password,1,1);
        grid2.add(passwordfield,2,1);
        grid2.add(CheckPassword,1,2);
        grid2.add(CPasswordfield,2,2);
        grid2.add(Job,1,3);
        grid2.add(Jobfield,2,3);

        grid2.add(Back,1,4);
        grid2.add(Signup,4,4);
        grid2.setHgap(50);
        grid2.setVgap(50);
        grid2.setPadding(new Insets(50));

        SignupButton.setOnAction(event -> {

            String nameInput = nameField.getText();
            String passwordInput = passwordField.getText();
            String checkPasswordInput = CPasswordfield.getText();
            String jobInput = Jobfield.getText();
            String line = nameInput +" "+ passwordInput +""+ jobInput;
    try {
        if(!nameInput.isEmpty() && !passwordInput.isEmpty()){
            
        if(passwordInput.equals(checkPasswordInput)){
        StringBuilder contentBuilder = new StringBuilder();       
        contentBuilder.append("\n").append(line);
        Files.write((getClass().getResourceAsStream("login.txt")), contentBuilder.toString().getBytes(), StandardOpenOption.APPEND);
        SignUpStage.close();
        }
        else{
            Label wrongPasswordLabel = new Label("Unmatched Password");
            grid2.add(wrongPasswordLabel, 0, 3);
        }
    }
    else{
        Label putDataLabel = new Label("Please, Input data");
        grid2.add(putDataLabel, 0, 3);
    }
    }
    catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
    }
    });
}
}