package Gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;

public class SceneGui extends Application {

    @FXML
    Button loadKirjauduViewButton;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/design.fxml"));
        Parent root = fxmlLoader.load();

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void loadKirjaudu() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kirjaudu.fxml"));
            AnchorPane newView = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) loadKirjauduViewButton.getScene().getWindow();
            Scene scene = new Scene(newView);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
