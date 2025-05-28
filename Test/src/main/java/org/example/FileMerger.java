package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Paths.get;

public class FileMerger {
    public static void mergeFiles(String file1Path, String file2Path, String outputPath) {
        try (FileOutputStream fos = new FileOutputStream(outputPath);
        FileInputStream fis1 = new FileInputStream(file1Path);
        FileInputStream fis2 = new FileInputStream(file2Path)){
            int r;
            byte[] buffer = new byte[1024];
            while((r = fis1.read(buffer)) != -1){
                fos.write(buffer, 0, r);
            }
            while((r = fis2.read(buffer)) != -1){
                fos.write(buffer, 0, r);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
