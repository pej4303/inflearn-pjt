package section3_lambda.test;

import lambda.MyPredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 6. filter 함수 구현하기
 *
 * - 문제 설명
 * 1. 정수 리스트가 주어졌을 때, 특정 조건에 맞는 요소들만 뽑아내는 filter 함수를 직접 만들어보자.
 * 2. filter(List<Integer> list, MyPredicate predicate) 형식의 정적 메서드를 하나 작성한다.
 *    MyPredicate는 함수형 인터페이스이며, boolean test(int value); 같은 메서드를 가진다.
 * 3. main()에서 예시로 다음과 같은 상황을 실습해보자.
 *   리스트: [-3, -2, -1, 1, 2, 3, 5]
 *   조건 1: 음수(negative)만 골라내기
 *   조건 2: 짝수(even)만 골라내기
 *
 * - 실행 결과
 * 원본 리스트: [-3, -2, -1, 1, 2, 3, 5]
 * 음수만: [-3, -2, -1]
 * 짝수만: [-2, 2]
 */
public class M6Example {
    // 고차 함수, 함수를 인자로 받아서 조건에 맞는 요소만 뽑아내는 filter
    public static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        List<Integer> result = new ArrayList<>();
        for (int val : list) {
            if (predicate.test(val)) {
                result.add(val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3, -2, -1, 1, 2, 3, 5);
        System.out.println("원본 리스트: " + numbers);
        // 1. 음수(negative)만 뽑아내기
        // 코드 작성
        List<Integer> result = filter(numbers, num -> num <0);
        System.out.println("1. 음수(negative)만 뽑아내기 : " + result);
        // 2. 짝수(even)만 뽑아내기
        // 코드 작성
//        List<Integer> result2 = filter(numbers, new MyPredicate() {
//            @Override
//            public boolean test(int value) {
//                return value % 2 == 0;
//            }
//        });

        List<Integer> result2 = filter(numbers, num -> num % 2 == 0);
        System.out.println("2. 짝수(even)만 뽑아내기 : " + result2);
    }
}