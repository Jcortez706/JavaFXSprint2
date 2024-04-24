package org.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class AddOrder {
    public TextField accountID;
    public TextField deliveryDate;
    public TextField salesRepID;
    public TextField delvRepID;
    public TextField insertItem1;
    public TextField insertItem2;
    public TextField insertItem3;
    public TextField insertItem4;
    public TextField insertItem5;
    public TextField insertItem6;
    public TextField insertItem7;
    public TextField insertItem8;
    public TextField insertItem9;
    public TextField insertItem10;
    public TextField quantity1;
    public TextField quantity2;
    public TextField quantity3;
    public TextField quantity4;
    public TextField quantity5;
    public TextField quantity6;
    public TextField quantity7;
    public TextField quantity8;
    public TextField quantity9;
    public TextField quantity10;
    public Button placeOrderButton;

    public void saveOrder(TextField accountID,
                          TextField deliveryDate,
                          TextField salesRepID,
                          TextField delvRepID,
                          TextField insertItem1,
                          TextField insertItem2,
                          TextField insertItem3,
                          TextField insertItem4,
                          TextField insertItem5,
                          TextField insertItem6,
                          TextField insertItem7,
                          TextField insertItem8,
                          TextField insertItem9,
                          TextField insertItem10,
                          TextField quantity1,
                          TextField quantity2,
                          TextField quantity3,
                          TextField quantity4,
                          TextField quantity5,
                          TextField quantity6,
                          TextField quantity7,
                          TextField quantity8,
                          TextField quantity9,
                          TextField quantity10){
        String userHome = System.getProperty("user.home");
        String directoryPath = userHome + "/ACME/savedOrder";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        PrintWriter pw = null;
        try {
            File myfile = new File(userHome + "/ACME/savedOrder/" + accountID.getText());
            pw = new PrintWriter(myfile);
            pw.println(accountID.getText());
            pw.println(deliveryDate.getText());
            pw.println(salesRepID.getText());
            pw.println(delvRepID.getText());
            pw.println(insertItem1.getText()+ ":" + quantity1.getText());
            pw.println(insertItem2.getText()+ ":" + quantity2.getText());
            pw.println(insertItem3.getText()+ ":" + quantity3.getText());
            pw.println(insertItem4.getText()+ ":" + quantity4.getText());
            pw.println(insertItem5.getText()+ ":" + quantity5.getText());
            pw.println(insertItem6.getText()+ ":" + quantity6.getText());
            pw.println(insertItem7.getText()+ ":" + quantity7.getText());
            pw.println(insertItem8.getText()+ ":" + quantity8.getText());
            pw.println(insertItem9.getText()+ ":" + quantity9.getText());
            pw.println(insertItem10.getText()+ ":" + quantity10.getText());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if (pw != null) pw.close();
        }

    }


    public void addCustomer(ActionEvent actionEvent) throws IOException {

        saveOrder(
                accountID,
                deliveryDate,
                salesRepID,
                delvRepID,
                insertItem1,
                insertItem2,
                insertItem3,
                insertItem4,
                insertItem5,
                insertItem6,
                insertItem7,
                insertItem8,
                insertItem9,
                insertItem10,
                quantity1,
                quantity2,
                quantity3,
                quantity4,
                quantity5,
                quantity6,
                quantity7,
                quantity8,
                quantity9,
                quantity10

        );
        Stage stage = (Stage) placeOrderButton.getScene().getWindow();
        stage.close();
        Stage homeStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("order-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }
}
