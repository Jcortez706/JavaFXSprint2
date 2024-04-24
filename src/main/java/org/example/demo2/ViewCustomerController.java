package org.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewCustomerController {

    /** Label to display the customer's name. */
    public Label customerName;

    /** Label to display the customer's street address. */
    public Label streetAddress;

    /** Label to display the customer's city. */
    public Label city;

    /** Label to display the customer's state. */
    public Label state;

    /** Label to display the customer's ZIP code. */
    public Label zip;

    /** Label to display the customer's beer license information. */
    public Label beerLicense;

    /** Label to display the customer's payment information. */
    public Label payment;

    /** Label to display the customer's loading dock capabilities. */
    public Label loadingDockCapabilities;

    /** Label to display the customer's delivery constraints. */
    public Label deliveryConstraints;

    /** TextArea to display additional customer information. */
    public TextArea textArea;

    /** Button to navigate back to the list-customer.fxml. */
    public Button backButton;

    /**
     * Reads the contents of the given file and populates the labels with the customer information.
     *
     * @param file The file containing the customer information
     */
    public void readFile(File file) {
        textArea.toBack();
        BufferedReader reader;
        List<String> customerInfo = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                System.out.println(line);
                customerInfo.add(line);
                switch (count) {
                    case 1:
                        streetAddress.setText(line);
                        break;
                    case 2:
                        city.setText(line);
                        break;
                    case 3:
                        state.setText(line);
                        break;
                    case 4:
                        zip.setText(line);
                        break;
                    case 5:
                        beerLicense.setText(line);
                        break;
                    case 6:
                        payment.setText(line);
                        break;
                    case 7:
                        loadingDockCapabilities.setText(line);
                        break;
                    case 8:
                        deliveryConstraints.setText(line);
                        break;
                    default:
                        customerName.setText(line);
                        break;
                }
                count++;
                line = reader.readLine();
            }
            reader.close();
            if (customerInfo.size() == 9) {
                Customer customer = new Customer(customerInfo.get(0), customerInfo.get(1), customerInfo.get(2), customerInfo.get(3), customerInfo.get(4), customerInfo.get(5), customerInfo.get(6), customerInfo.get(7), customerInfo.get(8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action when the back button is clicked.
     * It closes the current window and opens the list-customer.fxml.
     *
     * @param actionEvent The action event triggered by clicking the back button
     * @throws IOException If an error occurs while loading the FXML file
     */
    public void backButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        Stage homeStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("list-customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }
}