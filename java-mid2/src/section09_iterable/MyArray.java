package section09_iterable;

import java.util.*;

/**
 * 자료 구조
 * Iterable 인터페이스를 구현함으로써 "나를 순회할 수 있어"라고 외부에 알리는 역할
 * iterator() 메서드를 호출하면 순회를 도와줄 MyArrayIterator 객체를 생성해서 반환
 */
public class MyArray implements Iterable<Integer> {
    private int[] numbers;

    public MyArray(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterable(this.numbers);
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[] {1, 4, 5, 2});

        /**
         * 자바는 Iterable 인터페이스를 구현한 객체에 대해서
         * 향상된 for문을 사용 할 수 있게 해줌
         */
        for (int num : myArray) {
            System.out.println(num);
        }
        // 자바는 컴파일 시점에 아래와 같이 코드를 변경함
        /*
        Iterator<Integer> iterator = myArray.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println(num);
        }
        */

        List<String> list = new  ArrayList<>();

        List<String> list2 = Collections.emptyList();
    }
}
