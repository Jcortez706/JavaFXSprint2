package org.example.demo2;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomerController implements Initializable {

    public Label customerName;
    public Label streetAddress;
    public Label city;
    public Label state;
    public Label zip;
    public Label beerLicense;
    public Label payment;
    public Label loadingDockCapabilities;
    public Label deliveryConstraints;
    File loadedFile = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        if (loadedFile != null) {
            File file = new File("C:/Users/jacob.cortez/Intellij Projects/demo2/src/main/resources/savedCustomer/" + loadedFile.getName());
            BufferedReader reader;
            List<String> customerInfo = new ArrayList<>();

            try {
                reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    customerInfo.add(line);
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

}

public void setFile(File file){
        loadedFile = file;
}

}
