package org.example.graph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<Character, Set<Character>> graph;

    public Graph() {
        graph = new HashMap<>();

        graph.put('d', null);
        // создаем примитивное множество из 2-х элементов, оборачиваем в более мощный по возможностям класс
        graph.put('a', new HashSet<>(Set.of('d','c')));
        graph.put('f', new HashSet<>(Set.of('d')));
        graph.put('g', new HashSet<>(Set.of('d','c', 'f')));
        graph.put('c', null);
        graph.put('b', new HashSet<>(Set.of('f','g','a','c')));
    }

    public Set<Character> sort() {
        return null;
    }
}
