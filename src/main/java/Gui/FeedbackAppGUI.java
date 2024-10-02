//package Gui;
//
//import Model.FeedBack;
//import Model.Kayttaja;
//import Model.Kurssi;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.util.*;
//
//public class FeedbackAppGUI extends Application {
//
//    private Map<String, String> opettajatunnukset = new HashMap<>();
//    private Kayttaja kayttaja;
//    private Kurssi valittuKurssi;
//    private Map<String, List<Kurssi>> opettajaKurssit = new HashMap<>();
//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Palautejärjestelmä rooleilla");
//        opettajatunnukset.put("opettaja", "salasana123");
//        showLoginOptions(primaryStage);
//    }
//
//    private void showLoginOptions(Stage primaryStage) {
//        Label welcomeLabel = new Label("Valitse rooli:");
//        Button opiskelijaButton = new Button("Opiskelija - Kirjaudu sisään ilman tunnuksia");
//        opiskelijaButton.setOnAction(e -> {
//            kayttaja = new Kayttaja("Opiskelija", "opiskelija");
//            selectCourse(primaryStage);
//        });
//
//        Button opettajaButton = new Button("Opettaja - Kirjaudu tunnuksilla");
//        opettajaButton.setOnAction(e -> showTeacherLogin(primaryStage));
//
//        VBox layout = new VBox(10);
//        layout.getChildren().addAll(welcomeLabel, opiskelijaButton, opettajaButton);
//        Scene scene = new Scene(layout, 400, 300);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private void showTeacherLogin(Stage primaryStage) {
//        Label loginLabel = new Label("Opettajan kirjautuminen");
//        TextField usernameInput = new TextField();
//        usernameInput.setPromptText("Käyttäjänimi");
//        PasswordField passwordInput = new PasswordField();
//        passwordInput.setPromptText("Salasana");
//
//        Button loginButton = new Button("Kirjaudu");
//        loginButton.setOnAction(e -> {
//            String username = usernameInput.getText();
//            String password = passwordInput.getText();
//
//            if (opettajatunnukset.containsKey(username) && opettajatunnukset.get(username).equals(password)) {
//                kayttaja = new Kayttaja(username, "opettaja");
//                selectTeacherAction(primaryStage);
//            } else {
//                showAlert("Virhe", "Kirjautuminen epäonnistui: Virheellinen käyttäjänimi tai salasana", Alert.AlertType.ERROR);
//            }
//        });
//
//        VBox layout = new VBox(10);
//        layout.getChildren().addAll(loginLabel, usernameInput, passwordInput, loginButton);
//        Scene scene = new Scene(layout, 400, 300);
//        primaryStage.setScene(scene);
//    }
//
//    private void selectTeacherAction(Stage primaryStage) {
//        Label actionLabel = new Label("Valitse toiminto:");
//        Button createCourseButton = new Button("Luo uusi kurssi");
//        Button viewCoursesButton = new Button("Näytä kurssit");
//        Button logoutButton = new Button("Kirjaudu ulos");
//
//        createCourseButton.setOnAction(e -> createCourse(primaryStage));
//        viewCoursesButton.setOnAction(e -> viewCourses(primaryStage));
//        logoutButton.setOnAction(e -> start(primaryStage));
//
//        VBox layout = new VBox(10);
//        layout.getChildren().addAll(actionLabel, createCourseButton, viewCoursesButton, logoutButton);
//        Scene scene = new Scene(layout, 400, 300);
//        primaryStage.setScene(scene);
//    }
//
//    private void createCourse(Stage primaryStage) {
//        TextInputDialog dialog = new TextInputDialog();
//        dialog.setTitle("Luo uusi kurssi");
//        dialog.setHeaderText("Syötä kurssin nimi:");
//        Optional<String> result = dialog.showAndWait();
//        result.ifPresent(courseName -> {
//            Kurssi newCourse = new Kurssi(courseName);
//            opettajaKurssit.computeIfAbsent(kayttaja.getNimi(), k -> new ArrayList<>()).add(newCourse);
//            showAlert("Onnistui", "Kurssi '" + courseName + "' luotu!", Alert.AlertType.INFORMATION);
//        });
//        selectTeacherAction(primaryStage);
//    }
//
//    private void viewCourses(Stage primaryStage) {
//        VBox courseLayout = new VBox(10);
//        List<Kurssi> courses = opettajaKurssit.getOrDefault(kayttaja.getNimi(), new ArrayList<>());
//        Label courseListLabel = new Label("Kurssit:");
//
//        if (courses.isEmpty()) {
//            courseListLabel.setText("Ei kursseja.");
//        } else {
//            for (Kurssi course : courses) {
//                Button feedbackButton = new Button(course.getNimi() + " - Näytä palautteet");
//                feedbackButton.setOnAction(e -> {
//                    valittuKurssi = course;
//                    showTeacherFeedbacks(primaryStage);
//                });
//
//                Button deleteButton = new Button("Poista kurssi");
//                deleteButton.setOnAction(e -> {
//                    opettajaKurssit.get(kayttaja.getNimi()).remove(course);
//                    showAlert("Onnistui", "Kurssi '" + course.getNimi() + "' poistettu!", Alert.AlertType.INFORMATION);
//                    viewCourses(primaryStage);
//                });
//
//                courseLayout.getChildren().addAll(feedbackButton, deleteButton);
//            }
//        }
//
//        Button backButton = new Button("Takaisin");
//        backButton.setOnAction(e -> selectTeacherAction(primaryStage));
//        courseLayout.getChildren().addAll(courseListLabel, backButton);
//        Scene courseScene = new Scene(courseLayout, 400, 300);
//        primaryStage.setScene(courseScene);
//    }
//
//    private void selectCourse(Stage primaryStage) {
//        VBox courseLayout = new VBox(10);
//        Label courseLabel = new Label("Valitse kurssi:");
//        List<Kurssi> allCourses = new ArrayList<>();
//        opettajaKurssit.values().forEach(allCourses::addAll);
//
//        if (allCourses.isEmpty()) {
//            courseLabel.setText("Ei kursseja saatavilla.");
//        } else {
//            for (Kurssi course : allCourses) {
//                Button courseButton = new Button(course.getNimi());
//                courseButton.setOnAction(e -> {
//                    valittuKurssi = course;
//                    showMainMenu(primaryStage);
//                });
//                courseLayout.getChildren().add(courseButton);
//            }
//        }
//
//        Button backButton = new Button("Takaisin");
//        backButton.setOnAction(e -> showLoginOptions(primaryStage));
//        courseLayout.getChildren().addAll(courseLabel, backButton);
//        Scene courseScene = new Scene(courseLayout, 400, 300);
//        primaryStage.setScene(courseScene);
//    }
//
//    private void showMainMenu(Stage primaryStage) {
//        Label userLabel = new Label("Kirjautunut: " + kayttaja.getNimi() + " (" + kayttaja.getRooli() + ")");
//        TextArea feedbackInput = new TextArea();
//        feedbackInput.setPromptText("Kirjoita palautteesi tähän...");
//
//        Button submitFeedback = new Button("Lähetä palaute");
//        submitFeedback.setOnAction(e -> {
//            if (valittuKurssi == null) {
//                showAlert("Virhe", "Et ole valinnut kurssia.", Alert.AlertType.ERROR);
//                return;
//            }
//
//            String palaute = feedbackInput.getText();
//            if (!palaute.isEmpty()) {
//                valittuKurssi.addFeedback(palaute, kayttaja.getNimi());
//                feedbackInput.clear();
//                showAlert("Onnistui", "Palaute lähetetty!", Alert.AlertType.INFORMATION);
//            } else {
//                showAlert("Virhe", "Palauteteksti ei voi olla tyhjä.", Alert.AlertType.ERROR);
//            }
//        });
//
//        Button viewFeedbacks = new Button("Näytä palautteet");
//        viewFeedbacks.setOnAction(e -> {
//            if (valittuKurssi == null) {
//                showAlert("Virhe", "Et ole valinnut kurssia.", Alert.AlertType.ERROR);
//                return;
//            }
//            showFeedbacks(primaryStage);
//        });
//
//        Button logoutButton = new Button("Kirjaudu ulos");
//        logoutButton.setOnAction(e -> start(primaryStage));
//
//        VBox layout = new VBox(10);
//        layout.getChildren().addAll(userLabel, feedbackInput, submitFeedback, viewFeedbacks, logoutButton);
//        Scene scene = new Scene(layout, 400, 300);
//        primaryStage.setScene(scene);
//    }
//
//    private void showFeedbacks(Stage primaryStage) {
//        VBox feedbackLayout = new VBox(10);
//        List<FeedBack> feedbacks = valittuKurssi.getFeedbackList();
//        Label feedbackListLabel = new Label("Palautteet:");
//
//        if (feedbacks.isEmpty()) {
//            feedbackListLabel.setText("Ei palautteita.");
//        } else {
//            for (int i = 0; i < feedbacks.size(); i++) {
//                FeedBack fb = feedbacks.get(i);
//                Label feedbackLabel = new Label((i + 1) + ". " + fb.toString());
//                feedbackLayout.getChildren().add(feedbackLabel);
//            }
//        }
//
//        Button backButton = new Button("Takaisin");
//        backButton.setOnAction(e -> showMainMenu(primaryStage));
//        feedbackLayout.getChildren().addAll(feedbackListLabel, backButton);
//        Scene feedbackScene = new Scene(feedbackLayout, 400, 300);
//        primaryStage.setScene(feedbackScene);
//    }
//
//    private void showTeacherFeedbacks(Stage primaryStage) {
//        VBox feedbackLayout = new VBox(10);
//        List<FeedBack> feedbacks = valittuKurssi.getFeedbackList();
//        Label feedbackListLabel = new Label("Palautteet:");
//
//        if (feedbacks.isEmpty()) {
//            feedbackListLabel.setText("Ei palautteita.");
//        } else {
//            for (int i = 0; i < feedbacks.size(); i++) {
//                FeedBack fb = feedbacks.get(i);
//                Label feedbackLabel = new Label((i + 1) + ". " + fb.toString());
//                feedbackLayout.getChildren().add(feedbackLabel);
//
//                int feedbackIndex = i; // Välimuuttuja
//                Button respondButton = new Button("Vastaa");
//                respondButton.setOnAction(e -> respondToFeedback(primaryStage, feedbackIndex));
//                feedbackLayout.getChildren().add(respondButton);
//            }
//        }
//
//        Button backButton = new Button("Takaisin");
//        backButton.setOnAction(e -> selectTeacherAction(primaryStage));
//        feedbackLayout.getChildren().addAll(feedbackListLabel, backButton);
//        Scene feedbackScene = new Scene(feedbackLayout, 400, 300);
//        primaryStage.setScene(feedbackScene);
//    }
//
//    private void respondToFeedback(Stage primaryStage, int feedbackIndex) {
//        // Implementoi palautteeseen vastaaminen
//        showAlert("Vastaaminen", "Vastaa palautteeseen, index: " + feedbackIndex, Alert.AlertType.INFORMATION);
//    }
//
//    private void showAlert(String title, String content, Alert.AlertType type) {
//        Alert alert = new Alert(type);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(content);
//        alert.showAndWait();
//    }
//}
