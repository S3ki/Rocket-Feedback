package Gui;

import Model.Kayttaja;
import Model.Kurssi;
import Model.Opettaja;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FeedbackAppGUI extends Application {

    Kurssi kurssi = new Kurssi("Ohjelmointi 101");
    Opettaja opettaja = new Opettaja("Mr. Smith");
    Kayttaja kayttaja;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Palautejärjestelmä rooleilla");

        Label welcomeLabel = new Label("Tervetuloa, kirjaudu sisään");
        TextField nameInput = new TextField();
        nameInput.setPromptText("Syötä nimesi");

        TextField roleInput = new TextField();
        roleInput.setPromptText("Syötä roolisi (opiskelija/opettaja)");

        Button loginButton = new Button("Kirjaudu");
        loginButton.setOnAction(e -> {
            String nimi = nameInput.getText();
            String rooli = roleInput.getText();

            if (!nimi.isEmpty() && (rooli.equals("opiskelija") || rooli.equals("opettaja"))) {
                kayttaja = new Kayttaja(nimi, rooli);
                showMainMenu(primaryStage);
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(welcomeLabel, nameInput, roleInput, loginButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showMainMenu(Stage primaryStage) {
        Label userLabel = new Label("Kirjautunut: " + kayttaja.getNimi() + " (" + kayttaja.getRooli() + ")");
        TextArea feedbackInput = new TextArea();
        feedbackInput.setPromptText("Kirjoita palautteesi tähän...");

        Button submitFeedback = new Button("Lähetä palaute");
        submitFeedback.setOnAction(e -> {
            if (kayttaja.getRooli().equals("opiskelija")) {
                String palaute = feedbackInput.getText();
                if (!palaute.isEmpty()) {
                    kurssi.addFeedback(palaute);
                    feedbackInput.clear();
                }
            }
        });

        Button viewFeedbacks = new Button("Näytä palautteet");
        viewFeedbacks.setOnAction(e -> kurssi.printFeedback());

        Button answerFeedback = new Button("Vastaa palautteeseen");
        answerFeedback.setOnAction(e -> {
            if (kayttaja.getRooli().equals("opettaja")) {
                // Opettajan toiminto vastata palautteeseen
                kurssi.printFeedback();
                // Tässä voit lisätä toiminnallisuuden vastausten antamiseen
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(userLabel, feedbackInput, submitFeedback, viewFeedbacks);

        if (kayttaja.getRooli().equals("opettaja")) {
            layout.getChildren().add(answerFeedback);
        }

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

