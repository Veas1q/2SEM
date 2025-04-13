package org.example.func_stule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(8);
        list.add(0);
        list.add(12);

        list.sort((o1, o2) -> o1 - o2);
        list.forEach(System.out::println);

        list.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        list.sort((o1, o2) -> {return o1 - o2;});

        list.forEach(new Consumer<Integer>() {
            public void accept(Integer a) {
                System.out.println(a);
            }
        });

    }
}
