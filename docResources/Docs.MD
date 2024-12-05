## Table of Contents

- [Usage](#Usage)
- [Technologies](#Technologies)
- [Contributing](#Contributing)
- [Testing](#Testing)
- [Project_Structure](#Project_Structure)
- [ER-Diagram](#ER-Diagram)
- [Relational_Schema](#Relational_Schema)
- [Activity_Model](#Activity_Model)
- [Use_Case_Model](#Use_Case_Model)
- [Database_Structure](#Database_Structure)


## Usage

### Scenario 1. Student client
#### In the case of a client that is a student leaving a feedback:
- Open the application
- Students don't need to create a separate user they can just log in 
- Once logged, the user will be given a window where to choose a courses
- Then the user will choose the desired course
- The course feedback window will open
- The user will write their feedback and submit it
- Now the feedback will show on the teachers feedback feed

## Technologies

- Java: a programming language
- JavaFX: a software platform used to build rich client applications that run on desktop, mobile, and embedded systems
- MariaDB: one of the most popular open source relational databases
- Scene builder: a visual layout tool for designing user interfaces (UIs) in JavaFX
- JUnit: a popular unit testing framework for Java applications
- JaCoCo: (Java Code Coverage) is a popular code coverage library for Java projects
- Maven: a software project management and comprehension tool

## Contributing

#### If you would like to contribute to Rocket feedback here are the steps to do so:
1. Fork the repository
2. Create a new branch `(git checkout -b feature/your-feature)`
3. Make your changes
4. Commit your changes `(git commit -am 'Add some feature')`
5. Push to the branch `(git push origin feature/your-feature)`
6. Create a new Pull Request

## Testing

#### To run tests navigate to your directory and run the following command:
```bash
mvn test
```
## Project_Structure

1. Backend:
   - src/main/java/Dao/
       - `OpettajaDao.java` Handles database operations related to "Opettaja".
   - src/main/java/Datasource/
       - `MariaDbJpaConnection.java` Manages the connection to the MariaDB database using JPA.
       - `DatabaseStructure.java` Defines the structure and schema of the database.
   - src/main/java/Entity/
      - `Feedback.java` Represents the feedback entity (data model).
      - `Kurssi.java` Represents the course entity.
      - `Opettaja.java` Represents the teacher entity.
   - src/main/java/Model/
      - `FeedBack.java` Core model for feedback functionality.
      - `Kurssi.java` Model for course data.
      - `Opettaja.java` Model for teacher data.
   - src/main/java/main2/
      - `OpettajanToiminnot.java` Backend logic for teacher functionalities.
      - `OppilasToiminnot.java` Backend logic for student functionalities.

2. Frontend
   - src/main/java/Gui/
      - `FeedbackAppGUI.java` Main class that handles the graphical user interface (GUI) of the application.
   - src/main/resources/
      - FXML Files (for defining GUI layouts):
           - `design.fxml` General design for the application's UI.
           - `kirjaudu.fxml` Layout for the login screen.
           - `opettajanToiminnot.fxml` Layout for teacher operations.
           - `oppilaskurssit.fxml` Layout for student courses.
           - `oppilaspalaute.fxml` Layout for student feedback.
           - `palaute.fxml` Layout for feedback submission.
           - `palautusjärjestelmä.fxml` Layout for the feedback system.
           - `saapuneetpalautteet.fxml` Layout for viewing received feedback.
      - Other Resources:
           - `style.css` Stylesheet for the application's UI, managing the visual design.
           - `logback.xml` Configuration file for logging.
   - src/main/java/SceneGui/
        - Manages transitions between different GUI scenes

3. .gitignore
   - Specifies files and directories to be excluded from version control. 

## ER-Diagram

![picture of ER-Diagram](/Er-malli.png)

## Relational_Schema

![picture of relational schema](/Relaatiomalli.png)


## Activity_Model

![picture of activity model](/Activity.png)

## Use_Case_Model

![picture of Use Case Model](/Usecasemalli.png)

## Database_Structure

[Click here to see the database structure](src/main/java/Datasource/DatabaseStructure.txt)






