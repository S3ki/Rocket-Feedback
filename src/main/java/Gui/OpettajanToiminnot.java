package Gui;

import Model.Kurssi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class OpettajanToiminnot {

    //Kirjautumissivu
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    //Opettajan sivut
    @FXML
    private Button logOutButton;
    @FXML
    private Button luoKurssiButton;

    //Opettajant toimintosivu
    @FXML
    private Button kurssitButton;
    @FXML
    private Button takaisinButton;

    @FXML
    private AnchorPane opettajanToimminotPane;
    @FXML
    private Button loadkurssitbutton;

    static ArrayList<Kurssi> kurssit = new ArrayList<>();



    @FXML
    void takaisin() {
        loadNextScene("/opettajantoiminnot.fxml", takaisinButton);
    }

    public void showKurssit() {
        loadNextScene("/palautusjärjestelmä.fxml", kurssitButton );
    }


    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Simple login validation
        if (username.equals("admin") && password.equals("password")) {
            loadNextScene("/opettajanToiminnot.fxml", loginButton);
        } else {
            showAlert("Login Failed", "Invalid username or password.");
        }
    }

    public void handleLogOut() {
        loadNextScene("/design.fxml", logOutButton);
    }

    @FXML
    public void showModal() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Luo uusi kurssi");
        dialog.setHeaderText("Syötä kurssin nimi:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(courseName -> {
            Kurssi newCourse = new Kurssi(courseName);
            kurssit.add(newCourse);
            System.out.println("Kurssi luotu: " + newCourse.getNimi());
            System.out.println("Kurssien määrä: " + kurssit.size());
            showAlert("Onnistui", "Kurssi luotu! " + newCourse.getNimi());
        });
    }


    void loadKurssitOpettajalle(){
        for (Kurssi kurssi : kurssit) {
            Button kurssiButton = new Button(kurssi.getNimi());
            Button delete = new Button("Poista");
            kurssiButton.setOnAction(event -> handleButtonClick(kurssi));
            delete.setOnAction(event -> {
                kurssit.remove(kurssi);
                System.out.println("Kurssi poistettu: " + kurssi.getNimi());
            });
            opettajanToimminotPane.getChildren().add(kurssiButton);
            opettajanToimminotPane.getChildren().add(delete);
        }
    }
    private void handleButtonClick(Kurssi kurssi) {
        System.out.println("Button clicked: " + kurssi.getNimi());
    }

    @FXML
    void loadthem(){
        loadKurssitOpettajalle();
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
