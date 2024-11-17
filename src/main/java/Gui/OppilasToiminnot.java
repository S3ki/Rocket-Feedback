package Gui;

import Model.Kurssi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

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

    // Lähettää palaute sivu
    @FXML
    Button lahetaPalauteButton;
    @FXML
    Button takaisinLahetaPalauteButton;
    @FXML
    TextArea palauteTextArea;

    @FXML
    void seeKurssit() {
        loadNextScene("/oppilaskurssit.fxml", takaisinButton);
    }
    @FXML
    void takaisin() {
        loadNextScene("/design.fxml", takaisinButton);
    }
    @FXML
    void takaisinP(){
        loadNextScene("/oppilaskurssit.fxml", takaisinLahetaPalauteButton);
    }
    @FXML
    void takaisinLahetaPalaute() {
        loadNextScene("/design.fxml", takaisinLahetaPalauteButton);
    }

    public static Kurssi asetaKurssi;
    @FXML
    void setLahetaPalauteButton(){
        if (palauteTextArea.getText().isEmpty()) {
            showAlert("Error", "Palaute ei voi olla tyhjä.");
            return;
        } else {
            String palaute = palauteTextArea.getText();
            asetaKurssi.addFeedback(palaute);
            System.out.println("Palaute lähetetty kurssiin: " + asetaKurssi.getNimi() + " Palaute: " + palaute);
        }
    }



    @FXML
    void loadKurssitOpiskelija(){
        for (Kurssi kurssi : OpettajanToiminnot.kurssit) {
            Button kurssiButton = new Button(kurssi.getNimi());
            kurssiButton.setOnAction(event -> {
                loadOikeaKurssi(kurssiButton);
                asetaKurssi = kurssi;
            });
            nappiVbox.setSpacing(10);
            nappiVbox.getChildren().add(kurssiButton);
        }
    }

    void loadOikeaKurssi(Button sourceButton) {
        loadNextScene("/oppilaspalaute.fxml", sourceButton);
    }

    private void loadNextScene(String fxmlFile, Button sourceButton) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            loader.setResources(SceneGui.bundle);
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
