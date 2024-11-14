package lang.string;

public class LoopStringTest {
    public static void main(String[] args) {
        test();
        // test2();

        /**
         * 정리
         *
         * 1. 문자열을 합칠때는 "+" 연산을 사용하면 됨(최적화가 다 되어있음)
         * 2. StringBuilder를 사용해야 하는 경우
         *  - 반복문(만번 이상)에서 반복해서 문자열을 조합할 때
         *  - 조건문을 통해 동적으로 문자열을 조합할 때
         *  - 복잡한 문자열의 특정 부분을 변경해야 할 때
         *  - 매우 긴 대용량 문자열을 다룰 때
         */
    }

    public static void test() {
        long startTime = System.currentTimeMillis();
        String result = "";

        for (int i=0; i<100000; i++){
           result += "Hello Java";
//            System.out.println(i);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("result = " + result);
        System.out.println("실행시간 = " + (endTime - startTime) + "ms");
    }

    /**
     * StringBuilder로 변경
     */
    public static void test2() {
        long startTime = System.currentTimeMillis();
        StringBuilder result = new StringBuilder();

        for (int i=0; i<100000; i++){
            result.append("Hello Java");
        }

        long endTime = System.currentTimeMillis();

        System.out.println("result = " + result);
        System.out.println("실행시간 = " + (endTime - startTime) + "ms");
    }
}
