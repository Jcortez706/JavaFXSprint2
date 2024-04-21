package org.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * The LoginController class controls the behavior of the login-view.fxml.
 * It handles user interactions and manages the login process.
 */
public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label login;

    /**
     * Handles the action when the login button is clicked.
     * If the entered username and password are correct, it closes the login window
     * and opens the home-view.fxml. Otherwise, it displays an error message.
     *
     * @param actionEvent The action event triggered by clicking the login button
     * @throws IOException If an error occurs while loading the FXML file
     */
    public void onLoginButtonClicked(ActionEvent actionEvent) throws IOException {
        if (Objects.equals(username.getText(), "Admin") && Objects.equals(password.getText(), "Admin")) {
            Stage stage = (Stage) login.getScene().getWindow();
            stage.close();
            Stage homeStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
            Scene scene = new Scene(
                    fxmlLoader.load());
            stage.setTitle("ACME");
            stage.setScene(scene);
            stage.show();
        } else {
            login.setText("Username or Password is incorrect.");
        }
    }
}
