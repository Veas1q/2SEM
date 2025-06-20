package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreateQuestions {
    public static void main(String[] args) throws IOException {
        Questions questions = new Questions();
        questions.questions1 = "Сколько хромосом у человека здорового ?";
        questions.response1 = new String[]{"1", "2", "47"};
        questions.goodResponseIndex1 = 2;

        questions.questions2 = "Сколько мне лет ?";
        questions.response2 = new String[]{"18", "19", "17"};
        questions.goodResponseIndex2 = 0;

        questions.questions3 = "В каком месяце у меня день рождение ?";
        questions.response3 = new String[]{"июнь", "июль", "август"};
        questions.goodResponseIndex3 = 0;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Questions.dat"))) {
            oos.writeObject(questions);
        }
    }

}
