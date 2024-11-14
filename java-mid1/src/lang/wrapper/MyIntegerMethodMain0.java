package lang.wrapper;

public class MyIntegerMethodMain0 {
    public static void main(String[] args) {
        int value = 10;

        // compareTo() 메소드에서 항상 자기 자신과 비교를 해야함
        // value가 객체라면 자기 자신이 값(참조값) 다른 값을 비교하는 메서드를 만드는 것이 더 효율적임
        int i1 = compareTo(value, 5);
        int i2 = compareTo(value, 10);
        int i3 = compareTo(value, 20);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }
    public static int compareTo(int value, int target) {
        int result = 0;
        if (value < target) {
            result = -1;
        } else if (value > target) {
            result = 1;
        }

        return result;
    }
}
