
        package org.example.demo2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The ListCustomerController class controls the behavior of the list-customer-view.fxml.
 * It initializes the customer list and handles the action when the add customer button is clicked.
 */
public class ListCustomerController implements Initializable {

    @FXML
    public Button addCustomerButton;

    @FXML
    public ListView<String> customerListView;

    String currentCustomer;

    /**
     * Handles the action when the add customer button is clicked.
     * It closes the current window and opens the customer-view.fxml.
     *
     * @param actionEvent The action event triggered by clicking the add customer button
     * @throws IOException If an error occurs while loading the FXML file
     */
    public void AddCustomerClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) addCustomerButton.getScene().getWindow();
        stage.close();
        Stage loginStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("customer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the customer list view with the predefined customer names.
     *
     * @param url            The location used to resolve relative paths for the root object
     * @param resourceBundle The resources used to localize the root object, or null
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String userHome = System.getProperty("user.home");

        File directory = new File(userHome + "/ACME/savedCustomer");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File[] files = directory.listFiles();
        assert files != null;
        List<String> customer = new ArrayList<>() {
        };
        for (File file : files) {
            customer.add(file.getName());
        }
        customerListView.getItems().addAll(customer);

        customerListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentCustomer = customerListView.getSelectionModel().getSelectedItem();
                System.out.println(currentCustomer);
                try {
                    createCustomer(new File("C:/Users/jacob.cortez/Intellij Projects/demo2/src/main/resources/savedCustomer/" + currentCustomer));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void createCustomer(File file) throws IOException {

        Stage stage = (Stage) addCustomerButton.getScene().getWindow();
        stage.close();

        Stage loginStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view-customer-view.fxml"));
        Parent root = fxmlLoader.load();

        ViewCustomerController controller = fxmlLoader.getController();

        controller.readFile(file);

        Scene scene = new Scene(root);
        loginStage.setTitle(file.getName());
        loginStage.setScene(scene);
        loginStage.show();

    }
}