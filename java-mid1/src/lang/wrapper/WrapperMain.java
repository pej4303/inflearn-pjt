package lang.wrapper;

import java.util.Arrays;

public class WrapperMain {
    public static void main(String[] args) {
        /**
         * -127 ~ 128까지 자바가 문자열풀처럼 미리 만들어놓음
         * new 연산자를 이용해서 매번 새로운 객체를 만드는 것보다
         * 미리 만들어져 있는 값을 가져오는게 효율적이여서 이 방법을 더 권장함
         */
        Integer num1 = Integer.valueOf(10);
        System.out.println("num1 = " + num1.intValue());
        // 이 방법은 없어질 예정
        Integer newNum1 = new Integer(10);

        /**
         * == 비교시 서로 다른 객체이기때문에 false가 나옴
         * 래퍼 클래스는 값 비교를 "equals"로 해야됨
         */
        System.out.println("== 비교 : " + (num1 == newNum1));
        System.out.println("equals 비교 : " + num1.equals(newNum1) );
        /**
         * valueOf()를 이용해서 같은 숫자일때는 == 비교도 true로 나옴
         */
        Integer num2 = Integer.valueOf(10);
        System.out.println("== 비교 : " + (num1 == num2));
        System.out.println("equals 비교 : " + num1.equals(num2) );
    }
}
