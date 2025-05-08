package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        try{
            OutputStream fos = new FileOutputStream("test1.txt");
            InputStream fis = new FileInputStream("test.txt");
            int r;
            byte[] bytes = new byte[1024];
            while ((r = fis.read(bytes)) > -1){
                String s = new String(bytes, 0 , r);
                fos.write(new String(bytes, 0, r).toLowerCase().getBytes(StandardCharsets.UTF_8));
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
