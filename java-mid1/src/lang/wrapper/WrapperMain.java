package lang.wrapper;

import java.util.Arrays;

public class WrapperMain {
    public static void main(String[] args) {
        autoBoxing();
    }

    public static void wrapper1() {
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

    public static void wrapper2() {
        // 캐싱 범위 내 (-128 ~ 127)
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b); // true (캐싱된 동일 객체 참조)

        // 캐싱 범위 초과
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d); // false (서로 다른 객체 생성)

        // 값 자체 비교를 원할 경우 equals()를 사용해야 함
        System.out.println(c.equals(d)); // true (값이 동일하므로)
    }

    /**
     * 오토방식, 언방식
     */
    public static void autoBoxing() {
        // 기본형 -> 래퍼로 변경
        int value = 1;
        // Integer boxedValue = Integer.valueOf(value);
        Integer boxedValue = value; // 오토 박싱(Auto-Boxing)
        // 래퍼 -> 기본형으로 변경
        // int i = boxedValue.intValue();
        int i = boxedValue;        // 오토 언박싱(Auto-Unboxing)

        /**
         * 오토박싱, 오토언박싱 : 기본형과 래퍼클래스간의 자동 형변환을 해주는 것, 자바 1.5버전부터 추가되었음
         */
        System.out.println("오토박싱 = " + boxedValue);
        System.out.println("언박싱 = " + i);
    }
}
