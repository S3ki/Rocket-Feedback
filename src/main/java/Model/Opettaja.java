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


    // Näytä kaikki vastimen
    public String getNimi() {
        return nimi;
    }

}