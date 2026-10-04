package section3_lambda.test;

import lambda.MyFunction;

/**
 * 문제 5. 고차 함수(High-Order Function) - 함수를 반환하기
 *
 * - 문제 설명
 * "함수를 반환"하는 방식도 연습해보자.
 * 두 정수를 받아서 연산하는 MyFunction 인터페이스를 사용해보자.
 *
 * 1. static MyFunction getOperation(String operator) 라는 정적 메서드를 만들어라.
 * 2. 매개변수인 operator 에 따라 다음과 같은 내용을 전달하고 반환해라.
 *    2-1. operator가 "add"면, (a, b)를 받아 a + b를 리턴하는 람다를 반환해라.
 *    2-2. "sub"면, a - b를 리턴하는 람다를 반환해라.
 *    2-3. 그 외의 경우는 항상 0을 리턴하는 람다를 반환해라
 * 3. main() 메서드에서 getOperation("add"), getOperation("sub"), getOperation("xxx") 를 각각 호출해서 반환된 람다를 실행해라.
 *
 * - 실행 결과
 * add(1, 2) = 3
 * sub(1, 2) = -1
 * xxx(1, 2) = 0 // 그 외의 경우
 */
public class M5Example {
    static MyFunction getOperation(String operator) {
        switch (operator) {
            case "add":
                return (a,b) -> a+b;
            case "sub":
                return (a,b) -> a-b;
            default:
                return (a,b) -> 0;
        }
    }

    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        System.out.println("add(1, 2) = " + add.apply(1, 2));
        MyFunction sub = getOperation("sub");
        System.out.println("sub(1, 2) = " + sub.apply(1, 2));
        MyFunction xxx = getOperation("xxx");
        System.out.println("xxx(1, 2) = " + xxx.apply(1, 2));
    }
}
