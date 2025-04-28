package AISD1;

import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        int min = 0;
        int[] masToSort = {12300, 42003, 7658, 987867, 234, 12};
        for (int i = 0; i < masToSort.length; i++) {
            for (int j = i; j < masToSort.length; j++) {

                min = (masToSort[j] < masToSort[min] ? j : min);
            }
            int temp = masToSort[min];
            masToSort[min] = masToSort[i];
            masToSort[i] = temp;
        }
//        System.out.println(Arrays.toString(masToSort));

        char[] mas = {'[',']', '{', '}', '[',']'};
        char[] mas1 = {'[',']', '[', ']', ']',']'};
        char[] mas3 = {'[',']', '[',']'};

//        for (int i = 0; i < mas.length ; i++) {
//            System.out.println((int)mas[i]);
//        }
        System.out.println(check(mas3));
    }

    public static boolean check(char[] mas) {
        if (mas.length % 2 != 0 || mas[0] == (int)']' || mas[0] == (int) ')' || mas[0] == (int)'}' || mas[mas.length - 1] == '[' || mas[mas.length - 1] == '{' || mas[mas.length - 1] == '('){
            return false;

        }
        for (int i = 0; i < mas.length - 1 ; i++) {
            System.out.println(i);
            if (!((int)mas[i] == ((int)mas[i + 1] - 1) || (int)mas[i] == ((int)mas[i + 1] - 2) ||
                    ((int)mas[mas.length - 1 - i] - 1) == (int)mas[i] || ((int)mas[mas.length - 1 - i] - 2) == (int)mas[i]
                ||((int)mas[mas.length - 1 - i] + 1) == (int)mas[i] || ((int)mas[mas.length - 1 - i] + 2) == (int)mas[i]
                    ||(int)mas[i] == ((int)mas[i - 1] + 1) || (int)mas[i] == ((int)mas[i - 1] + 2))) {
                return false;
            }
        }
        return true;
    }
}