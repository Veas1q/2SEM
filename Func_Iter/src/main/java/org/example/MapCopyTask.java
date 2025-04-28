package org.example;
import javax.crypto.spec.PSource;
import javax.print.attribute.HashAttributeSet;
import java.util.*;

import java.util.HashMap;


public class MapCopyTask {
    public static void main(String[] args) {
        // 1. Создаём исходную Map
        Map<Character, Set<Character>> graph = new HashMap<>();
        graph.put('d', null);
        graph.put('a', new HashSet<>(Set.of('d', 'c')));
        graph.put('f', new HashSet<>(Set.of('d')));
        graph.put('g', new HashSet<>(Set.of('d')));
        graph.put('c', null);
        graph.put('b', new HashSet<>(Set.of('g', 'f', 'c', 'a')));
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
            if (needRemove.isEmpty()){
                throw new RuntimeException("есть циклы");
            }
            for (int i = 0; i < needRemove.size() ; i++) {
                copyMap.remove(needRemove.get(i));
                for(Set<Character> k: copyMap.values()){
                    if (k != null){
                        k.remove(needRemove.get(i));
                    }
                }

            }

        }
    }
}
