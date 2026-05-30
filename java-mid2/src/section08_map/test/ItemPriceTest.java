package section08_map.test;

import java.util.*;

/**
 * 문제4 - 값으로 검색
 *
 * - 문제 설명
 * 다음 예제에서 Map에 들어있는 데이터 중에 값이 1000원인 모든 상품을 출력해라.
 * 실행 결과를 참고하자.
 *
 * - 실행 결과
 * [망고, 딸기]
 */
public class ItemPriceTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 500);
        map.put("바나나", 500);
        map.put("망고", 1000);
        map.put("딸기", 1000);

        // 코드 작성
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value == 1000) {
                set.add(key);
            }
        }

        System.out.println(set);
    }
}
