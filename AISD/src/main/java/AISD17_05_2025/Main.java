package AISD17_05_2025;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] mas = {1,0,1,2,2,0,1,2,2,3};
        sort(mas);

    }
    public static void sort(int[] mas) {
        int left = 0;
        int right = mas.length - 1;
        int m = left;
        int temp;
        while (m < right) {
            if (mas[left] == 1){
                m++;
            }
            if (mas[left] < mas[right]){
                temp = mas[left];
                mas[left] = mas[right];
                mas[right] = mas[left];
                m++;
            }
        }
        System.out.println(Arrays.toString(mas));
    }
}