package org.example;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example2 {
    public static void main(String[] args) {
        useFile("testing.txt");
    }
//    private static void usePath(String filename){
//        Path path = Path.of(filename);
//        Files.
//
//        boolean fileExists = Files.exists(path);
//
//        System.out.printf("file %s %s", filename,fileExists? "exists. ": "does not exists");
//
//        if(fileExists){
//            System.out.println("Deleting the file "+ filename);
//            try {
////                fileExists = !Files.delete(path);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        if(!fileExists){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                System.out.println("Cannot create the new file");
//            }
//            System.out.println("Created file: "+ filename);
//            if(file.canWrite()){
//                System.out.println("Would lie to writ ehere");
//            }
//        }
//
//    }

    private static void useFile(String filename){
        File file = new File(filename);
        boolean fileExists = file.exists();

        System.out.printf("file %s %s", filename,fileExists? "exists. ": "does not exists");

        if(fileExists){
            System.out.println("Deleting the file "+ filename);
            fileExists = !file.delete();
        }

        if(!fileExists){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Cannot create the new file");
            }
            System.out.println("Created file: "+ filename);
            if(file.canWrite()){
                System.out.println("Would lie to writ ehere");
            }
        }

    }

}
