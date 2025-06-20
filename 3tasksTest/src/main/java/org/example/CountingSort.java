package org.example;

import java.io.*;
import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        byte[] mas = readMas("C:\\Users\\Redmi\\IdeaProjects\\2SEM2\\3tasksTest\\mas", "C:\\Users\\Redmi\\IdeaProjects\\2SEM2\\3tasksTest\\sortMas" );
        System.out.println(Arrays.toString(mas));
    }

    public static byte[] readMas(String nameFile, String sortNameFile){
        File file = new File(nameFile);
        try(FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(sortNameFile)){
            byte[] bytes = fis.readAllBytes();
            sort(bytes);
            return bytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static byte[] sort(byte[] mas){
        int[] countNumber = new int[256];
        for (int i = 0; i < mas.length; i++) {
            countNumber[mas[i] + 128]++;
        }
        int k = 0;
        for (int i = 0; i < countNumber.length; i++) {
            for (int j = 0; j < countNumber[i] ; j++) {
                mas[k] = (byte) (i - 128);
                k++;
            }
        }
        return mas;
    }

}
