package section3_lambda;

import lambda.MyFunction;

// 람다를 메서드(함수)에 전달하기
public class LambdaPassMain {
//    public static void main(String[] args) {
//        MyFunction add = (a, b) -> a + b;
//        MyFunction sub = (a, b) -> a - b;
//
//        System.out.println("변수를 통해 전달");
//        calculate(add);
//        calculate(sub);
//
//        System.out.println("람다를 직접 전달");
//        calculate((a, b) -> a + b);
//        calculate((a, b) -> a - b);
//    }

    public static void main(String[] args) {
        /**
         * 1. 메서드 호출
         * 2. getOperation() 메서드 안에서 다음 코드가 호출됨
         *    - 반환 타입이 MyFunction 함수형 인터페이스
         *    2-1. 람다 인스턴스 생성
         *    2-2. 람다 인스턴스의 참조값을 반환
         * 3. main 메서드로 람다 인스턴스의 참조값이 반환됨
         *   3-1. 람다 인스턴스의 참조값을 add에 대입
         */
        MyFunction add = getOperation("add");
        System.out.println("add.apply(1, 2) = " + add.apply(1, 2));

        MyFunction sub = getOperation("sub");
        System.out.println("sub.apply(1, 2) = " + sub.apply(1, 2));

        MyFunction xxx = getOperation("xxx");
        System.out.println("xxx.apply(1, 2) = " + xxx.apply(1, 2));
    }

    static void calculate(MyFunction function) {
        int a = 1;
        int b = 2;

        System.out.println("계산 시작");
        int result = function.apply(a, b);
        System.out.println("계산 결과: " + result);
    }

    // 람다를 반환하는 메서드
    static MyFunction getOperation(String operator) {
        switch (operator) {
            case "add":
                return (a, b) -> a + b;
            case "sub":
                return (a, b) -> a - b;
            default:
                return (a , b) -> 0;
        }
    }
}
