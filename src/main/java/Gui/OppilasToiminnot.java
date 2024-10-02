package Gui;

import Model.Kurssi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class OppilasToiminnot {


    @FXML
    private Button takaisinButton;

    @FXML
    VBox nappiVbox;
    @FXML
    Button refreshSivuButton;
    @FXML
    Button kurssitLoadButton;

    @FXML
    void seeKurssit() {
        loadNextScene("/luoKurssi.fxml", takaisinButton);
    }
    @FXML
    void takaisin() {
        loadNextScene("/design.fxml", takaisinButton);
    }

    @FXML
    void loadKurssitOpiskelija(){
        for (Kurssi kurssi : OpettajanToiminnot.kurssit) {
            Button kurssiButton = new Button(kurssi.getNimi());
            kurssiButton.setOnAction(event -> {
                System.out.println("Kurssi valittu: " + kurssi.getNimi());
            });

            nappiVbox.getChildren().add(kurssiButton);
        }
    }

    private void loadNextScene(String fxmlFile, Button sourceButton) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            AnchorPane nextView = loader.load();

            Stage stage = (Stage) sourceButton.getScene().getWindow();

            Scene scene = new Scene(nextView);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load the next scene.");
        }

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
