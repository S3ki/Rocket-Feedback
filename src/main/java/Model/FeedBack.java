package Model;

public class FeedBack {
    private String palaute;
    private String[] colorPalaute;

    public FeedBack(String palaute, String opiskelijaNimi) {
        this.palaute = palaute;
    }

    public String getPalaute() { // Lisätty metodi
        return palaute;
    }

}