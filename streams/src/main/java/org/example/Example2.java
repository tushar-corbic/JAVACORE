package org.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example2 {
    public static void main(String[] args) {
        var stream1 = Stream.iterate(1, n->n<=15, n->n+1 ).map(e-> "b"+"-"+Integer.toString(e));
        var stream2 = Stream.iterate(16, n -> n <= 30, n -> n + 1).map(e -> "i" + "-" + Integer.toString(e));
        var stream3 = Stream.iterate(31, n->n<=45, n->n+1 ).map(e-> "n"+"-"+Integer.toString(e));
        Stream.concat(stream1, Stream.concat(stream2, stream3)).forEach(System.out::println);
    }
}
