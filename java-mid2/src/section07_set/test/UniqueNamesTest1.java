package section07_set.test;

import java.util.HashSet;
import java.util.Set;

/**
 * 문제1 - 중복 제거
 *
 * - 문제 설명
 * 여러 정수가 입력된다. 여기서 중복 값을 제거하고 값을 출력해라.
 * 30, 20, 20, 10, 10이 출력되면 중복을 제거하고 출력하면 된다. 출력 순서는 관계없다.
 * 출력 예): 30, 20, 10 또는 10, 20, 30 또는 20, 10, 30 등과 같이 출력 순서는 관계 없다
 *
 * - 실행 결과
 * 20
 * 10
 * 30
 *
 */
public class UniqueNamesTest1 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        // 코드 작성

        Set<Integer> integerSet = new HashSet<>();

        for (Integer num : inputArr) {
            integerSet.add(num);
        }

        // 출력
        integerSet.stream().forEach(System.out::println);
    }
}
