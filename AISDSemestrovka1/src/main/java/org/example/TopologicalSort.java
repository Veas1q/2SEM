package org.example;

import java.util.*;

public class TopologicalSort {
    private final Map<Integer, Set<Integer>> graph;
    private long countIterations;
    private long timeNanoSec;
    public TopologicalSort(Map<Integer, Set<Integer>> graph) {
        if (graph == null) {
            throw new NullPointerException("Граф пустой");
        }
        this.graph = graph;
    }

    public long getCountIterations() {
        return countIterations;
    }


    public long getTimeNanoSec() {
        return timeNanoSec;
    }


    public  List<Integer> topologicalSort() {
        long startTime = System.nanoTime();
        int[] iterations = new int[1];

        // 1. Подсчёт входящих степеней
        Map<Integer, Integer> inDegree = new HashMap<>();
        graph.keySet().forEach(v -> inDegree.put(v, 0));

        for (Set<Integer> neighbors : graph.values()) {
            for (Integer v : neighbors) {
                inDegree.put(v, inDegree.get(v) + 1);
                iterations[0]++;
            }
        }

        // 2. Инициализация очереди с вершинами без входящих рёбер
        Queue<Integer> queue = new ArrayDeque<>();
        inDegree.forEach((v, count) -> {
            if (count == 0) {
                iterations[0]++;
                queue.add(v);
            }
        });
        // Проверка на цикл
        if (queue.isEmpty()){
            throw new IllegalArgumentException("Граф содержит циклы! Время в наноcекундах " + (System.nanoTime()- startTime));
        }

        // 3. Процесс сортировки
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            result.add(u);

            for (Integer v : graph.get(u)) {
                inDegree.put(v, inDegree.get(v) - 1);
                iterations[0]++;
                if (inDegree.get(v) == 0) {
                    queue.add(v);
                }
            }

        }

        // 4. Проверка на циклы
        if (result.size() != graph.size()) {
            throw new IllegalArgumentException("Граф содержит циклы!\n Время в наносекундах " + (System.nanoTime()- startTime) + "\n Количество итераций " + iterations);
        }

        countIterations = iterations[0];
        timeNanoSec = System.nanoTime() - startTime;
        return result;
    }



}
