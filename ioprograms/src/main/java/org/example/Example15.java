package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example15 {
    public static void main(String[] args) {
//        File file1 = new File("students.json");
//        File file2 = new File("student.json");
//        if(file1.exists()){
//            file1.renameTo(file2);
//            System.out.println("file renamed");
//        }
//
//        Path path1 = file1.toPath();
//        Path path2 = file2.toPath();

        Path oldPath = Path.of("students.json");
        Path newPath = Path.of("files/student.json");

        try{
            Files.createDirectories(newPath.subpath(0, newPath.getNameCount()-1));
            Files.move(oldPath, newPath);
            System.out.println("the file name changes successfully");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // classes in File does not throw the IO Exception, instead they return the boolean
    // classes in Files throw IOException


}
