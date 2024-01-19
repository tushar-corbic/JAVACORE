package org.example;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Example5 {
    public static void main(String[] args) {
        Consumer<String> p1 = (String s)->{
            String[] parts = s.split(" ");
            Arrays.asList(parts).forEach(ss->System.out.println(ss));
            for(String part: parts){
                System.out.println(part);
            }
        };
        p1.accept("Tushar is good and he is doing yoga");

        UnaryOperator<String> ss = (String string) -> {
            StringBuilder returnval = new StringBuilder();
            for(int i =0; i<string.length(); i++){
                if(i%2==1){
                    returnval.append(string.charAt(i));
                }
            }
            return returnval.toString();
        };
        Supplier<String> p2  = ()->{
            return "I love Java";
        };
        String iLoveJava = p2.get();
        System.out.println(iLoveJava);

    }

}
