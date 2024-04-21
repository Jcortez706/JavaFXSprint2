package org.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ListCustomerController {
    public Button addCustomerButton;

    public void AddCustomerClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) addCustomerButton.getScene().getWindow();
        stage.close();
        Stage loginStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("customer-view.fxml"));
        Scene scene = new Scene(
                fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }
}
