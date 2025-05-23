package org.example.graph;

import java.util.*;

public class Graph implements Iterable<Character> {
    private Map<Character, Set<Character>> graph = new HashMap();

    public Graph(){
        graph = new HashMap<>();
        graph.put('d', null);
        graph.put('a', new HashSet<>(Set.of('d', 'c')));
        graph.put('f', new HashSet<>(Set.of('d')));
        graph.put('g', new HashSet<>(Set.of('d')));
        graph.put('c', null);
        graph.put('b', new HashSet<>(Set.of('g', 'f', 'c', 'a')));
    }

    public Set<Character> topolSort() {
        Map<Character, Set<Character>> copyMap = new HashMap<>();
        for (Map.Entry<Character, Set<Character>> i : graph.entrySet()) {
            copyMap.put(i.getKey(), i.getValue() == null ? null : new HashSet<>(i.getValue()));
        }
        Set<Character> res = new LinkedHashSet<>();
        while (!copyMap.isEmpty()) {
            List<Character> needRemove = new ArrayList<>();
            for (Map.Entry<Character, Set<Character>> i : copyMap.entrySet()) {
                if (i.getValue() == null || i.getValue().isEmpty()) {
                    res.add(i.getKey());
                    needRemove.add(i.getKey());
                }
            }
            if (needRemove.isEmpty()) {
                throw new RuntimeException("есть циклы");
            }
            for (int i = 0; i < needRemove.size(); i++) {
                copyMap.remove(needRemove.get(i));
                for (Set<Character> k : copyMap.values()) {
                    if (k != null) {
                        k.remove(needRemove.get(i));
                    }
                }

            }
        }
        return res;
    }
    public class GraphIterator implements Iterator<Character> {
        private final Character[] arr;
        private int index = 0;

        public GraphIterator(Set<Character> sorted) {
            this.arr = sorted.toArray(new Character[0]);
        }

        @Override
        public boolean hasNext() {
            return index < arr.length;
        }

        @Override
        public Character next() {
            return arr[index++];
        }
    }

    public Iterator<Character> iterator() {
        return new GraphIterator(topolSort());
    }

}