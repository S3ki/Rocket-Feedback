package Model;

public class FeedBack {
    private String palaute;
    private String opiskelijaNimi;

    public FeedBack(String palaute, String opiskelijaNimi) {
        this.palaute = palaute;
        this.opiskelijaNimi = opiskelijaNimi;
    }

    public String getPalaute() { // Lisätty metodi
        return palaute;
    }

    @Override
    public String toString() {
        return "Opiskelija: " + opiskelijaNimi + "\nPalaute: " + palaute;
    }
}
