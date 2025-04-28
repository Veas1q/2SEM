package org.example;


import java.io.*;
import java.util.Scanner;

public class MainFileCopy {
    private String InputFile;
    private String OutputFile;

    public static void main(String[] args) {
        MainFileCopy mainFileCopy = new MainFileCopy();
        mainFileCopy.input();
        mainFileCopy.copy();
    }
    private void input(){
        System.out.println("Введите имя файла: ");
        Scanner scanner = new Scanner(System.in);
        InputFile = scanner.nextLine();
        System.out.println("Введите имя копии");
        OutputFile = scanner.nextLine();
        File check = new File(InputFile);
        if (!check.isFile() && check.exists()) {
            throw new RuntimeException("FileNotFoundException");
        }
    }
    private void copy() {
        try (InputStream fis = new FileInputStream(InputFile);
             OutputStream fos = new FileOutputStream(OutputFile)) {
            byte[] buffer = new byte[1024];
            int r;
            while ((r = fis.read(buffer)) > -1) {
                fos.write(buffer, 0, r);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
