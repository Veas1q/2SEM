package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class ArrayGenerator {
    private static final int NUM_FILES = 100;
    private static final int MIN_SIZE = 100;
    private static final int STEP = 100;

    public static void generateArrays() {
        Random random = new Random();

        for (int i = 0; i < NUM_FILES; i++) {
            int size = MIN_SIZE + STEP*i;
            int[] array = generateRandomArray(size, random);
            writeArrayToFile(array, "array_" + i + "_size_" + size + ".txt");
        }
    }

    private static int[] generateRandomArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    private static void writeArrayToFile(int[] array, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.println(num);
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл " + filename + ": " + e.getMessage());
        }
    }
}

