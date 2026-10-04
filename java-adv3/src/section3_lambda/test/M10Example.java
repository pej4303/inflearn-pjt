package section3_lambda.test;

import lambda.MyTransformer;

/**
 * 문제 10. 함수 합성하기 (compose)
 *
 * - 문제 설명
 * 1. 문자열을 변환하는 함수 두 개(MyTransformer 타입)를 받아서, f1을 먼저 적용하고, 그 결과에 f2를 적용하는
 *    새로운 함수를 반환하는 compose 메서드를 만들어보자. 예) f2(f1(x))
 * 2. 예시 상황
 *   f1: 대문자로 바꿈
 *   f2: 문자 앞 뒤에 "**"을 붙임
 *   합성 함수(compose())를 "hello"에 적용하면 → "**HELLO**"
 *
 * - 실행 결과
 * **HELLO**
 */
public class M10Example {
    public static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
        // 코드 작성
//        return new MyTransformer() {
//            @Override
//            public String transform(String s) {
//                String result = f1.transform(s);
//                return f2.transform(result);
//            }
//        };

        return (s) -> {
            String result = f1.transform(s);
            return f2.transform(result);
        };
    }

    public static void main(String[] args) {
        // f1: 대문자로 변환
        MyTransformer toUpper = s -> s.toUpperCase();
        // f2: 앞 뒤에 "**" 붙이기
        MyTransformer addDeco = s -> "**" + s + "**";
        // 합성: f1 → f2 순서로 적용하는 함수
        MyTransformer composeFunc = compose(toUpper, addDeco);
        // 실행
        String result = composeFunc.transform("hello");
        System.out.println(result); // "**HELLO**"
    }
}
