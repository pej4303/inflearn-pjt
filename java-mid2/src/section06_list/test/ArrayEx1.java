package section06_list.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제1 - 배열을 리스트로 변경하기
 *
 * - 문제 설명
 * ArrayEx1는 배열을 사용한다. 이 코드를 배열 대신에 리스트를 사용하도록 변경하자.
 *
 * - 실행 결과
 * 점수 총합: 350
 * 점수 평균: 70.0
 *
 */
public class ArrayEx1 {
    public static void main(String[] args) {
        // 기존 코드
//        int[] students = {90, 80, 70, 60, 50};
//
//        int total = 0;
//        for (int i = 0; i < students.length; i++) {
//            total += students[i];
//        }
//
//        double average = (double) total / students.length;
//        System.out.println("점수 총합: " + total);
//        System.out.println("점수 평균: " + average);

        // 변경
        List<Double> students = new ArrayList<>();
        students.add(90.0);
        students.add(80.0);
        students.add(70.0);
        students.add(60.0);
        students.add(50.0);

        int total = 0;
        for (int i = 0; i < students.size(); i++) {
            total += students.get(i);
        }

        double average = (double) total / students.size();
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);
    }


}