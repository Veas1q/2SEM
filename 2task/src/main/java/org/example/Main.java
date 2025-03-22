package org.example;

import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList<Object> s = new LinkedList<Object>();

        s.addLast("1");
        s.addLast("2");
        s.addLast("3");
        s.addLast("4");
        s.addIn("9",1);
//        s.print();
        LinkedList<Integer> c = new LinkedList<Integer>();
        long start = System.nanoTime();
        for (int i = 0; i < 1000000 ; i++) {
            Random random = new Random(100000000);
            c.addLast(random.nextInt());

        }
        long mid = System.nanoTime();
        for (int i = 0; i < 100000 ; i++) {
            c.removeLast();
        }
        long end = System.nanoTime();
        System.out.println("Время добавления в списках");
        System.out.println(mid - start);
        System.out.println();
        System.out.println("Время удаления в списках");
        System.out.println(end - mid);
        System.out.println();
        System.out.println("Время добавления и удаления");
        System.out.println(end - start);
        System.out.println();
        System.out.println("Разница суммы добавления и удаления двусвязного от списка ");
        System.out.println(205656703700l - 136736800);
    }
}