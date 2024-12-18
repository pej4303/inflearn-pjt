package lang.wrapper;

import java.math.BigInteger;

public class WrapperTest {
    public static void main(String[] args) {
//        test(); // 0.4초
        test2(); // 3.7초
    }

    /**
     * 기본형
     */
    public static void test() {
        int repeatCnt = 1_000_000_000;    // 반복 횟수 : 10억

        long startTime = System.currentTimeMillis();
        long result = 0;

        for (int i=0; i<repeatCnt; i++){
            result += i;
        }

        long endTime = System.currentTimeMillis();

        System.out.println("result = " + result);
        System.out.println("실행시간 = " + (endTime - startTime) + "ms");
    }

    /**
     * 래퍼클래스
     */
    public static void test2() {
        int repeatCnt = 1_000_000_000;    // 반복 횟수 : 10억

        long startTime = System.currentTimeMillis();
        Long result = 0L;

        for (int i=0; i<repeatCnt; i++){
            result += i;   // 오토박싱 발생(int -> Long)
        }

        long endTime = System.currentTimeMillis();

        System.out.println("result = " + result);
        System.out.println("실행시간 = " + (endTime - startTime) + "ms");
    }
}
