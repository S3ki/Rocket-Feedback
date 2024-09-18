package utils;

import Model.Kurssi;

import java.util.List;

public class Tilastot {

    // Analysoi positiiviset ja negatiiviset palautteet
    public static void analysoiPalautteet(Kurssi kurssi) {
        List<String> palautteet = kurssi.getFeedbackList();
        int positiiviset = 0;
        int negatiiviset = 0;

        for (String palaute : palautteet) {
            if (palaute.toLowerCase().contains("hyvä") || palaute.toLowerCase().contains("kiitos")) {
                positiiviset++;
            } else if (palaute.toLowerCase().contains("huono") || palaute.toLowerCase().contains("valitus")) {
                negatiiviset++;
            }
        }

        System.out.println("Positiivisten palautteiden määrä: " + positiiviset);
        System.out.println("Negatiivisten palautteiden määrä: " + negatiiviset);
    }
}

