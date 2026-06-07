package section06_list.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문제3 - 합계와 평균
 *
 * - 문제 설명
 * 사용자에게 n개의 정수를 입력받아서 List에 보관하고, 보관한 정수의 합계와 평균을 계산하는 프로그램을 작성하자.
 * ListEx3에 작성하자.
 *
 *  - 실행결과
 * n개의 정수를 입력하세요 (종료 0)
 * 1
 * 2
 * 3
 * 4
 * 5
 * 0
 * 입력한 정수의 합계: 15
 * 입력한 정수의 평균: 3.0
 */
public class ListEx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요 (종료 0)");

        while (sc.hasNext()) {
            int num = sc.nextInt();

            if (num == 0) {
                if (list.size() == 0) {
                    break;
                }

                int total = list.stream().mapToInt(Integer::intValue).sum();
                double avg = list.stream().mapToDouble(Integer::intValue).average().getAsDouble();

                System.out.println("입력한 정수의 합계: %d".formatted(total));
                System.out.println("입력한 정수의 평균: %.1f".formatted(avg));

                break;
            } else {
                list.add(num);
            }
        }
    }
}
