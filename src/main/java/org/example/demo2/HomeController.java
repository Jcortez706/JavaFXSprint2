 package org.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The HomeController class controls the behavior of the home-view.fxml.
 * It handles the actions triggered by various buttons in the home view.
 */
public class HomeController {

    public Button customerListButton;
    public Button navigationButton;
    public Button placeOrderButton;
    public Button logoutButton;

    /**
     * Handles the action when the customer list button is clicked.
     * It closes the current window and opens the list-customer.fxml.
     *
     * @param actionEvent The action event triggered by clicking the customer list button
     * @throws IOException If an error occurs while loading the FXML file
     */
    public void onCustomerClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) customerListButton.getScene().getWindow();
        stage.close();
        Stage homeStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("list-customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles the action when the place order button is clicked.
     * It closes the current window and opens the order-view.fxml.
     *
     * @param actionEvent The action event triggered by clicking the place order button
     * @throws IOException If an error occurs while loading the FXML file
     */
    public void onOrderClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) placeOrderButton.getScene().getWindow();
        stage.close();
        Stage homeStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("order-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles the action when the logout button is clicked.
     * It closes the current window and opens the login-view.fxml.
     *
     * @param actionEvent The action event triggered by clicking the logout button
     * @throws IOException If an error occurs while loading the FXML file
     */
    public void onLogoutClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        Stage loginStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }
}