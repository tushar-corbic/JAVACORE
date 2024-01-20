package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class Example3 {
    public static void main(String[] args) {
        int maxSeat = 100;
        int seatsInRow = 10;
        var stream = Stream.iterate(0, i->i<maxSeat, i->i+1)
                .map(i->new Seat((char)('A'+i/seatsInRow),i%seatsInRow+1)).mapToDouble(Seat::price)
                .sorted()
                .mapToObj("%5.2f"::formatted);
        stream.forEach(System.out::println);
    }
}
