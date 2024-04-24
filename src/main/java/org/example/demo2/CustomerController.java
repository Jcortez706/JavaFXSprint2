package org.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.*;

public class CustomerController {


    public Button addCustomer;
    @FXML
    public TextField CN;
    @FXML
    private TextField SA;
    @FXML
    private TextField City;
    @FXML
    private TextField State;
    @FXML
    private TextField Zip;
    @FXML
    private TextField BL;
    @FXML

    private TextField FOP;
    @FXML
    private TextField LDC;
    @FXML
    private TextField DC;

    private void SaveCustomer(TextField CN, TextField SA, TextField City, TextField State, TextField Zip, TextField BL, TextField FOP, TextField LDC, TextField DC) {
        String userHome = System.getProperty("user.home");
        String directoryPath = userHome + "/savedCustomer/";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        PrintWriter pw = null;
        System.out.println(CN.getText());
        try {
           File myfile = new File(userHome + "/savedCustomer/" + CN.getText());
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

    public void addCustomer(ActionEvent actionEvent) {
        SaveCustomer(CN, SA, City, State, Zip, BL, FOP, LDC, DC);
    }
}