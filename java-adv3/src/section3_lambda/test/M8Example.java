package section3_lambda.test;

import lambda.MyReducer;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 8. reduce(또는 fold) 함수 구현하기
 *
 * - 문제 설명
 * 1. 정수 리스트를 입력받아, 모든 값을 하나로 누적(reduce)하는 함수를 만들어보자.
 * 2. reduce(List<Integer> list, int initial, MyReducer reducer) 형태로 구현한다.
 *    MyReducer는 함수형 인터페이스이며, int reduce(int a, int b); 같은 메서드를 가진다.
 *    initial은 누적 계산의 초깃값(예: 0 또는 1 등)을 지정한다.
 * 3. main()에서 예시로 다음과 같은 상황을 실습해보자.
 *    변환1 : 리스트[1,2,3,4]를 모두 더하기
 *    변환2 : 리스트[1,2,3,4]를 모두 곱하기
 *
 * - 실행 결과
 * 리스트: [1, 2, 3, 4]
 * 합(누적 +): 10
 * 곱(누적 *): 24
 */
public class M8Example {
    public static int reduce(List<Integer> list, int initial, MyReducer reducer) {
        // 코드 작성
        int result = initial;

        for (int num : list) {
            result = reducer.reduce(result, num);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("리스트: " + numbers);
        // 1. 합 구하기 (초깃값 0, 덧셈 로직)
        // 코드 작성
//        int result = reduce(numbers, 0 , new  MyReducer() {
//            @Override
//            public int reduce(int a, int b) {
//                return a + b;
//            }
//        });

        int result = reduce(numbers, 0 , (a, b) -> a + b);
        System.out.println("1. 합 구하기 (초깃값 0, 덧셈 로직): " + result);

        // 2. 곱 구하기 (초깃값 1, 곱셈 로직)
        // 코드 작성
        int result2 = reduce(numbers, 1 , (a, b) -> a * b);
        System.out.println("2. 곱 구하기 (초깃값 1, 곱셈 로직): " + result2);
    }
}
