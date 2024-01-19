package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha","bravo","charlie","delta"
        ));
//        for(String s : list){
//            System.out.println(s);
//        }
//
//        list.forEach((String s)->System.out.println(s));
//        list.forEach( s->System.out.println(s));

        String prefix = "not0";
//        prefix = "yoga";
//        String s = "tuga";
        list.forEach((s)->{
            char first = s.charAt(0);
            System.out.println(s+" means "+first+prefix);
        });
//        String s = "tuga";
//        prefix="yoga";
    }
}
