package org.example;
import java.io.*;
import java.util.Stack;

public class JsonBracketChecker {

    /**
     * Проверяет корректность расстановки скобок {} и [] в JSON-файле
     * @param filename путь к JSON-файлу
     * @return 0 если скобки расставлены правильно, иначе позиция ошибки (начиная с 1)
     * @throws NullPointerException если имя файла null
     * @throws IllegalArgumentException если файл не .json
     * @throws FileNotFoundException если файл не существует
     * @throws IOException при ошибках чтения или недопустимых символах
     */
    public static int checkBrackets(String filename) throws IOException {
        // Проверка на null
        if (filename == null) {
            throw new NullPointerException("Имя файла не может быть null");
        }

        File file = new File(filename);

        // Проверка существования файла
        if (!file.exists()) {
            throw new FileNotFoundException("Файл не найден: " + filename);
        }

        try (FileReader reader = new FileReader(file)) {
            Stack<Character> stack = new Stack<>();
            int position = 0; // Текущая позиция в файле (начиная с 1)

            int ch;
            while ((ch = reader.read()) != -1) {
                position++;
                char c = (char) ch;

                // Проверка допустимости символа
                if (!isValidJsonChar(c)) {
                    throw new IOException("Недопустимый символ в JSON: '" + c + "' в позиции " + position);
                }

                // Обработка скобок
                if (c == '{' || c == '[') {
                    stack.push(c); // Добавляем открывающую скобку в стек
                }
                else if (c == '}' || c == ']') {
                    if (stack.isEmpty()) {
                        return position; // Закрывающая скобка без открывающей
                    }

                    char lastBracket = stack.pop();
                    if ((c == '}' && lastBracket != '{') || (c == ']' && lastBracket != '[')) {
                        return position; // Несоответствие типов скобок
                    }
                }
            }

            // Если остались незакрытые скобки
            if (!stack.isEmpty()) {
                return position;
            }

            return 0; // Все скобки корректны
        }
    }

    /**
     * Проверяет допустимость символа в JSON
     */
    private static boolean isValidJsonChar(char c) {
        return Character.isLetterOrDigit(c)  // Буквы и цифры
                || "{}[]:,\"\n\r\t -_".indexOf(c) != -1; // Допустимые спецсимволы
    }
}