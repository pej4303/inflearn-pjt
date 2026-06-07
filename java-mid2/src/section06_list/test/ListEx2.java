package section06_list.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문제2 - 리스트의 입력과 출력
 *
 * - 문제 설명
 * 사용자에게 n개의 정수를 입력받아서 List에 저장하고, 입력 순서대로 출력하자.
 * 0을 입력하면 입력을 종료하고 결과를 출력한다.
 * 출력시 출력 포멧은 1, 2, 3, 4, 5와 같이 쉼표를 사용해서 구분하고, 마지막에는 쉼표를 넣지 않아야 한다.
 * 실행 결과 예시를 참고하자.
 *
 * - 실행결과
 * n개의 정수를 입력하세요 (종료 0)
 * 1
 * 2
 * 3
 * 4
 * 5
 * 0
 * 출력
 * 1, 2, 3, 4, 5
 */
public class ListEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int total = 0;

        System.out.println("n개의 정수를 입력하세요 (종료 0)");

        while (sc.hasNext()) {
            int num = sc.nextInt();

            if (num == 0) {
                System.out.println("출력");

                for (int i=0; i<list.size(); i++) {
                    System.out.print(list.get(i));
                    if (i < list.size() - 1) {
                        System.out.print(", ");
                    }
                }

                break;
            } else {
                list.add(num);
            }
        }
    }
}
