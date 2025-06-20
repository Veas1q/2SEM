package org.example;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Taks2 {
    public static void main(String[] args) {
        readAndWrite("C:\\Users\\Redmi\\IdeaProjects\\2SEM2\\3tasksTest\\task2read", "C:\\Users\\Redmi\\IdeaProjects\\2SEM2\\3tasksTest\\task2");
    }
    public static void readAndWrite(String pathRead, String pathWrite){
        try (FileInputStream fis = new FileInputStream(pathRead);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            byte[] bytes = new byte[1024];
            int r;
            while ((r = fis.read(bytes)) != -1 ){
                baos.write(bytes, 0, r);
            }
            byte[] array = baos.toByteArray();
            baos.flush();
            int countByte[] = count(array);
            creareDiogram(countByte);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int[] count(byte[] array){
        int mas[] = new int[256];
        for (int i = 0; i < array.length ; i++) {
            mas[array[i] + 128]++;
        }
        return mas;
    }
    public static void creareDiogram( int[] countByte){
        System.out.println("Байт  |  Сколько раз встречался | Диаграмма");
        for (int i = 0; i < countByte.length; i++) {
            System.out.print(i + " | " + countByte[i] + " | ");
            for (int j = 0; j < countByte[i]; j++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
}
