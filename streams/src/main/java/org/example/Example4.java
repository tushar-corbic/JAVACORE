package org.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example4 {
    public static void main(String[] args) {
        var result = IntStream.iterate(0, i->i<1000, i->i+1)
                .summaryStatistics();
        System.out.println(result);

        // summary statistics, average and sum only work on intstrea, longstream and doublestream
        // the rest count, min, max, works on all streams
        var result2 = Stream.iterate(0, i->i<1000, i->i+1).mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(result2);
        // these is anyMatch, allMatch, noneMatch for the
    }
}
