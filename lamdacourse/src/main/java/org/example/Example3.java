package org.example;

public class Example3 {
    public static void main(String[] args) {
        int result = calculator((a, b)-> a+b, 2, 3);
        int result2 = calculator((Integer a, Integer b)-> a-b, 2, 3);
        var result3 = calculator((a,b)->a/b, 1.0, 2.9);
    }
    public static <T> T calculator(Operation<T> function, T value1, T value2){
        T  result = function.operate(value1, value2);
        System.out.println("Result of Operation "+ result);
        return result;
    }
}
