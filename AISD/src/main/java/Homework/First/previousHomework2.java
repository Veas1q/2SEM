package Homework.First;

import java.util.HashMap;

public class previousHomework2 {
    public static void main(String[] args) {
        int[] mas = {1,23,4,1,1324,32,53,2423,2};
        int k = 123;
        cheackVer2(mas,k);
    }
    //2 задание предыдущей домашки
    public static boolean cheackVer2(int[] mas, int k){
        HashMap<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < mas.length; i++) {
            if (valueIndex.containsKey(mas[i]) && i - valueIndex.get(mas[i]) <= k){
                System.out.println("TRUE");
                return true;
            }
            valueIndex.put(mas[i], i);
        }
        System.out.println("FALSE");
        return false;
    }

}
