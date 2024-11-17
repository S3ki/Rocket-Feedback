package Gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.util.ResourceBundle;

public class SceneGui extends Application {

    @FXML
    Button loadKirjauduViewButton;
    @FXML
    Button loadOppilasViewButton;

    @FXML
    ComboBox<String> languageBox;

    static ResourceBundle bundle = ResourceBundle.getBundle("bundle_EN");
    FXMLLoader fxmlLoader;

    public static String languageCode;

    @Override
    public void start(Stage stage) throws Exception {
        fxmlLoader = new FXMLLoader(getClass().getResource("/design.fxml"));
        fxmlLoader.setResources(bundle);

        Parent root = fxmlLoader.load();

        stage.setTitle("RocketFeedback");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void loadKirjaudu() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kirjaudu.fxml"));
            loader.setResources(bundle);
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

    @FXML
    public void loadOpiskelija() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/oppilaskurssit.fxml"));
            loader.setResources(bundle);

            AnchorPane newView = loader.load();


            // Get the current stage and set the new scene
            Stage stage = (Stage) loadOppilasViewButton.getScene().getWindow();
            Scene scene = new Scene(newView);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLanguageChange() {
        String selectedLanguage = languageBox.getValue();

        switch (selectedLanguage) {
            case "English":
                bundle = ResourceBundle.getBundle("bundle_EN");
                languageCode = "EN";
                break;
            case "Suomi":
                bundle = ResourceBundle.getBundle("bundle_FI");
                languageCode = "FI";
                break;
            case "日本語":
                bundle = ResourceBundle.getBundle("bundle_JP");
                languageCode = "JP";
                break;
            case "عربي":
                bundle = ResourceBundle.getBundle("bundle_AR");
                languageCode = "AR";
                break;
            default:
                bundle = ResourceBundle.getBundle("bundle_EN");
        }

        try {
            // Create a new FXMLLoader instance
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/design.fxml"));
            loader.setResources(bundle);

            // Load the new FXML with the selected language
            Parent newRoot = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) languageBox.getScene().getWindow();
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
