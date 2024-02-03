package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("testing.txt"))) {
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
