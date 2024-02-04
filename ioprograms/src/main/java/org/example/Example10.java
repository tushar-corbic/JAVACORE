package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Example10 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("testing.txt"))) {
//            while(scanner.hasNextLine()){
//                System.out.println(scanner.nextLine());
//            }

            System.out.println(scanner.delimiter());
            scanner.useDelimiter("$");
            scanner.tokens().forEach(System.out::println);

            scanner.findAll("[a-zA-Z]{10,}").map(MatchResult::group).distinct().sorted().forEach(System.out::println);

            var results = scanner.findAll("(.{15})(.{3})(.{12})(.{8})(.{2}).*")
                    .skip(1)
                    .map(m->m.group(5).trim())
                    .distinct()
                    .sorted()
                    .toArray(String[]::new);
            System.out.println(Arrays.toString(results));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
