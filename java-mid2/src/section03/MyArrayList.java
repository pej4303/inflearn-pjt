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
        return this.size;
    }

    /**
     * 배열 추가
     * @param obj
     */
    public void add(Object obj) {
        if (this.size == this.elementData.length) {
            sizeUp();
        }

        this.elementData[this.size] = obj;
        this.size++;
    }

    public void add(int index, Object obj) {
        if (this.size == this.elementData.length) {
            sizeUp();
        }
        shiftRightFrom(index);
        this.elementData[index] = obj;
        this.size++;
    }

    /**
     * 배열 원소 이동
     * @param index
     */
    private void shiftRightFrom(int index) {
        for (int i = this.size; i > index; i--) {
            this.elementData[i] = this.elementData[i - 1];
        }
    }

    /**
     * 배열 삭제
     * @param index
     * @return
     */
    public Object remove(int index) {
        Object oldVal = get(index);
        this.shiftLeftFrom(index);

        this.size--;
        this.elementData[index] = null;
        return oldVal;
    }

    private void shiftLeftFrom(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
    }

    /**
     * 배열 값 반환
     * @param index
     * @return
     */
    public Object get(int index) {
        return this.elementData[index];
    }

    public Object set(int index, Object obj) {
        Object oldVal = this.get(index);
        this.elementData[index] = obj;
        return oldVal;
    }

    private void sizeUp() {
        // 기존 배열의 사이즈
        int oldSize = this.elementData.length;
        int newSize = oldSize * 2;
        // 배열을 새로 만들고 기존 배열을 새로운 배열에 복사
        /*
        for (int i = 0; i < elementData.length; i++) {
            newArr[i] = elementData[i];
        }
        */
        this.elementData = Arrays.copyOf(this.elementData, newSize);
    }

    /**
     * 배열 원소 검색
     * @param obj
     * @return
     */
    public int indexOf(Object obj) {
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(this.elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        // [1,2,3,null] => [1,2,3] 출력되게
        return Arrays.toString(Arrays.copyOf(this.elementData, this.size)) + " size=" + this.size + ", capacity=" + this.elementData.length;
    }
}
