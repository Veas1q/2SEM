package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class ArrayTester {
    private static PrintWriter resultsWriter;

    public static void testerArrays() {
        // Открываем файл для записи результатов
        try {
            resultsWriter = new PrintWriter(new FileWriter("segment_tree_results.csv"));
            // Записываем расширенный заголовок CSV
            resultsWriter.println("Размер массива,Время создания (нс),Итерации создания," +
                    "Время добавления (нс),Итерации добавления," +
                    "Время удаления (нс),Итерации удаления," +
                    "Время запросов суммы (нс),Итерации запросов суммы," +
                    "Время запросов минимума (нс),Итерации запросов минимума," +
                    "Время запросов максимума (нс),Итерации запросов максимума," +
                    "Время обновлений (нс),Итерации обновлений");
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла результатов: " + e.getMessage());
            return;
        }

        File dir = new File(".");
        File[] files = dir.listFiles((d, name) -> name.startsWith("array_") && name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("Файлы с массивами не найдены. Сначала выполните генерацию.");
            return;
        }

        for (File file : files) {
            int[] array = readArrayFromFile(file.getPath());
            if (array != null) {
                processArray(array);
            }
        }

        resultsWriter.close();
    }

    private static int[] readArrayFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            int count = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }

            int[] array = new int[count];
            scanner.close();

            try (Scanner newScanner = new Scanner(new File(filename))) {
                for (int i = 0; i < count; i++) {
                    array[i] = Integer.parseInt(newScanner.nextLine());
                }
            }

            return array;
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filename);
            return null;
        }
    }

    private static void processArray(int[] array) {
        Random random = new Random();
        int size = array.length;

        // Создаем SegmentTree и замеряем время
        long startTime = System.nanoTime();
        SegmentTree st = new SegmentTree(array);
        long creationTime = System.nanoTime() - startTime;
        int creationIterations = size; // Итерации при построении дерева

        // Тестирование добавления
        startTime = System.nanoTime();
        int addIterations = 0;
        for (int i = 0; i < size/10; i++) {
            // Каждое добавление вызывает rebuildSegmentTree(), который делает n итераций
            st.add(random.nextInt(), random.nextInt(size));
            addIterations += size; // Учитываем итерации перестроения дерева
        }
        long addTime = System.nanoTime() - startTime;

        // Тестирование удаления
        startTime = System.nanoTime();
        int removeIterations = 0;
        for (int i = 0; i < size/10; i++) {
            st.remove(random.nextInt(size));
            removeIterations += size; // Аналогично добавлению
        }
        long removeTime = System.nanoTime() - startTime;


        // Тестирование запросов суммы
        startTime = System.nanoTime();
        int sumQueryIterations = 0;
        for (int i = 0; i < size/10; i++) {
            int left = random.nextInt(size);
            int right = left + random.nextInt(size - left);
            st.querySum(left, right);
            sumQueryIterations += (int)(Math.log(size)/Math.log(2)) + 1; // Оценка итераций
        }
        long sumQueryTime = System.nanoTime() - startTime;

        // Тестирование запросов минимума
        startTime = System.nanoTime();
        int minQueryIterations = 0;
        for (int i = 0; i < size/10; i++) {
            int left = random.nextInt(size);
            int right = left + random.nextInt(size - left);
            st.queryMin(left, right);
            minQueryIterations += (int)(Math.log(size)/Math.log(2)) + 1;
        }
        long minQueryTime = System.nanoTime() - startTime;

        // Тестирование запросов максимума
        startTime = System.nanoTime();
        int maxQueryIterations = 0;
        for (int i = 0; i < size/10; i++) {
            int left = random.nextInt(size);
            int right = left + random.nextInt(size - left);
            st.queryMax(left, right);
            maxQueryIterations += (int)(Math.log(size)/Math.log(2)) + 1;
        }
        long maxQueryTime = System.nanoTime() - startTime;

        // Тестирование обновлений
        startTime = System.nanoTime();
        int updateIterations = 0;
        for (int i = 0; i < size/10; i++) {
            st.update(random.nextInt(size), random.nextInt());
            updateIterations += (int)(Math.log(size)/Math.log(2)) + 1;
        }
        long updateTime = System.nanoTime() - startTime;

        // Записываем результаты
        resultsWriter.printf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d, %d, %d%n",
                size,
                creationTime, creationIterations,
                addTime, addIterations,
                removeTime, removeIterations,
                sumQueryTime, sumQueryIterations,
                minQueryTime, minQueryIterations,
                maxQueryTime, maxQueryIterations,
                updateTime, updateIterations);

        resultsWriter.flush();
    }
}
