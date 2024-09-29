package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kurssi {
    private String nimi;
    private Map<Opettaja, Kurssi> opettajanKurssit = new HashMap<>();

    private List<FeedBack> feedbackList = new ArrayList<>();
    public Kurssi(String nimi, Opettaja opettaja) {
        this.nimi = nimi;
        this.opettajanKurssit.put(opettaja, this);
    }


    public List<FeedBack> getFeedbackList() {
        return feedbackList;
    }
    public void addFeedback(String palaute, String opiskelijaNimi) {
        FeedBack feedback = new FeedBack(palaute, opiskelijaNimi);
        feedbackList.add(feedback);
    }

    public void addFeedback(FeedBack feedback) {
        feedbackList.add(feedback);
    }

    public Map<Opettaja, Kurssi> getOpettajanKurssit() {
        return opettajanKurssit;
    }
    public String getNimi() {
        return nimi;
    }



}
