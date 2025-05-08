package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

public class WriteGraphInFile {
    public static void writeGraphToFile(Map<Integer, Set<Integer>> graph, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(graph.size());
            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                for (Integer neighbor : entry.getValue()) {
                    writer.println(entry.getKey() + " " + neighbor);
                }
            }
        }
    }
}
