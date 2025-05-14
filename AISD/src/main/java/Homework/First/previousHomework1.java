package Homework.First;

import java.util.HashMap;

public class previousHomework1 {
// 1 задание предыдущей домашки
    public static void main(String[] args) {
        countDifferentWords("Apple banana melon banana apple ");
    }

    public static void countDifferentWords(String str){
        String[] strM = str.split(" ");
        HashMap<String, Integer> mas = new HashMap<>();
        for (int i = 0; i < strM.length; i++) {
            mas.put(strM[i], 0);

        }
        for (int i = 0; i < strM.length ; i++) {
            if (mas.containsKey(strM[i])){
                mas.put(strM[i], mas.get(strM[i]) + 1);
            }
        }
        System.out.println(mas);
    }

}
