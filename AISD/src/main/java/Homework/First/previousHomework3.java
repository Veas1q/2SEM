package Homework.First;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class previousHomework3 {
    public static void main(String[] args) {
        int[] mas1 = {1,23,2,4,34,3,45,8};
        int[] mas2 = {2,3,3,34,5,3,2,77,46};
        combineSame(mas1, mas2);
    }
//    3 задание предыдущей домашки
    public static List<Integer> combineSame(int[] mas1, int[] mas2){
        HashMap<Integer, Integer> masF = new HashMap<>();
        HashMap<Integer, Integer> masS = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < mas1.length; i++) {
            if (masF.containsKey(mas1[i])){
                masF.put(mas1[i], masF.get(mas1[i]) + 1);
            } else{
                masF.put(mas1[i], 1 );
            }
        }
        for (int i = 0; i < mas2.length; i++) {
            if (masS.containsKey(mas2[i])){
                masS.put(mas2[i], masS.get(mas2[i]) + 1);
            } else{
                masS.put(mas2[i], 1 );
            }
        }
        for (int i = 0; i < mas1.length;    i++) {
            if (masF.containsKey(mas1[i]) && masS.containsKey(mas1[i]) &&
                    masF.get(mas1[i]) > 0 && masS.get(mas1[i]) > 0){
                list.add(mas1[i]);
                masF.put(mas1[i], masF.get(mas1[i]) - 1);
                masS.put(mas1[i], masS.get(mas1[i]) - 1);
            }
        }
        System.out.println(list);
        return list;
    }

}
