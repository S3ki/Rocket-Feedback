# Rocket Feedback application

#### This project has been built with JavaFX and uses Java as its programming language. 

### Vision:
##### This project is to produce an application where students can fill out a survey/feedback form. The project is made for university students to communicate their feedback and concerns to teachers. After each lesson the students will fill out a form about the lesson and send it to their course teacher.

### Problem statement:
##### Users in our target demographic, in this case meaning students, often struggle with voicing their opinions about lectures and courses. Whether these issues are about the learnt subject, teaching style or just a suggestion for improvement etc. students would greatly benefit from having a safe anonymous avenue where to express their concerns and opinions.

### Benefit:
##### Our goal is to bridge the gap between students and teachers when it comes to communication. We  want to create a low threshold for students to communicate with their teachers in order to make the learning experience more positive and rewarding. 

## Table of Contents
- [Installation](#Installation)
- [Usage](#Usage)
- [Features](#Features)
- [Technologies](#Technologies)
- [Contributing](#Contributing)
- [Testing](#Testing)


## Installation

#### How to get started with the Rocket feedback:
#### 1. Clone the github repository: 
```bash 
git clone https://github.com/S3ki/Rocket-Feedback
```

#### 2. Run mvn clean in case you have previous builds:
```bash
mvn clean
```

#### 3. Run mvn install:
```bash
mvn install
```

#### 4. Run the application
```bash
mvn javafx:run
```
## Usage

### Scenario 1. Student client
#### In the case of a client that is a student leaving a feedback:
- Open the application
- Either sign in or create a new user
- Once signed in, the user will be given a window where to choose a courses
- Then the user will choose the desired course
- The course feedback window will open
- The user will write their feedback and submit it
- Now the feedback will show on the teachers feedback feed

## Features

- This project features CSS styling

## Technologies

- JavaFX: a software platform used to build rich client applications that run on desktop, mobile, and embedded systems.
- Scene builder: a visual layout tool for designing user interfaces (UIs) in JavaFX.
- JUnit: a popular unit testing framework for Java applications.
- JaCoCo: (Java Code Coverage) is a popular code coverage library for Java projects.

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













