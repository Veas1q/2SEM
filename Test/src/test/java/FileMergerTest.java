import org.example.FileMerger;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FileMergerTest {
    // Файлы должны существовать в проекте
    private static final String TEXT_FILE = "existing.txt";
    private static final String BINARY_FILE = "existing.bin";
    private static final String OUTPUT_FILE = "merged_result.bin";
    private static final String EXPECTED_FILE = "expected_result.bin"; // Файл с правильным результатом

    @Test
    void testMergeFiles() throws IOException {
        // 1. Проверяем существование всех файлов
        assertAll(
                () -> assertTrue(Files.exists(Paths.get(TEXT_FILE)), "Текстовый файл не найден"),
                () -> assertTrue(Files.exists(Paths.get(BINARY_FILE)), "Бинарный файл не найден"),
                () -> assertTrue(Files.exists(Paths.get(EXPECTED_FILE)), "Файл с правильным результатом не найден")
        );

        // 2. Объединяем файлы
        FileMerger.mergeFiles(TEXT_FILE, BINARY_FILE, OUTPUT_FILE);

        // 3. Проверяем размер
        long expectedSize = Files.size(Paths.get(TEXT_FILE)) +
                Files.size(Paths.get(BINARY_FILE));
        assertEquals(expectedSize, Files.size(Paths.get(OUTPUT_FILE)));

        // 4. Сравниваем с эталоном (полное побайтовое сравнение)
        assertArrayEquals(
                Files.readAllBytes(Paths.get(EXPECTED_FILE)),
                Files.readAllBytes(Paths.get(OUTPUT_FILE)),
                "Результат не совпадает с правильным файлом"
        );


    }
}