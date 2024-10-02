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


}
