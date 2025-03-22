package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List403Impl p = new List403Impl();
        p.print();
        p.add(4);
        p.add(1);
        p.add(2);
        p.add(213);
        p.add(99);
        p.print();
        p.add(543,3);
        p.print();
        System.out.println("===================По убыванию==============");
        p.sort(true);
        p.print();
        System.out.println("============По возврастанию");
        p.sort(false);
        p.print();
        p.get(3);
        System.out.println((p.size()));
        p.remove(3);
        p.print();

    }
}