package Model;

import java.util.ArrayList;
import java.util.List;

public class Kurssi {
    private String nimi;

    // Lista palautteista
    private List<String> feedbackList;

    // Kurssin konstruktori
    public Kurssi(String nimi) {
        this.nimi = nimi;
        this.feedbackList = new ArrayList<>();
    }

    // Lisää palautetta
    public void addFeedback(String feedback) {
        this.feedbackList.add(feedback);
        System.out.println("Palaute lisätty: " + feedback);
    }

    // Poista palaute indeksin mukaan
    public void removeFeedback(int index) {
        if (index >= 0 && index < feedbackList.size()) {
            String removedFeedback = feedbackList.remove(index);
            System.out.println("Palautetta poistettu: " + removedFeedback);
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
    public List<String> getFeedbackList() {
        return feedbackList;
    }

    // Palautetaan kurssin nimi
    public String getNimi() {
        return nimi;
    }
}
