# GTU Practice Quiz App

## Overview

The GTU Practice Quiz App is an Android application created using Java and SQLite database. This app is designed for students to practice quizzes on various subjects. It features two types of logins - student and admin. Students can choose a subject and take quizzes while administrators have the privilege to manage questions, subjects, and set correct answers.

## Features

### Student Login

- **User Authentication:** Students can log in with their credentials to access the app.
- **Subject Selection:** Students can choose a subject from a list of available subjects to take a quiz in.
- **Quiz Attempt:** Students can attempt quizzes consisting of multiple-choice questions related to the selected subject.
- **Quiz Results:** After completing a quiz, students can view their results, including the number of correct and incorrect answers.

### Admin Login

- **Admin Authentication:** Admins have a separate login with specific credentials.
- **Manage Subjects:** Admins can add new subjects for quizzes and delete existing ones.
- **Manage Questions:** Admins can add, edit, or delete questions for each subject.
- **Set Correct Answers:** Admins can set the correct answers for each question.

## Installation

1. Clone this repository to your local machine:

```bash
git clone https://github.com/vedant-dhamecha/GTUQuizAndroidApp/
```

2. Open the project in Android Studio.

3. Build and run the app on your Android device or emulator.

## Usage

### Student

1. Launch the app and log in with your student credentials.

2. Select a subject from the available options.

3. Start the quiz and answer the questions.

4. After completing the quiz, view your results.

### Admin

1. Launch the app and log in with your admin credentials.

2. From the admin dashboard, you can manage subjects, questions, and correct answers.

3. To manage subjects, add new subjects or delete existing ones.

4. To manage questions, you can add, edit, or delete questions for each subject.

5. Set correct answers for questions by specifying the correct option.

## Database

The app uses an SQLite database to store subjects, questions, and user information. You can access the database by navigating to the following location:

```plaintext
app/src/main/java/com/example/gtupracticequizapp/data/DatabaseHelper.java
```
## Screenshots
![1](https://github.com/vedant-dhamecha/GTUQuizAndroidApp/assets/105575987/639278ae-c5c8-4868-b21b-6c6c97c9a05c)
![2](https://github.com/vedant-dhamecha/GTUQuizAndroidApp/assets/105575987/28e598ba-dc2f-4da2-bf06-7d0f10edb320)
![3](https://github.com/vedant-dhamecha/GTUQuizAndroidApp/assets/105575987/0f595fca-8077-4aa5-896d-1772ca041a5b)


## Contributors

- [Vedant Dhamecha](https://github.com/vedant-dhamecha)

## License

This project is licensed under the [MIT License](LICENSE.md).

---

Enjoy practicing quizzes and improving your knowledge with the GTU Practice Quiz App! If you have any questions or suggestions, feel free to contact us.
