package Model;

public class FeedBack {
    private String feedbackText;
    private String opettajanVastaus; // Uusi kenttä vastaukselle

    // Konstruktori
    public FeedBack(String feedbackText) {
        this.feedbackText = feedbackText;
        this.opettajanVastaus = ""; // Alustetaan tyhjäksi
    }

    // Getter palautteen tekstille
    public String getFeedbackText() {
        return feedbackText;
    }

    // Setter palautteen tekstille
    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    // Getter opettajan vastaukselle
    public String getOpettajanVastaus() {
        return opettajanVastaus;
    }

    // Setter opettajan vastaukselle
    public void setOpettajanVastaus(String opettajanVastaus) {
        this.opettajanVastaus = opettajanVastaus;
    }

    // Tulostetaan palaute ja vastaus
    @Override
    public String toString() {
        return "Palaute: " + feedbackText + "\nOpettajan vastaus: " + opettajanVastaus;
    }
}
