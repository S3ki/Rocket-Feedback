package Model;

import java.util.ArrayList;
import java.util.List;

public class Kurssi {
    private String nimi;

    // Lista palautteista
    private List<FeedBack> feedbackList;

    // Kurssin konstruktori
    public Kurssi(String nimi) {
        this.nimi = nimi;
        this.feedbackList = new ArrayList<>();
    }

    // Lisää palautetta
    public void addFeedback(String feedbackText, String opiskelijanNimi) {
        FeedBack feedback = new FeedBack(feedbackText);
        feedbackList.add(feedback);
        System.out.println("Palaute lisätty: " + feedbackText);
    }

    // Poista palaute indeksin mukaan
    public void removeFeedback(int index) {
        if (index >= 0 && index < feedbackList.size()) {
            FeedBack removedFeedback = feedbackList.remove(index);
            System.out.println("Palautetta poistettu: " + removedFeedback.getFeedbackText());
        } else {
            System.out.println("Virhe: Indeksi ei kelpaa.");
        }
    }

    // Vastaa palautteeseen
    public void answerFeedback(int index, String vastaus) {
        if (index >= 0 && index < feedbackList.size()) {
            FeedBack feedback = feedbackList.get(index);
            feedback.setOpettajanVastaus(vastaus);
            System.out.println("Vastaus lisätty palautteeseen " + (index + 1) + ": " + vastaus);
        } else {
            System.out.println("Virhe: Indeksi ei kelpaa.");
        }
    }

    // Tulostetaan kaikki palautteet
    public void printFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("Ei palautetta.");
        } else {
            System.out.println("Palaute kurssille " + nimi + ":");
            for (int i = 0; i < feedbackList.size(); i++) {
                System.out.println((i + 1) + ". " + feedbackList.get(i));
            }
        }
    }

    // Getter palautteiden listalle
    public List<FeedBack> getFeedbackList() {
        return feedbackList;
    }

    // Palautetaan kurssin nimi
    public String getNimi() {
        return nimi;
    }

    // Haetaan opiskelijan palautteet
    public List<FeedBack> getStudentFeedback(String opiskelijanNimi) {
        List<FeedBack> studentFeedbacks = new ArrayList<>();
        for (FeedBack feedback : feedbackList) {
            // Oletetaan, että palaute on yhdistetty opiskelijan nimeen
            // Tarvitaan myös, että opiskelijan nimi olisi tallennettuna palautteessa
            // Muutetaan tämä, jos opiskelijan nimi on osa palautetta
            studentFeedbacks.add(feedback);
        }
        return studentFeedbacks;
    }
}
