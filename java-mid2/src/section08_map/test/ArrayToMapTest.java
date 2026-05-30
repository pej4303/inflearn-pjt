package section08_map.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제1 - 배열을 맵으로 전환
 *
 * - 문제 설명
 * 상품의 이름과 가격이 2차원 배열로 제공된다.
 * 다음 예제를 참고해서 2차원 배열의 데이터를 Map<String, Integer>로 변경해라.
 * 그리고 실행 결과를 참고해서 Map을 출력해라. 출력 순서는 상관없다.
 *
 * - 실행 결과
 * 제품: Java, 가격: 10000
 * 제품: JPA, 가격: 30000
 * 제품: Spring, 가격: 20000
 */
public class ArrayToMapTest {
    public static void main(String[] args) {
        String[][] productArr = {
                {"Java", "10000"},
                {"Spring", "20000"},
                {"JPA", "30000"}
        };

        // 주어진 배열로부터 Map 생성 - 코드 작성
        Map<String, Integer> productMap = new HashMap<>();
        for (int i = 0; i < productArr.length; i++) {
            productMap.put(productArr[i][0], Integer.valueOf(productArr[i][1]));
        }

        // Map의 모든 데이터 출력  - 코드 작성
        productMap.forEach((k, v) -> {
            System.out.println("제품: %s, 가격: %d".formatted(k, v));
        });
    }
}
