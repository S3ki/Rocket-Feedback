package Gui;

import Model.FeedBack;
import Model.Kayttaja;
import Model.Kurssi;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class FeedbackAppGUI extends Application {

    Kurssi kurssi = new Kurssi("Ohjelmointi 101");
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
            String palaute = feedbackInput.getText();
            if (!palaute.isEmpty()) {
                kurssi.addFeedback(palaute, kayttaja.getNimi()); // Sisältää palautteen tekijän nimen
                feedbackInput.clear();
            }
        });

        Button viewFeedbacks = new Button("Näytä palautteet");
        viewFeedbacks.setOnAction(e -> showFeedbacks(primaryStage));

        Button answerFeedback = new Button("Vastaa palautteeseen");
        answerFeedback.setOnAction(e -> showAnswerFeedback(primaryStage));

        Button logoutButton = new Button("Kirjaudu ulos");
        logoutButton.setOnAction(e -> start(primaryStage));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(userLabel, feedbackInput, submitFeedback, viewFeedbacks, answerFeedback, logoutButton);

        // Näytetään vain opettajalle "Vastaa palautteeseen" -nappi
        if (kayttaja.getRooli().equals("opiskelija")) {
            layout.getChildren().remove(answerFeedback);
        }

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
    }

    private void showFeedbacks(Stage primaryStage) {
        VBox feedbackLayout = new VBox(10);

        List<FeedBack> feedbacks = kurssi.getFeedbackList();
        Label feedbackListLabel = new Label("Palautteet:");

        if (kayttaja.getRooli().equals("opettaja")) {
            for (int i = 0; i < feedbacks.size(); i++) {
                FeedBack fb = feedbacks.get(i);
                Label feedbackLabel = new Label((i + 1) + ". " + fb.toString());
                feedbackLayout.getChildren().add(feedbackLabel);
            }
        } else if (kayttaja.getRooli().equals("opiskelija")) {
            List<FeedBack> studentFeedbacks = kurssi.getStudentFeedback(kayttaja.getNimi());
            if (studentFeedbacks.isEmpty()) {
                feedbackListLabel.setText("Ei palautteita.");
            } else {
                for (int i = 0; i < studentFeedbacks.size(); i++) {
                    FeedBack fb = studentFeedbacks.get(i);
                    Label feedbackLabel = new Label((i + 1) + ". " + fb.toString());
                    feedbackLayout.getChildren().add(feedbackLabel);
                }
            }
        }

        Button backButton = new Button("Takaisin");
        backButton.setOnAction(e -> showMainMenu(primaryStage));

        feedbackLayout.getChildren().addAll(feedbackListLabel, backButton);
        Scene feedbackScene = new Scene(feedbackLayout, 400, 300);
        primaryStage.setScene(feedbackScene);
    }

    private void showAnswerFeedback(Stage primaryStage) {
        VBox answerLayout = new VBox(10);
        Label feedbackListLabel = new Label("Valitse palaute:");
        List<FeedBack> feedbacks = kurssi.getFeedbackList();
        VBox feedbackListLayout = new VBox(10);

        for (int i = 0; i < feedbacks.size(); i++) {
            FeedBack fb = feedbacks.get(i);
            Button feedbackButton = new Button("Palaute nro " + (i + 1) + ": " + fb.getFeedbackText());
            int finalI = i;
            feedbackButton.setOnAction(feedbackEvent -> {
                TextArea answerArea = new TextArea();
                answerArea.setPromptText("Kirjoita vastaus tähän...");
                Button submitAnswer = new Button("Lähetä vastaus");
                submitAnswer.setOnAction(answerEvent -> {
                    String vastaus = answerArea.getText();
                    kurssi.answerFeedback(finalI, vastaus);
                    showMainMenu(primaryStage); // Näytä päävalikko vastauksen jälkeen
                });
                answerLayout.getChildren().addAll(answerArea, submitAnswer);
            });
            feedbackListLayout.getChildren().add(feedbackButton);
        }

        answerLayout.getChildren().addAll(feedbackListLabel, feedbackListLayout);
        Scene answerScene = new Scene(answerLayout, 400, 300);
        primaryStage.setScene(answerScene);
    }
}
