package org.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Example11 {
    public static void main(String[] args) {
         System.out.println(System.getProperty("file.encoding"));
         System.out.println(Charset.defaultCharset());

         Path path = Path.of("fixedWidth.txt");
//         try{
////             System.out.println(new String(Files.readAllBytes(path)));
////             System.out.println(Files.readAllLines(path));
//
////             System.out.println(Files.readString(path));
             Pattern p = Pattern.compile("(.{15})(.{3})(.{12})(.{8})(.{2}).*");
             Set<String> values = new TreeSet<>();
//             Files.readAllLines(path).stream().skip(1).forEach(s->{
//                 Matcher matcher = p.matcher(s);
//                 if(matcher.matches()){
//                     values.add(matcher.group(3).trim());
//                 }
//             });
//             System.out.println(values);
//         }catch (IOException e){
//
//             e.printStackTrace();
//         }
        try(var stringStream = Files.lines(path)){
            var results = stringStream.skip(1)
                    .map(p::matcher)
                    .filter(Matcher::matches)
                    .map(m->m.group(3).trim())
                    .distinct()
                    .sorted()
                    .toArray(String[]::new);
            System.out.println(Arrays.toString(results));

        }catch (IOException e){
            e.printStackTrace();
        }
        try(var stringStream = Files.lines(path)){
            var results = stringStream.skip(1)
                    .map(p::matcher)
                    .filter(Matcher::matches)
                    .collect(Collectors.groupingBy(m->m.group(3).trim(), Collectors.counting()));
            System.out.println(results);
            results.entrySet().forEach(System.out::println);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
