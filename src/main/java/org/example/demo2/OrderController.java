/**
 * The OrderController class controls the behavior of the order-view.fxml.
 * It initializes the order list and handles the action when buttons are clicked.
 */
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

    /** ListView to display order names. */
    @FXML
    public ListView<String> orderListView;

    /** Button to place an order. */
    public Button placeOrderButton;

    /** Button to go back to the home view. */
    public Button backButton;

    /** Currently selected order. */
    String currentOrder;

    /**
     * Initializes the order list view with the predefined order names.
     *
     * @param url            The location used to resolve relative paths for the root object
     * @param resourceBundle The resources used to localize the root object, or null
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String userHome = System.getProperty("user.home");

        File directory = new File(userHome + "/ACME/savedOrder");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File[] files = directory.listFiles();
        assert files != null;
        List<String> order = new ArrayList<>();
        for (File file : files) {
            order.add(file.getName());
        }
        orderListView.getItems().addAll(order);

        orderListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentOrder = orderListView.getSelectionModel().getSelectedItem();
                System.out.println(currentOrder);
                try {
                    createOrder(new File(userHome + "/ACME/savedOrder/" + currentOrder));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /**
     * Opens the previous-order.fxml and displays the details of the selected order.
     *
     * @param file The file containing the details of the selected order
     * @throws IOException If an error occurs while loading the FXML file
     */
    private void createOrder(File file) throws IOException {

        Stage stage = (Stage) orderListView.getScene().getWindow();
        stage.close();

        Stage loginStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("previous-order.fxml"));
        Parent root = fxmlLoader.load();

        PreviousOrder controller = fxmlLoader.getController();

        controller.readFile(file);

        Scene scene = new Scene(root);
        loginStage.setTitle(file.getName());
        loginStage.setScene(scene);
        loginStage.show();
    }

    /**
     * Handles the action when the place order button is clicked.
     * It closes the current window and opens the add-order.fxml.
     *
     * @param actionEvent The action event triggered by clicking the place order button
     * @throws IOException If an error occurs while loading the FXML file
     */
    public void loadPlaceOrderScreen(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) placeOrderButton.getScene().getWindow();
        stage.close();
        Stage homeStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-order.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles the action when the back button is clicked.
     * It closes the current window and opens the home-view.fxml.
     *
     * @param actionEvent The action event triggered by clicking the back button
     * @throws IOException If an error occurs while loading the FXML file
     */
    public void backHome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        Stage homeStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }
}