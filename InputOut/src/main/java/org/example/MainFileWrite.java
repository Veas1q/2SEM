package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainFileWrite {
    public static void main(String[] args) {
        try (OutputStream fos = new FileOutputStream("test.txt")) {
            String [] strings = {"Test", "zapisi", "file"};
            for (String s: strings){
                fos.write(s.getBytes(StandardCharsets.UTF_8));

            }
            fos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
