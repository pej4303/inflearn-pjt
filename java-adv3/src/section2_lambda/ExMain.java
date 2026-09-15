package section2_lambda;

import java.util.Random;

public class ExMain {
    public static void helloJava() {
        System.out.println("프로그램 시작");
        System.out.println("Hello Java");
        System.out.println("프로그램 종료");
    }

    public static void helloSpring() {
        System.out.println("프로그램 시작");
        System.out.println("Hello Spring");
        System.out.println("프로그램 종료");
    }

    /**
     * 재사용 가능하게 변경 => 값 매개변수화(Value Parameterization)
     * @param str
     */
    public static void hello(String str) {
        if (str.isEmpty() || str.isBlank()) {
            return;
        }

        System.out.println("프로그램 시작");         // 변하지 않는 부분
        System.out.println("Hello ".concat(str));   // 변하는 부분
        System.out.println("프로그램 종료");         // 변하지 않는 부분
    }

    public static void helloDice() {
        long startNs = System.nanoTime();

        //코드 조각 시작
        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("주사위 = " + randomValue);
        //코드 조각 종료

        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    public static void helloSum() {
        long startNs = System.nanoTime();

        //코드 조각 시작
        for (int i = 1; i <= 3; i++) {
            System.out.println("i = " + i);
        }
        //코드 조각 종료

        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    public static void hello2(String str) {
        if (str.isEmpty() || str.isBlank()) {
            return;
        }

        long startNs = System.nanoTime();

        //코드 조각 시작
        if ("Sum".equals(str)) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("i = " + i);
            }
        } else {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        }
        //코드 조각 종료
    }

    /**
     * 람다로 변경
     * @param runnable
     */
    public static void hello3(Runnable runnable) {
        long startNs = System.nanoTime();
        // 전달받은 코드 실행
        runnable.run();
        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    public static void main(String[] args) {
        /**
         * 예시1) 문자열만 전달 =>
         *       값 매개변수화 : 숫자, 문자열 등을 변경해서 메소드의 동작을 다르게 함
         */
        // 기존 코드
//        // helloJava();
//        // helloSpring();
//
//        hello("Java");
//        hello("Spring");

        /**
         * 예시2) 코드조각을 전달 =>
         *        동작 매개변수화 : 어떤 로직을 수행할지 메소드에 전달(인스턴스 참조, 람다등)
         */
        // 기존 코드
//        helloDice();
//        helloSum();

        // 개선 코드
//        hello2("Dice");
//        hello2("Sum");

        /**
         * 예시2) 람다로 변경
         */
        // 주사위 코드 전달
        hello3(() -> {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        });
        // 합계 코드 전달
        hello3(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("i = " + i);
            }
        });
    }
}