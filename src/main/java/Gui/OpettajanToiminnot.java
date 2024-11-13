package Gui;

import Model.FeedBack;
import Model.Kurssi;
import Model.Opettaja;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
    @FXML
    private Button takaisinEtuButton;

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

    //Opettajan kurssit
    @FXML
    private AnchorPane opettajanToimminotPane;
    @FXML
    private Button loadkurssitbutton;
    @FXML Button refreshSivuButton;
    @FXML
    private VBox nappiVbox;

    // Oppilaiden palautteet sivut
    @FXML
    VBox palauteTextArea;
    @FXML
    Button lataaaPalautteetButton;
    @FXML
    Button takaisinPalautteistaButton;

    public static ArrayList<Kurssi> kurssit = new ArrayList<>();

    static Kurssi asetaOikeaKurssi;
    Opettaja opettaja = new Opettaja("Tero");

    @FXML
    void takaisin() {
        loadNextScene("/opettajantoiminnot.fxml", takaisinButton);
    }
    @FXML
    void takaisinP() {
        loadNextScene("/palautusjärjestelmä.fxml", takaisinPalautteistaButton);
    }

    // Lataa opettajan kurssit
    @FXML
    public void showKurssit() {
        loadNextScene("/palautusjärjestelmä.fxml", kurssitButton );
    }

    @FXML
    public void refreshKurssit() {
        loadNextScene("/palautusjärjestelmä.fxml", loadkurssitbutton);
    }

    void loadOikeaKurssi(Button sourceButton) {
        loadNextScene("/palaute.fxml", sourceButton);
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
    public void handleTakaisin() {
        loadNextScene("/design.fxml", takaisinEtuButton);
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
            opettaja.addOpettajalleKurssi(courseName, newCourse);
            System.out.println("Kurssi luotu: " + newCourse.getNimi());
            System.out.println("Kurssien määrä: " + kurssit.size());
            showAlert("Onnistui", "Kurssi luotu! " + newCourse.getNimi());
        });
    }


    void loadKurssitOpettajalle(){
        Kurssi kurssi1 = new Kurssi("Biologia");
        Kurssi kurssi2 = new Kurssi("Historia");
        kurssit.add(kurssi1);
        kurssit.add(kurssi2);
        nappiVbox.setSpacing(10);
        for (Kurssi kurssi : kurssit) {
            Button kurssiButton = new Button(kurssi.getNimi());
            Button delete = new Button("Poista");
            kurssiButton.setOnAction(event -> {
                loadOikeaKurssi(kurssiButton);
                asetaOikeaKurssi = kurssi;
            });
            delete.setOnAction(event -> {
                kurssit.remove(kurssi);
                System.out.println("Kurssi poistettu: " + kurssi.getNimi());
            });

            HBox buttonGroup = new HBox(5); // Set spacing between the buttons in the group
            buttonGroup.getChildren().addAll(kurssiButton, delete);

            // Add the HBox to the VBox
            nappiVbox.getChildren().add(buttonGroup);

//            nappiVbox.getChildren().add(kurssiButton);
//            nappiVbox.getChildren().add(delete);
        }
    }
    private void handleButtonClick(Kurssi kurssi) {
        System.out.println("Button clicked: " + kurssi.getNimi());
    }

    @FXML
    void loadthem(){
        loadKurssitOpettajalle();
    }
    @FXML
    void loadPalautteetOppilailta(){
        for (FeedBack feedback : asetaOikeaKurssi.getFeedbackList()) {
            Text feedbackText = new Text();
            feedbackText.setText(feedback.getPalaute());
            palauteTextArea.getChildren().add(feedbackText);
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
