package section06_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyListTest2 {
    public static void main(String[] args) {
        int size = 50_000;
        int loop = 10_000;

        System.out.println("== ArrayList ==");
        addFirst(new ArrayList<>(), size);
        addMid(new ArrayList<>(), size);  // 찾는데 O(1), 데이터 추가 O(n)

        ArrayList<Integer> arrayList = new ArrayList<>();
        addLast(arrayList, size);  // 찾는데 O(1), 데이터 추가 O(1)

        System.out.println("== ArrayList 조회 ==");
        getIndex(arrayList, loop, 0); // O(1)
        getIndex(arrayList, loop, size /2); // O(1)
        getIndex(arrayList, loop, size -1); // O(1)

        System.out.println("== LinkedList ==");
        addFirst(new LinkedList<>(), size);
        addMid(new LinkedList<>(), size); // 찾는데 O(n), 데이터 추가 O(1)

        LinkedList<Integer> linkedList = new LinkedList<>();
        addLast(linkedList, size); // 찾는데 O(n), 데이터 추가 O(1)

        System.out.println("== LinkedList 조회 ==");
        getIndex(linkedList, loop, 0); // O(1)
        getIndex(linkedList, loop, size /2); // O(n)
        getIndex(linkedList, loop, size -1); // O(1)

    }

    private static void addFirst(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i=0; i<size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("앞에서 추가 - 크기 : %d, 계산 시간 : %d ms".formatted(size, (endTime - startTime)));
    }

    private static void addMid(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i=0; i<size; i++) {
            list.add(i /2, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("중간에서 추가 - 크기 : %d, 계산 시간 : %d ms".formatted(size, (endTime - startTime)));
    }

    private static void addLast(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i=0; i<size; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("뒤에 추가 - 크기 : %d, 계산 시간 : %d ms".formatted(size, (endTime - startTime)));
    }

    private static void getIndex(List<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i=0; i<loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("데이터 조회 - 반복 : %d, 계산 시간 : %d ms".formatted(loop, (endTime - startTime)));
    }
}
