package Model;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Kurssi {
    private String nimi;
    private List<FeedBack> feedbackList;

    public Kurssi(String nimi) {
        this.nimi = nimi;
        this.feedbackList = new ArrayList<>();
    }

    public void addFeedback(String palaute) {
        feedbackList.add(new FeedBack(palaute));
    }
    public List<FeedBack> getFeedbackList() {
        return feedbackList;
    }

    public String getNimi() {
        return nimi;
    }

    public void printFeedback() { // Lisätty metodi
        if (feedbackList.isEmpty()) {
            System.out.println("Ei palautteita.");
        } else {
            for (int i = 0; i < feedbackList.size(); i++) {
                FeedBack fb = feedbackList.get(i);
                System.out.println((i + 1) + ". " + fb.toString());
            }
        }
    }

    public void removeFeedback(int i) {
    }
}
