package org.example;

import java.io.*;
import java.util.*;

public class GraphReader {

    // Метод для чтения графа из файла
    public static Map<Integer, Set<Integer>> readGraphFromFile(String filename) throws IOException {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Читаем количество вершин
            int vertexCount = Integer.parseInt(reader.readLine());

            // Инициализируем все вершины
            for (int i = 0; i < vertexCount; i++) {
                graph.put(i, new HashSet<>());
            }

            // Читаем рёбра
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int source = Integer.parseInt(parts[0]);
                int destination = Integer.parseInt(parts[1]);
                graph.get(source).add(destination);
            }
        }

        return graph;
    }
    public static void readGraph(String s){
        String[] fileNameMas = new String[100];
        for (int i = 0; i < 100 ; i++) {
            fileNameMas[i] = "dag" + s + "_" + i + ".txt";
        }
        for (int i = 0; i < 100 ; i++) {
            try {
                TopologicalSort graph = new TopologicalSort(GraphReader.readGraphFromFile(fileNameMas[i]));
                System.out.println(graph.topologicalSort().size() + " " + graph.getTimeNanoSec() + " " + graph.getCountIterations());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}