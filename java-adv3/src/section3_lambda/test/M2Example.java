package section3_lambda.test;

/**
 * 문제 2. 값 매개변수화 - 다양한 단위를 매개변수로 받기
 *
 * - 문제 설명
 * 다음 코드는, 주어진 숫자(예: 10)를 특정 단위(예: "kg")로 출력하는 간단한 메서드를 작성한 예시이다.
 * 숫자와 단위를 나누고 재사용 가능한 메서드를 사용하도록 코드를 수정해라.
 *
 * - 실행 결과
 * 무게: 10kg
 * 무게: 50kg
 * 무게: 200g
 * 무게: 40g
 */
public class M2Example {

    public static void print1() {
        System.out.println("무게: 10kg");
    }

    public static void print2() {
        System.out.println("무게: 50kg");
    }

    public static void print3() {
        System.out.println("무게: 200g");
    }

    public static void print4() {
        System.out.println("무게: 40g");
    }


    public static void print(String msg) {
        System.out.println("무게: %s".formatted(msg));
    }

    public static void main(String[] args) {
//        print1();
//        print2();
//        print3();
//        print4();

        print("10kg");
        print("50kg");
        print("200g");
        print("40g");
    }
}