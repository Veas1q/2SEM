package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List403Impl p = new List403Impl();
        p.add(4);
        p.add(1);
        p.add(2);
        p.add(213);
        p.add(99);
        p.print();
        p.add(1,5);
        p.print();
        p.sort(true);
        p.print();
        p.sort(false);
        p.print();
        p.get(3);
        System.out.println((p.size()));
        p.remove(3);
        p.print();
    }
}