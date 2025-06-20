package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Текст перевести в ByteArrayInputStream,
 * скопировать побайтно в ByteArrayOutputStream,
 * записать в файл. Написать тест
 * процедуры копирования.
 */
public class Task3 {
    public static  ByteArrayOutputStream copy(ByteArrayInputStream bais) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int r;
        while((r = bais.read()) != -1) {
            baos.write(r);
        }
        return baos;
    }

    public static void main(String[] args) {
        String text = "Hello, world";
        ByteArrayInputStream byteArrayInputStream =
                new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = copy(byteArrayInputStream);
        try (FileOutputStream fos = new FileOutputStream("text2.txt")) {
            fos.write(byteArrayOutputStream.toByteArray());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}