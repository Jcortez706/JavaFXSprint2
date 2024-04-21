package org.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * The HelloApplication class represents the main entry point of the application.
 * It extends the JavaFX Application class and overrides the start method to initialize
 * and display the primary stage.
 */
public class HelloApplication extends Application {

    /**
     * The start method is called when the application is launched.
     * It loads the login-view.fxml file using FXMLLoader and sets up the primary stage.
     *
     * @param stage The primary stage of the application
     * @throws IOException If an error occurs while loading the FXML file
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(
                fxmlLoader.load());
        stage.setTitle("ACME");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method is the entry point of the Java application.
     * It launches the JavaFX application by calling the launch method.
     *
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        launch();
    }
}