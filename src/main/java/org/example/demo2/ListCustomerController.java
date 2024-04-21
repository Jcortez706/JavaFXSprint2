package org.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListCustomerController implements Initializable {
    @FXML
    public Button addCustomerButton;
    @FXML
    public ListView<String> customerListView;
    String[] customer = {"SECO", "LOCAL"};
    String currentCustomer;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerListView.getItems().addAll(customer);

    }
}
