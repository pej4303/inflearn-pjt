package enumeration;

import java.util.Arrays;

/**
 * 6장. 열거형
 */
public class EnumMain {
    public static void main(String[] args) {
//        test1();
//       test2();

        discountTest();
    }

    /**
     * 타입 안전 열거형 패턴
     */
    public static void test1() {
        System.out.println("class BASIC = " + ClassGrade.BASIC.getClass());
        System.out.println("class GOLD = " + ClassGrade.GOLD.getClass());
        System.out.println("class DIAMOND = " + ClassGrade.DIAMOND.getClass());

        // 참조값 출력
        System.out.println("ref BASIC = " + ClassGrade.BASIC);
        System.out.println("ref GOLD = " + ClassGrade.GOLD);
        System.out.println("ref DIAMOND = " + ClassGrade.DIAMOND);
    }

    /**
     * enum
     */
    public static void test2() {
        System.out.println("class BASIC = " + Grade.BASIC.getClass());
        System.out.println("class GOLD = " + Grade.GOLD.getClass());
        System.out.println("class DIAMOND = " + Grade.DIAMOND.getClass());

        // 이렇게 출력하면 enum이 toString()을 오버라이딩해서 참조값 확인을 할 수 없음
        // System.out.println("ref BASIC = " + Grade.BASIC);

        // 참조값 출력
        System.out.println("ref BASIC = " + refValue(Grade.BASIC));
        System.out.println("ref GOLD = " + refValue(Grade.GOLD));
        System.out.println("ref DIAMOND = " + refValue(Grade.DIAMOND));

    }

   /**
     * 참조값 출력
     * @param obj
     * @return
     */
    private static String refValue(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static void discountTest1() {
        int price = 10000;
        DiscountService discountService = new DiscountService();

        int price1 = discountService.discount2(Grade.BASIC, price);
        System.out.println("BASIC 등급의 할인 금액: " + price1);

        int price2 = discountService.discount2(Grade.GOLD, price);
        System.out.println("GOLD 등급의 할인 금액: " + price2);

        int price3 = discountService.discount2(Grade.DIAMOND, price);
        System.out.println("DIAMOND 등급의 할인 금액: " + price3);
    }

    /**
     * enum의 할인율 계산 메소드를 이용해서 구함
     */
    public static void discountTest() {
        int price = 10000;

        int price1 =  GradeRef.BASIC.discount(price);
        System.out.println("BASIC 등급의 할인 금액: " + price1);

        int price2 = GradeRef.GOLD.discount(price);
        System.out.println("GOLD 등급의 할인 금액: " + price2);

        int price3 = GradeRef.DIAMOND.discount(price);
        System.out.println("DIAMOND 등급의 할인 금액: " + price3);

    }

    public static void enumMethodTest() {
        /**
         * values() : 모든 ENUM 상수를 포함하는 배열을 반환
         * valueOf(String name) : 주어진 이름과 일치하는 ENUM 상수를 반환
         * name() : ENUM 상수의 이름을 문자열로 반환
         * ordinal() : ENUM 상수의 선언 순서(0부터 시작)를 반환
         */

        // 모든 enum 반환
        Grade[] values = Grade.values();
        System.out.println("values = " + Arrays.toString(values));

        for (Grade value : values) {
            System.out.println("name=" + value.name() + ", ordinal=" +
                    value.ordinal());
        }

        // String -> enum 변환, 잘못된 문자면 IllegalArgumentException 발생
        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println("gold = " + gold); // toString() 오버라이딩 가능
    }
}
