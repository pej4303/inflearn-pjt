package section3_lambda.test;

import lambda.StringFunction;


/**
 * 문제 9.  함수를 반환하는 buildGreeter 만들기
 *
 * - 문제 설명
 * 1. 문자열을 입력받아, 새로운 함수를 반환해주는 buildGreeter(String greeting)라는 메서드를 작성하자.
 *    buildGreeter("Hello") -> "Hello"를 사용하는 새로운 함수 반환
 *    새로운 함수는 입력받은 문자열에 대해  "Hello"(greeting) + ", " + (입력받은 문자열) 형태로 결과를 반환
 * 2. 함수를 반환받은 뒤에, 실제로 그 함수를 호출해 결과를 확인해보자.
 *
 * - 실행 결과
 * Hello, Java
 * Hi, Lambd
 */
public class M9Example {
    public static StringFunction buildGreeter(String greeting) {
        // 코드 작성
        return (str) -> greeting + ", " + str ;
    }

    public static void main(String[] args) {
        // 코드 작성
        StringFunction helloGreeter = buildGreeter("Hello");
        StringFunction hiGreeter = buildGreeter("Hi");

        System.out.println(helloGreeter.apply("Java"));
        System.out.println(hiGreeter.apply("Lambda"));
    }
}
