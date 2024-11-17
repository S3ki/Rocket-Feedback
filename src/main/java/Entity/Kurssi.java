package Entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

@Table(name="CourseFeedback2")
public class Kurssi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Course_id")
    private int id;

    @Column(name="Date")
    private LocalDate date;

    @Column(name="language_code")
    private String langCode;

    @Column(name="name")
    private String name;

    public Kurssi ( String langCode, String name){
        date = LocalDate.now();
        this.langCode = langCode;
        this.name = name;
    }

    public Kurssi() {

    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
