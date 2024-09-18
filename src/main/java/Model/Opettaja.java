package Model;

import java.util.HashMap;
import java.util.Map;

public class Opettaja {
    private String nimi;

    // Mappi, joka tallentaa palautteen ja opettajan vastauksen.
    private Map<Integer, String> palautteenVastaukset;

    // Konstruktori
    public Opettaja(String nimi) {
        this.nimi = nimi;
        this.palautteenVastaukset = new HashMap<>();
    }

    // Palautteen tarkistaminen
    public void tarkistaPalautteet(Kurssi kurssi) {
        System.out.println("Model.Opettaja: " + nimi + " tarkistaa palautteet kurssilta: " + kurssi.getNimi());
        kurssi.printFeedback();
    }

    // Vastaa palautteeseen
    public void vastaaPalautteeseen(Kurssi kurssi, int palauteIndeksi, String vastaus) {
        // Tarkistetaan, onko indeksi validi
        if (palauteIndeksi > 0 && palauteIndeksi <= kurssi.getFeedbackList().size()) {
            palautteenVastaukset.put(palauteIndeksi, vastaus);
            System.out.println("Vastaus lisätty palautteeseen " + palauteIndeksi + ": " + vastaus);
        } else {
            System.out.println("Virhe: Indeksi ei kelpaa.");
        }
    }

    // Näytä kaikki vastaukset
    public void naytaVastaukset() {
        if (palautteenVastaukset.isEmpty()) {
            System.out.println("Ei vastauksia palautteisiin.");
        } else {
            System.out.println("Opettajan vastaukset:");
            for (Map.Entry<Integer, String> entry : palautteenVastaukset.entrySet()) {
                System.out.println("Palaute nro " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // Palauttaa opettajan nimen
    public String getNimi() {
        return nimi;
    }
}
