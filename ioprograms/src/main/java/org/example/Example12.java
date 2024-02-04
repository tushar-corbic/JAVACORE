package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Example12   {
    public static void main(String[] args) {
        String filename = "fixedWidth.txt";
        try(var resultStream = Files.lines(Path.of(filename))){

        }catch (IOException e){
            e.printStackTrace();
        }

        try(BufferedReader bufferReader = new BufferedReader(new FileReader(filename))){
//            System.out.println(bufferReader.lines().count());
            Pattern pattern = Pattern.compile("\\p{javaWhitespace}+");
//            System.out.println(bufferReader.lines().flatMap(pattern::splitAsStream).count());
            var result = bufferReader.lines()
                    .flatMap(pattern::splitAsStream)
                    .map(w-> w.replaceAll("\\p{Punct}", ""))
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(w-> w, Collectors.counting()));

            result.entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(System.out::println);
        }catch (IOException e){

            e.printStackTrace();
        }

        try{
            String input = Files.readString(Path.of(filename));
            input = input.replaceAll("\\{Punct}", "");

            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(input);
            Map<String, Long> results = new HashMap<>();
            while(matcher.find()){
                String word = matcher.group().toLowerCase();
                if(word.length()>4){
                    results.merge(word, 1L, (o, n)->o+=n);
                }
            }
            var sortedEntries = new ArrayList<>(results.entrySet());
            sortedEntries.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
