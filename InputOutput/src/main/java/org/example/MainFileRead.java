package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainFileRead {
    public static void main(String[] args) {
//        long start = System.nanoTime();
//        try (InputStream fis = new FileInputStream("C:\\Users\\Redmi\\IdeaProjects\\SecondSemestr\\bookings.json")) {
//            int r;
//            while ((r = fis.read()) > -1) {
////                System.out.print((char)r);
//            }
//            long end = System.nanoTime();
//            System.out.println(end - start);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try (InputStream fis = new FileInputStream("C:\\Users\\Redmi\\IdeaProjects\\SecondSemestr\\med.csv")) {
            byte[] buffer = new byte[1024];
            int r; // кол-во реально прочитанных файлов
            long start = System.nanoTime();
            while ((r = fis.read(buffer)) > -1) {
                System.out.println(new String(buffer, 0, r));
            }
            long end = System.nanoTime();
            System.out.println(end - start);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
