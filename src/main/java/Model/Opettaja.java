package Model;

import java.util.HashMap;
import java.util.Map;

public class Opettaja {
    private String nimi;
    private String sposti;
    private String salasana;

    private Map<String, Kurssi> opettajanKurssit;
//    private Map<Integer, String> palautteenVastaukset;

    public Opettaja(String nimi) {
        this.nimi = nimi;
        this.opettajanKurssit = new HashMap<>();
    }
    public void addOpettajalleKurssi(String nimi, Kurssi kurssi) {
        opettajanKurssit.put(nimi, kurssi);
    }

    // Palautteen tarkistaminen
//    public void tarkistaPalautteet(Kurssi kurssi) {
//        System.out.println("Model.Opettaja: " + nimi + " tarkistaa palautteet kurssilta: " + kurssi.getNimi());
//        kurssi.printFeedback();
//    }

//    // Vastaa palautteeseen
//    public void vastaaPalautteeseen(Kurssi kurssi, int palauteIndeksi, String vastaus) {
//        // Tarkistetaan, onko indeksi validi
//        if (palauteIndeksi > 0 && palauteIndeksi <= kurssi.getFeedbackList().size()) {
//            palautteenVastaukset.put(palauteIndeksi, vastaus);
//            System.out.println("Vastaus lisätty palautteeseen " + palauteIndeksi + ": " + vastaus);
//        } else {
//            System.out.println("Virhe: Indeksi ei kelpaa.");
//        }
//    }

    // Näytä kaikki vastimen
    public String getNimi() {
        return nimi;
    }
}