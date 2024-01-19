package org.example;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(1,2,3,4,4,5,6,73,3,22));
        arr.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        Stream.of("One","Two", "Three").sorted().map(String::toUpperCase).forEach(System.out::println);

        String[] strings = {"one","two","three"};
        var firstStream = Arrays.stream(strings).sorted(Comparator.reverseOrder());
        var secondStream = Stream.of("One","two","three").map(String::toUpperCase);
        Stream.concat(secondStream, firstStream).forEach(System.out::println);

        Random random = new Random();
        Stream.generate(()->random.nextInt(2))
                .limit(10)
                .forEach(s->System.out.print(s+ " "));
        System.out.println();
        IntStream.iterate(1, n->n+1)
                .limit(20)
                .forEach(s->System.out.print(s+" "));
    }
}