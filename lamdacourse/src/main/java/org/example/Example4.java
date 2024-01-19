package org.example;


import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class Example4 {
    public static void main(String[] args) {
        int result = calculator((a, b)-> a+b, 2, 3);
        int result2 = calculator((Integer a, Integer b)-> a-b, 2, 3);
        var result3 = calculator((a,b)->a/b, 1.0, 2.9);
        var cords = Arrays.asList(
                new double[]{23.33,32.21},
                new double[]{26,31.30},
                new double[]{75.56,74.34}
        );
        cords.forEach(s->System.out.println(Arrays.toString(s)));
        BiConsumer<Double, Double> p1 = (lat, lng)->System.out.println(lat+" "+lng);
        processPoint( cords.get(0)[0],cords.get(0)[1],p1);
    }
    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T  result = function.apply(value1, value2);
        System.out.println("Result of Operation "+ result);
        return result;
    }
    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1, t2);
    }
}

