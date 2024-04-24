package org.example.demo2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

@FXML
    public ListView<String> orderListView;
    String currentOrder;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String userHome = System.getProperty("user.home");

        File directory = new File(userHome + "/ACME/savedOrder");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File[] files = directory.listFiles();
        assert files != null;
        List<String> order = new ArrayList<>() {
        };
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

}
