package section08_map.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제3 - 같은 단어가 나타난 수
 *
 * - 문제 설명
 * 각각의 단어가 나타난 수를 출력해라.
 * 실행 결과를 참고하자
 *
 * - 실행 결과
 * {orange=1, banana=2, apple=3}
 */
public class WordFrequencyTest1 {
    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        // 코드 작성
        String[] wordArr = text.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String word : wordArr) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println(map);
    }
}
