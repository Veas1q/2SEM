package Homework.third;

import java.util.Arrays;
import java.util.Comparator;

public class Third {
    public static void main(String[] args) {
        int[] mas = {3, 30, 34, 5, 9};
        String[] resTemp = new String[mas.length];
        for (int i = 0; i < mas.length ; i++) {
            resTemp[i] = String.valueOf(mas[i]);
        }
        Arrays.sort(resTemp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                return o2o1.compareTo(o1o2);
            }
        });
        System.out.println(Arrays.toString(resTemp));
        String res = new String();
        for (int i = 0; i < resTemp.length; i++) {
            res += resTemp[i];
        }
        System.out.println(res);
    }
}
