package org.example.demo2;

import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewCustomerController{

    public Label customerName;
    public Label streetAddress;
    public Label city;
    public Label state;
    public Label zip;
    public Label beerLicense;
    public Label payment;
    public Label loadingDockCapabilities;
    public Label deliveryConstraints;


    public void readFile(File file) {
        BufferedReader reader;
        List<String> customerInfo = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                System.out.println(line);
                customerInfo.add(line);
                switch (count){
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
}
