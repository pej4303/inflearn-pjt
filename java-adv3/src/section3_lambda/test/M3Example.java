package section3_lambda.test;

import lambda.Procedure;

import java.util.Arrays;

/**
 * 문제 3. 동작 매개변수화 - 익명 클래스로 다른 로직 전달
 *
 * - 문제 설명
 * 1부터 N까지 더하는 로직과, 배열을 정렬하는 로직을 각각 실행하고, 이 두 가지 로직 모두 실행에 걸린 시간을 측정하고 싶다.
 * "실행 시간 측정" 로직은 변하지 않는 부분
 * "실행할 로직"은 바뀌는 부분(1부터 N까지의 합 구하기 VS 배열 정렬)
 *
 * 이 문제는 람다를 사용하지 말고 익명 클래스를 사용해서 풀어라.
 *
 * - 실행 결과
 * [1부터 100까지 합] 결과: 5050
 * 실행 시간: 4592542ns
 * 원본 배열: [4, 3, 2, 1]
 * 배열 정렬: [1, 2, 3, 4]
 * 실행 시간: 301083ns
 */
public class M3Example {
    public static void measure(Procedure p) {
        long startNs = System.nanoTime();
        p.run();
        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    public static void main(String[] args) {
        measure(new Procedure() {
            @Override
            public void run() {
                int N = 100;
                long sum = 0;
                for (int i = 1; i <= N; i++) {
                    sum += i;
                }

                System.out.println("[1부터 " + N + "까지 합] 결과: " + sum);
            }
        });

        measure(new Procedure() {
            @Override
            public void run() {
                int[] arr = { 4, 3, 2, 1 };
                System.out.println("원본 배열: " + Arrays.toString(arr));
                Arrays.sort(arr);
                System.out.println("배열 정렬: " + Arrays.toString(arr));
            }
        });
    }
}
