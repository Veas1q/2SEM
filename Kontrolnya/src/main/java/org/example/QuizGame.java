package org.example;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

public class QuizGame {
    private static final String QUESTIONS_FILE = "questions.dat";
    private static final String RATING_FILE = "rating.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Загрузка вопросов
        Questions questions = loadQuestions();
        if (questions == null) {
            System.out.println("Не удалось загрузить вопросы. Игра завершена.");
            return;
        }

        // Ввод имени игрока
        System.out.print("Введите ваше имя: ");
        String playerName = scanner.nextLine();

        // Запуск викторины
        int score = runQuiz(questions, scanner);

        // Сохранение результата
        saveGameResult(playerName, score);

        // Вывод рейтинга
        showRating();

        scanner.close();
    }

    private static Questions loadQuestions() {
        try {
            return (Questions) FileUtils.loadObject(QUESTIONS_FILE);
        } catch (Exception e) {
            System.out.println("Ошибка загрузки вопросов: " + e.getMessage());
            return null;
        }
    }

    private static int runQuiz(Questions questions, Scanner scanner) {
        int score = 0;

        System.out.println("\n=== Викторина началась! ===");

        // Вопрос 1
        score += askQuestion(
                questions.question1,
                questions.response1,
                questions.goodResponseIndex1,
                scanner
        );

        // Вопрос 2
        score += askQuestion(
                questions.question2,
                questions.response2,
                questions.goodResponseIndex2,
                scanner
        );

        // Вопрос 3
        score += askQuestion(
                questions.question3,
                questions.response3,
                questions.goodResponseIndex3,
                scanner
        );

        System.out.println("\n=== Викторина завершена! ===");
        System.out.println("Ваш результат: " + score + " из 3");

        return score;
    }

    private static int askQuestion(String question, String[] responses, int correctIndex, Scanner scanner) {
        System.out.println("\n" + question);
        for (int i = 0; i < responses.length; i++) {
            System.out.println((i+1) + ") " + responses[i]);
        }

        int answer = 0;
        while (answer < 1 || answer > responses.length) {
            System.out.print("Ваш ответ: ");
            try {
                answer = scanner.nextInt();
            } catch (Exception e) {
                scanner.next(); // Очистка буфера
            }
        }

        if (answer - 1 == correctIndex) {
            System.out.println("Правильно!");
            return 1;
        } else {
            System.out.println("Неправильно! Правильный ответ: " + responses[correctIndex]);
            return 0;
        }
    }

    private static void saveGameResult(String playerName, int score) {
        Rating rating = loadRating();
        if (rating == null) {
            rating = new Rating();
        }

        Game game = new Game();
        game.playerName = playerName;
        game.score = score;
        game.gameDate = new Date();

        rating.games.add(game);

        try {
            FileUtils.saveObject(RATING_FILE, rating);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения рейтинга: " + e.getMessage());
        }
    }

    private static Rating loadRating() {
        try {
            return (Rating) FileUtils.loadObject(RATING_FILE);
        } catch (Exception e) {
            return new Rating(); // Возвращаем новый рейтинг, если файла нет
        }
    }

    private static void showRating() {
        Rating rating = loadRating();
        if (rating.games.isEmpty()) {
            System.out.println("\nРейтинг игроков пуст.");
            return;
        }

        // Сортировка по убыванию счета
        rating.games.sort((g1, g2) -> g2.score.compareTo(g1.score));

        System.out.println("\n=== Рейтинг игроков ===");
        for (int i = 0; i < rating.games.size(); i++) {
            Game game = rating.games.get(i);
            System.out.println( i+1 +  ". " + game.playerName + " - "+ game.score + " балла " + game.gameDate);
        }
    }
}