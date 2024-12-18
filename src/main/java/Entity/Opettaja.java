package Entity;

import jakarta.persistence.*;

@Entity

@Table(name="Teacher")
public class Opettaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teacher_id")
    private int id;

    @Column(name="first_Name")
    private String firstName;

    @Column(name="last_Name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="language_code")
    private String langCode;



    public Opettaja() {
    }

    public Opettaja(String firstName, String lastName, String email, String langCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.langCode = langCode;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getLangCode() {
        return langCode;
    }
}
