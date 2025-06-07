package org.example;

import java.io.IOException;

public class CreateQuestion {
    public static void main(String[] args) {
        Questions questions = new Questions();

        // Вопрос 1
        questions.question1 = "Сколько стоит BKB ?";
        questions.response1 = new String[]{"4150", "4200", "4050"};
        questions.goodResponseIndex1 = 2;

        // Вопрос 2
        questions.question2 = "Сколько героев в доте?";
        questions.response2 = new String[]{"124", "125", "126"};
        questions.goodResponseIndex2 = 2;

        // Вопрос 3
        questions.question3 = "На каких минутах появляются руны богатства?";
        questions.response3 = new String[]{"каждый 3 минут", "каждые 2 минуты", "каждую минуту"};
        questions.goodResponseIndex3 = 0;

        try {
            FileUtils.saveObject("questions.dat", questions);
            System.out.println("Вопросы успешно сохранены!");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении вопросов: " + e.getMessage());
        }
    }
}
