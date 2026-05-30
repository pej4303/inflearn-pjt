package section08_map.test;

import java.util.*;

/**
 * 문제2 - 공통의 합
 *
 * - 문제 설명
 * map1과 map2에 공통으로 들어있는 키를 찾고, 그 값의 합을 구해라.
 * 실행 결과를 참고하자.
 *
 * - 실행 결과
 * {B=6, C=8}
 */
public class CommonKeyValueSum1 {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);

        // Map.of() 이용
        Map<String, Integer> map2 = Map.of("B", 4, "C", 5, "D", 6);

        // 코드 작성
        Map<String, Integer> map3 = new HashMap<>();

        for (String key : map1.keySet()) {
            for (String key2 : map2.keySet()) {
                if (key.equals(key2)) {
                    int num1 = map1.get(key);
                    int num2 = map2.get(key2);

                    map3.put(key, num1 + num2);
                }
            }
        }

        System.out.print(map3);
    }
}
