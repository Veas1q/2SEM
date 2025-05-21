package Homework.third;

import java.util.Arrays;

public class Fourth {
    public static void main(String[] args) {
        int[] mas1 = {15, 5, 11, 10, 12,122};
        int s = 100;
        //      Задача 4
        //Дан список неотрицательных чисел и некоторое число s.
        // Необходимо вывести мксимальное количество числе из списка, сумма которых не превышает s.
        // Пример: [15, 5, 11, 10, 12], s = 30, тогда ответ будет 3 (например, 5 + 10 + 11 < 30)
        //[5,11,10,12,15]
        Arrays.sort(mas1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < mas1.length ; i++) {
            if(sum + mas1[i] < s){
                sum += mas1[i];
                count++;
            }else{
                System.out.println(count);
                break;
            }
        }
    }
}
