package org.example;

import java.util.function.Function;

public class Example7 {
    public static void main(String[] args) {
        String name = "Tim";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String,String> lastName = s->s.concat("Gupta");
        Function<String,String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

    }
}
