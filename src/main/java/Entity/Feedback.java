package Entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Feedback2")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="feedback_id")
    private int id;

    @Column(name="Comment")
    private String comment;

    @Column(name="language_code")
    private String langCode;

    @Column(name="SubmissionDate")
    private LocalDate date;


    public Feedback(String comment, String langCode){
        this.comment = comment;
        this.langCode = langCode;
        date = LocalDate.now();
    }


    public Feedback() {

    }

    public String getLangCode() {
        return langCode;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
