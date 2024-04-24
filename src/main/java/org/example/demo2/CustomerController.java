/**
 * This class serves as the controller for adding customers in the application.
 */
package org.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerController {

    /** Button to add a customer. */
    public Button addCustomer;

    /** TextField for customer name. */
    @FXML
    public TextField CN;

    /** TextField for street address. */
    @FXML
    private TextField SA;

    /** TextField for city. */
    @FXML
    private TextField City;

    /** TextField for state. */
    @FXML
    private TextField State;

    /** TextField for ZIP code. */
    @FXML
    private TextField Zip;

    /** TextField for beer license. */
    @FXML
    private TextField BL;

    /** TextField for form of payment. */
    @FXML
    private TextField FOP;

    /** TextField for loading dock capabilities. */
    @FXML
    private TextField LDC;

    /** TextField for delivery constraints. */
    @FXML
    private TextField DC;

    /**
     * Saves customer details to a file.
     *
     * @param CN  TextField for customer name.
     * @param SA  TextField for street address.
     * @param City TextField for city.
     * @param State TextField for state.
     * @param Zip  TextField for ZIP code.
     * @param BL   TextField for beer license.
     * @param FOP  TextField for form of payment.
     * @param LDC  TextField for loading dock capabilities.
     * @param DC   TextField for delivery constraints.
     */
    private void SaveCustomer(TextField CN, TextField SA, TextField City, TextField State, TextField Zip, TextField BL, TextField FOP, TextField LDC, TextField DC) {
        String userHome = System.getProperty("user.home");
        String directoryPath = userHome + "/ACME/savedCustomer";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        PrintWriter pw = null;
        System.out.println(CN.getText());
        try {
            File myfile = new File(userHome + "/ACME/savedCustomer/" + CN.getText());
            pw = new PrintWriter(myfile);
            pw.println(CN.getText());
            pw.println(SA.getText());
            pw.println(City.getText());
            pw.println(State.getText());
            pw.println(Zip.getText());
            pw.println(BL.getText());
            pw.println(FOP.getText());
            pw.println(LDC.getText());
            pw.println(DC.getText());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    /**
     * Handles the event when a customer is added.
     *
     * @param actionEvent ActionEvent triggered when the button is clicked.
     * @throws IOException If an I/O error occurs.
     */
    public void addCustomer(ActionEvent actionEvent) throws IOException {

        SaveCustomer(CN, SA, City, State, Zip, BL, FOP, LDC, DC);

        Stage stage = (Stage) addCustomer.getScene().getWindow();
        stage.close();
        Stage homeStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("list-customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }
}