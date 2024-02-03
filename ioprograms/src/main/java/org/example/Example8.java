package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example8 {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("testing.txt")){
            int data ;
            while((data=reader.read())!=-1){
                System.out.println((char)data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try(BufferedReader buffferedReader = new BufferedReader(new FileReader("testing.text"))){
            buffferedReader.lines().forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
