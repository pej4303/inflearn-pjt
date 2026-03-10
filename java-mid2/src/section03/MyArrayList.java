package section03;

import java.util.Arrays;

public class MyArrayList {
    // 기본 사이즈
    private static final int DEFAULT_SIZE = 5;
    private Object[] elementData;
    private int size = 0;

    /**
     * 생성자
     */
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_SIZE];
    }
    public MyArrayList(int initSize) {
        this.elementData = new Object[initSize];
    }

    /**
     * 배열 길이 반환
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 배열 추가
     * @param obj
     */
    public void add(Object obj) {
        elementData[size] = obj;
        size++;
    }

    /**
     * 배열 값 반환
     * @param index
     * @return
     */
    public Object get(int index) {
        return elementData[index];
    }

    public Object set(int index, Object obj) {
        Object oldVal = get(index);
        elementData[index] = obj;
        return oldVal;
    }

    /**
     * 배열 원소 검색
     * @param obj
     * @return
     */
    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        // [1,2,3,null] => [1,2,3] 출력되게
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }
}
