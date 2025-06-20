package org.example;

public class Main {
    public static void main(String[] args) {
//        Дан массив mas произвольной длины. Даны два индекса i и j (i < j < длина массива). Необходимо:
//        Заменить все элементы с mas[i] по mas[j] на их квадраты.
//       Сравнить суммы на двух отрезках:
//        Сумма исходных элементов (sum_original = mas[i] + mas[i+1] + ... + mas[j]).
//        Сумма после возведения в квадрат (sum_squared = mas[i]² + mas[i+1]² + ... + mas[j]²).
//        Вывести процент отношения большей суммы к меньшей.

        int[] mas = {1,4,5,7,39};
        SegmentTree segmentTree = new SegmentTree(mas);
        int i = 0;
        int j = 4;
        System.out.println((segmentTree.querySum(0,4)));
        double originalSum = segmentTree.querySum(0,4);
        for (int k = 3; k < j + 1 ; k++) {
            segmentTree.update(k,mas[k] * 2);
        }
        double newSum = segmentTree.querySum(0,4);
        System.out.println(newSum / originalSum * 100 + "%");




        ArrayGenerator.generateArrays();
        ArrayTester.testerArrays();

    }
}
