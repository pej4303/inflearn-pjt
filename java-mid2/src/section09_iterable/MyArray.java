package section09_iterable;

import java.util.Iterator;

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

    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[] {1, 2, 3, 4, 5});
        Iterator<Integer> iterator = myArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
