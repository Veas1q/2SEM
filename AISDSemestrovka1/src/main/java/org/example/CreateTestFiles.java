package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import static org.example.WriteGraphInFile.writeGraphToFile;

public class CreateTestFiles {
    private static int numGraphs = 100;
    private static int minVertices = 100;
    private static int maxVertices = 10000;
    private static double edgeProbability = 0.02;
    Random random = new Random();
    public static Map<Integer, Set<Integer>> generateRandomDAG(int vertices, double edgeProbability) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Random random = new Random();

        // Инициализация вершин
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new HashSet<>());
        }

        // Добавление ребер с учетом ацикличности
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if (random.nextDouble() < edgeProbability) {
                    graph.get(i).add(j); // Ребро только от меньшей к большей вершине
                }
            }
        }

        return graph;
    }
   public static Map<Integer, Set<Integer>> generateBestCaseDAG(int vertices) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new HashSet<>()); // Нет исходящих ребер
        }
        return graph;
    }

    public static Map<Integer, Set<Integer>> generateWorstCaseDAG(int vertices) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Random random = new Random();

        // Инициализация вершин
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new HashSet<>());
        }

        // Добавление ребер с учетом ацикличности
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                graph.get(i).add(j); // Ребро только от меньшей к большей вершине
            }
        }

        return graph;
    }

    public static void writeRandomGraphInFile() {
        for (int i = 0; i < numGraphs; i++) {
            int vertices = minVertices + 99 * i;
            Map<Integer, Set<Integer>> dag = generateRandomDAG(vertices, edgeProbability);
            try {
                writeGraphToFile(dag, "dagR_" + i + ".txt");
            } catch (IOException e) {
                System.err.println("Ошибка при записи графа: " + e.getMessage());
            }
        }
    }
    public static void writeBestGraphInFile() {
        for (int i = 0; i < numGraphs; i++) {
            int vertices = minVertices + 99 * i;
            Map<Integer, Set<Integer>> dag = generateBestCaseDAG(vertices);
            try {
                writeGraphToFile(dag, "dagB_" + i + ".txt");
            } catch (IOException e) {
                System.err.println("Ошибка при записи графа: " + e.getMessage());
            }
        }
    }

    public static void writeWorstGraphInFile() {
        for (int i = 0; i < numGraphs; i++) {
            int vertices = minVertices + 99 * i;
            Map<Integer, Set<Integer>> dag = generateWorstCaseDAG(vertices);
            try {
                writeGraphToFile(dag, "dagW_" + i + ".txt");
            } catch (IOException e) {
                System.err.println("Ошибка при записи графа: " + e.getMessage());
            }
        }
    }

}
