package Gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

//    @FXML
//    public void initialize() {
//        usernameField.setOnAction(event -> handleLogin());
//
//        passwordField.setOnAction(event -> handleLogin());
//    }

    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Simple login validation
        if (username.equals("admin") && password.equals("password")) {
            showAlert("Login Success", "Welcome, " + username + "!");
            loadNextScene();
        } else {
            showAlert("Login Failed", "Invalid username or password.");
        }
    }


    private void loadNextScene() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/opettajanToiminnot.fxml"));
            AnchorPane nextView = loader.load();

            Stage stage = (Stage) usernameField.getScene().getWindow();

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
