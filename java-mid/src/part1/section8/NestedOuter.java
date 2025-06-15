package part1.section8;

public class NestedOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    /**
     * 정적 중첩 클래스
     */
    static class Nested {
        private int value = 1;

        public void print() {
            // 자기 클래스 멤버 변수에 접근
            System.out.println("Nested.value = %d".formatted(value));
            // NestedOuter 클래스의 멤버 변수에 접근 -> static으로 선언되어서 접근 할 수 없다.
            // System.out.println(outInstanceValue);
            
            // NestedOuter 클래스의 static 멤버 변수에 접근
            System.out.println("NestedOuter.outInstanceValue = %d".formatted(outClassValue));
        }
    }
}
