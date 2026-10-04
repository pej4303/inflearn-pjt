package section3_lambda.test;

import lambda.StringFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 7. map 함수 구현하기
 *
 * - 문제 설명
 * 1. 문자열 리스트를 입력받아, 각 문자열을 어떤 방식으로 변환(map, mapping)할지 결정하는 함수(map)를 만들어보자.
 * 2. map(List<String> list, StringFunction func) 형태로 구현한다.
 *    StringFunction은 함수형 인터페이스이며, String apply(String s); 같은 메서드를 가진다.
 * 3. main()에서 예시로 다음과 같은 상황을 실습해보자.
 *    변환1 : 모든 문자열을 대문자로 변경
 *    변환2 : 문자열 앞 뒤에 ***를 붙여서 반환(hello -> ***hello***)
 *
 * - 실행 결과
 * 원본 리스트: [hello, java, lambda]
 * 대문자 변환 결과: [HELLO, JAVA, LAMBDA]
 * 특수문자 데코 결과: [***hello***, ***java***, ***lambda***]
 */
public class M7Example {
    public static List<String> map(List<String> list, StringFunction func) {
        // 코드 작성
        List<String> result = new ArrayList<>();
        for (String str : list) {
            result.add(func.apply(str));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);
        // 1. 대문자 변환
        // 코드 작성
//        List<String> result = map(words, new StringFunction() {
//            @Override
//            public String apply(String word) {
//                return word.toUpperCase();
//            }
//        });

        List<String> result = map(words, word -> word.toUpperCase());
        System.out.println("1. 대문자 변환 : " + result);

        // 2. 앞뒤에 *** 붙이기 (람다로 작성)
        // 코드 작성
//        List<String> result2 = map(words, new StringFunction() {
//            @Override
//            public String apply(String word) {
//                return "***" + word + "***";
//            }
//        });

        List<String> result2 = map(words, word -> "***" + word + "***");
        System.out.println("2. 앞뒤에 *** 붙이기 : " + result2);
    }
}