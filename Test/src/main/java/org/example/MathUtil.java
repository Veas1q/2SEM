package org.example;

import java.lang.module.FindException;
import java.util.Arrays;

public class MathUtil {
    public static int sum(int a, int b) {
        return a + b;
    }


    public static int compare(int a, int b) {
/*
        if (a > b) return 1;
        else if (a == b) return 0;
        else return -1;
*/

        return a - b;
    }

    public static int divide(int a, int b) throws IllegalArgumentException {
        if (b == 0)
            throw new IllegalArgumentException("Знаменатель не 0!");
        return a / b;
    }

    public int[] sort(int[] mas) {
        for (int i = 0; i < mas.length ; i++) {
            for (int j = i; j < mas.length ; j++) {
                if (mas[i] > mas[j]){
                    int temp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = temp;
                }
            }
        }
        return mas;
    }
}