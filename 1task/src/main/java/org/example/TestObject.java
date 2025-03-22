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
        for (int i = 0; i < 2_000_000 ; i++) {
            Random random = new Random(100000000);
            ss.add(random.nextInt(),i);
        }
        long mid = System.nanoTime();
        // 438451435800 время удаления
        for (int i = 100_000; i > 0 ; i--) {
            ss.remove(i);
        }
        long end = System.nanoTime();

        System.out.println("Время добавления в массиве");
        System.out.println(mid - start);
        System.out.println("Время удаления");
        System.out.println(end - mid);
        System.out.println("Время добавления и удаления");
        System.out.println(end - start);
//        System.out.println((int) (list.get(0)) + (int)(list.get(1)));
    }
}
