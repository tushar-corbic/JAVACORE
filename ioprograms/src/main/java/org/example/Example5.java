package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class Example5 {
    public static void main(String[] args) {
        Path path = Path.of("");
        System.out.println("CWD:=" + path.toAbsolutePath());

        try(Stream<Path> paths = Files.list(path)) {
            paths.map(Example5::listDir).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("------------------------------");

        try(Stream<Path> paths = Files.walk(path, 2)) {
            paths.filter(Files::isRegularFile).map(Example5::listDir).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("------------------------------");

        try(Stream<Path> paths = Files.find(path, 2, (p, attr)->Files.isRegularFile(p))) {
            paths.map(Example5::listDir).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("------------------------------");

        try(Stream<Path> paths = Files.find(path, 2, (p, attr)->attr.isRegularFile())) {
            paths.map(Example5::listDir).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String listDir(Path path){
        try{
            boolean isDir = Files.isDirectory(path);
            FileTime dateField = Files.getLastModifiedTime(path);
            LocalDateTime modDT = LocalDateTime.ofInstant(dateField.toInstant(), ZoneId.systemDefault());
            return "%tD %tT %-5s %12s %s".formatted(modDT,modDT, (isDir? "<DIR>":""),(isDir?"":Files.size(path)), path);
//            return "%s %-15s %s".formatted(modDT, (isDir? "<DIR>":""), path);
        }catch (IOException e){
            e.printStackTrace();
            return path.toString();
        }
    }
}
