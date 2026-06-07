package section07_set.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 문제4 - 합집합, 교집합, 차집합
 *
 * - 문제 설명
 * 두 숫자의 집합이 제공된다.
 * 집합1: 1, 2, 3, 4, 5
 * 집합2: 3, 4, 5, 6, 7
 * 두 집합의 합집합, 교집합, 차집합을 구해라. 출력 순서는 관계없다.
 * 합집합: 두 집합의 합이다. 참고로 중복은 제거한다.
 * 교집합: 두 집합의 공통 값이다. 참고로 중복은 제거한다.
 * 차집합: 집합1에서 집합2와 같은 값을 뺀 나머지
 * 다음 실행 결과를 참고하자.
 * Set인터페이스의 주요 메서드를 참고하자
 *
 * - 실행 결과
 * 합집합: [1, 2, 3, 4, 5, 6, 7]
 * 교집합: [3, 4, 5]
 * 차집합: [1, 2]
 */
public class SetOperationsTest {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));
        // 코드 작성

        // 합집합
        Set<Integer> unionSet = new HashSet<>();
        unionSet.addAll(set1);
        unionSet.addAll(set2);

        System.out.println("합집합 : " + unionSet.toString());

        // 교집합
        Set<Integer> intersetionSet = new HashSet<>();
        // 방법1)
//        for (Integer numSet1 : set1) {
//            if (set2.contains(numSet1)) {
//                intersetionSet.add(numSet1);
//            }
//        }

        // 방법2) retainAll() : 교집합을 구함
        intersetionSet.addAll(set1);
        intersetionSet.retainAll(set2);

        System.out.println("교집합 : " + intersetionSet.toString());

        // 차집합
        Set<Integer> diffSet = new HashSet<>();
        // 방법1)
//        diffSet.addAll(set1);
//        for (Integer numSet1 : set1) {
//            // 집합2에 있는 항목이면 삭제
//            if (set2.contains(numSet1)) {
//                diffSet.remove(numSet1);
//            }
//        }

        // 방법2) removeAll() : 차집합을 구함
        diffSet.addAll(set1);
        diffSet.removeAll(set2);

        System.out.println("차집합 : " + diffSet.toString());
    }
}
