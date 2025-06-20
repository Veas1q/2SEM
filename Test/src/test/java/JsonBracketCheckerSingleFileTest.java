import org.example.JsonBracketChecker;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class JsonBracketCheckerSingleFileTest {
    // Укажите здесь путь к вашему тестовому файлу
    private static final String TEST_JSON_FILE = "bookings.json";

    @Test
    void testJsonBrackets() throws IOException {
        // 1. Проверка существования файла
        assertTrue(new File(TEST_JSON_FILE).exists(), "Файл не найден: " + TEST_JSON_FILE);

        // 2. Запуск проверки
        int result = JsonBracketChecker.checkBrackets(TEST_JSON_FILE);


        assertEquals(0, result, "Файл содержит ошибки в скобках");
    }
}