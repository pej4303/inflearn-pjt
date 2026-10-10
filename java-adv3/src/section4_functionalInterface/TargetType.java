package section4_functionalInterface;

import java.util.function.Function;

public class TargetType {
    public static void main(String[] args) {
        // 람다 직접 대입: 문제 없음
//        FunctionA functionA = i -> "value = " + i;
//        FunctionB functionB = i -> "value = " + i;

        // 이미 만들어진 FunctionA 인스턴스를 FunctionB에 대입: 불가능
//        FunctionB targetB = functionA; // 컴파일 에러!

        // 자바가 기본적으로 제공하는 함수형 인터페이스 사용
        Function<String, String> upperCase = i -> i.toUpperCase();
        String result1 = upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        Function<Integer, Integer> square = i -> i * i;
        Integer result2 = square.apply(100);
        System.out.println("result2 = " + result2);

        // 자바가 기본적으로 제공하는 함수형 인터페이스를 이용해서 람다 직접 대입
        Function<Integer, String> functionA = i -> "value = " + i;
        System.out.println(functionA.apply(10));

        Function<Integer, String> functionB = functionA;
        System.out.println(functionB.apply(20));
    }

    @FunctionalInterface
    interface FunctionA {
        String apply(Integer i);
    }

    @FunctionalInterface
    interface FunctionB {
        String apply(Integer i);
    }
}
