package section3_lambda.test;

/**
 * 문제 1. 중복되는 메시지 출력 로직 리팩토링
 *
 * - 문제 설명
 * 다음 코드는 화면에 여러 종류의 인삿말 메시지를 출력하지만, 모든 메서드마다
 * === 시작 === 과 === 끝 === 을 출력하는 로직이 중복되어 있다. 중복되는 코드를 제거하고,
 * 변하는 부분(인삿말 메시지)만 매개변수로 받도록 리팩토링해라.
 *
 * - 실행 결과
 * === 시작 ===
 * Good Morning!
 * === 끝 ===
 * === 시작 ===
 * Good Afternoon!
 * === 끝 ===
 * === 시작 ===
 * Good Evening!
 * === 끝 ===
 */
public class M1Example {
    public static void greetMorning() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Morning!");
        System.out.println("=== 끝 ===");
    }

    public static void greetAfternoon() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Afternoon!");
        System.out.println("=== 끝 ===");
    }

    public static void greetEvening() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Evening!");
        System.out.println("=== 끝 ===");
    }

    public static void greet(String msg) {
        System.out.println("=== 시작 ===");
        System.out.println(msg);
        System.out.println("=== 끝 ===");
    }

    public static void main(String[] args) {
//        greetMorning();
//        greetAfternoon();
//        greetEvening();

        greet("Good Morning!");
        greet("Good Afternoon!");
        greet("Good Evening!");
    }
}