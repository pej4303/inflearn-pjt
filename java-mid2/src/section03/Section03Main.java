package section03;

import java.util.Arrays;

public class Section03Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        System.out.println(Arrays.toString(arr));

        System.out.println("=== index 변경 ===");
        arr[2] = 10;
        System.out.println(Arrays.toString(arr));

        System.out.println("=== index 조회 ===");
        int value = 10;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println("찾았다");
                return;
            }
        }
    }
}
