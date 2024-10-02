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


    // Kurssit sivut
    @FXML
    private Button takaisinButton;

    @FXML
    VBox nappiVbox;
    @FXML
    Button refreshSivuButton;
    @FXML
    Button kurssitLoadButton;

    @FXML
    Button lahetaPalauteButton;


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
                loadOikeaKurssi(kurssiButton);
            });

            nappiVbox.getChildren().add(kurssiButton);
        }
    }

    void loadOikeaKurssi(Button sourceButton) {
        loadNextScene("/oppilaspalaute.fxml", sourceButton);
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
