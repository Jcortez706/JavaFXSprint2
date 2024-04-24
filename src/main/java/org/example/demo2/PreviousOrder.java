package org.example.demo2;

import javafx.scene.control.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PreviousOrder {

    /** ListView to display previous orders. */
    public ListView previousListView;

    /**
     * Reads the contents of the given file and populates the ListView with the order information.
     *
     * @param file The file containing the order information
     */
    public void readFile(File file) {
        BufferedReader reader;
        List<String> orderInfo = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                orderInfo.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            previousListView.getItems().addAll(orderInfo);
        }
    }
}