package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class Example4 {
    public static void main(String[] args) {
        Path path = Path.of("there/are/many/folders/testing.txt");
        printPathInfo(path);
        logStatement(path);
        extraInfo(path);
    }
    private static void printPathInfo(Path path){
        System.out.println("Path: "+path);
        System.out.println("filename: "+ path.getFileName());
        System.out.println("parent: " + path.getParent());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Absolute path:= "+absolutePath);
        System.out.println("Root:= "+ path.getRoot());
        System.out.println("isAbsolute:= "+ path.isAbsolute());
        System.out.println("______________________");

        int j = 1;
        var it = path.toAbsolutePath().iterator();
        while(it.hasNext()){
            System.out.println(".".repeat(j++) + " "+it.next());
        }

        int pathParts = path.toAbsolutePath().getNameCount();
        for(int i = 0; i<pathParts; i++){
            System.out.println(".".repeat(i+1) + " "+ absolutePath.getName(i));
        }
    }
    private static void logStatement(Path path){
        try{
            Path parent = path.getParent();
            if(!Files.exists(parent)){
                Files.createDirectories(parent);
            }
            Files.writeString(path, Instant.now()+": hello File world\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void extraInfo(Path path){
        try{
            var attrs = Files.readAttributes(path, "*");
            attrs.entrySet().forEach(System.out::println);
            System.out.println(Files.probeContentType(path));
        }catch(IOException e){
            System.out.println("PROgebelm");
        }
    }
}
