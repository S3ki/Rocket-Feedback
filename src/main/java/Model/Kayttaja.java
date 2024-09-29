package Model;

public class Kayttaja {
    private String nimi;
    private String rooli; // "opettaja" tai "opiskelija"

    public Kayttaja(String nimi, String rooli) {
        this.nimi = nimi;
        this.rooli = rooli;

    }

    public String getNimi() {
        return nimi;
    }

    public String getRooli() {
        return rooli;
    }
}
