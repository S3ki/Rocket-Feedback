package utils;

import Model.FeedBack;
import Model.Kurssi;

import java.util.List;

public class Tilastot {

    // Analysoi positiiviset ja negatiiviset palautteet
    public static void analysoiPalautteet(Kurssi kurssi) {
        List<FeedBack> palautteet = kurssi.getFeedbackList();
        int positiiviset = 0;
        int negatiiviset = 0;

        for (FeedBack palaute : palautteet) {
            String palauteTeksti = palaute.getFeedbackText().toLowerCase();
            if (palauteTeksti.contains("hyvä") || palauteTeksti.contains("kiitos")) {
                positiiviset++;
            } else if (palauteTeksti.contains("huono") || palauteTeksti.contains("valitus")) {
                negatiiviset++;
            }
        }

        System.out.println("Positiivisten palautteiden määrä: " + positiiviset);
        System.out.println("Negatiivisten palautteiden määrä: " + negatiiviset);
    }
}
