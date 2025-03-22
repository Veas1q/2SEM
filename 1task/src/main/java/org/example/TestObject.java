package org.example;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;

public class TestObject {
    public static void main(String[] args) {
        addTest();
    }

    public static void addTest() {
        List403ImplU<Object> list = new List403ImplU<Object>();
//        list.add("1");
//        list.add(2);
//        list.add('c');
//        System.out.println(list);
        List403ImplU<Integer> ss = new List403ImplU<Integer>();
        long start = System.nanoTime();
        for (int i = 0; i < 1000000 ; i++) {
            Random random = new Random(100000000);
            ss.add(random.nextInt());
        }
        long mid = System.nanoTime();
        for (int i = 0; i < 100000 ; i++) {
            ss.remove(i);
        }
        long end = System.nanoTime();

        System.out.println("Время добавления");
        System.out.println(mid - start);
        System.out.println("Время удаления");
        System.out.println(end - mid);
        System.out.println("Время добавления и удаления");
        System.out.println(end - start);
//        System.out.println((int) (list.get(0)) + (int)(list.get(1)));
    }
}
