package Entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Feedback2")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Course_id")
    private int id;

    @Column(name="Comment")
    private String comment;

    @Column(name="language_code")
    private String langCode;

    @Column(name="SubmissionDate")
    private LocalDate date;





}
