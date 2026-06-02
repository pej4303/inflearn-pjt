package section09_iterable;

import java.util.Iterator;

/**
 * MyArray 내부의 배열을 참조해서 데이터를 하나씩 꺼내는 실제 순회 작업을 수행
 */
public class MyArrayIterable implements Iterator<Integer> {
    private int[] targetArray;
    private int index = -1;

    public MyArrayIterable(int[] targetArray) {
        this.targetArray = targetArray;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.targetArray.length -1;
    }

    @Override
    public Integer next() {
        this.index++;
        int result = this.targetArray[this.index];
        return result;
    }
}
