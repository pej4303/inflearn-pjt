package section3_lambda.test;

import lambda.Procedure;

import java.util.Arrays;

/**
 * 문제 4. 람다로 변경 - 간결하게 코드 작성하기
 *
 * - 문제 설명
 * 이전 문제에서 익명 클래스로 작성한 부분을 람다로 변경해라.
 * measure() 메서드와 Procedure 인터페이스는 그대로 둔다.
 * main()에서 익명 클래스를 사용하지 말고, 람다를 이용하여 더욱 간결하게 코드를 작성해라.
 *
 * - 실행 결과
 */
public class M4Example {
    public static void measure(Procedure p) {
        long startNs = System.nanoTime();
        p.run();
        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    public static void main(String[] args) {
        measure(() -> {
            int N = 100;
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += i;
            }

            System.out.println("[1부터 " + N + "까지 합] 결과: " + sum);
        });

        measure(() -> {
            int[] arr = { 4, 3, 2, 1 };
            System.out.println("원본 배열: " + Arrays.toString(arr));
            Arrays.sort(arr);
            System.out.println("배열 정렬: " + Arrays.toString(arr));
        });
    }
}
