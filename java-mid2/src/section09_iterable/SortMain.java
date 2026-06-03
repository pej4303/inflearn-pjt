package section09_iterable;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain {
    public static void main(String[] args) {
        Integer[] myArray = {3, 2, 1};

        Arrays.sort(myArray, new AscComparator());
        System.out.println("정렬 후");
        System.out.println(Arrays.toString(myArray));
    }

    // 정렬 기준
    static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1 = " + o1 + ", o2 = " + o2);

            if (o1 < o2) {
                return -1;
            } else if (o1 == o2) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
