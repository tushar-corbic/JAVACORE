package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Example6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Anna","Bob","Chuck","Dave"));
        list.forEach(System.out::println);
        UnaryOperator<String>pp = String::toUpperCase;
        Function<String, String> ppp= (s)->{
            return s +" "+ new StringBuilder(s).reverse().toString();
        };
        list.forEach(s->System.out.println(pp.apply(s)));
        list.forEach(s->System.out.println(ppp.apply(s)));
    }
}
