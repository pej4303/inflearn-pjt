package section04;

import java.util.Arrays;

public class MyArrayList {
    // 기본 크기
    private static final int DEFAULT_SIZE = 5;
    private Object[] elementData;
    private int size = 0;

    /**
     * 기본 생성자
     */
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_SIZE];
    }

    /**
     * 초기 크기 지정 생성자
     * @param initSize 초기 크기
     */
    public MyArrayList(int initSize) {
        this.elementData = new Object[initSize];
    }

    /**
     * 요소 변경 (기존값 반환)
     * @param index 위치
     * @param obj 변경할 요소
     * @return 기존 요소
     */
    public Object set(int index, Object obj) {
        Object oldVal = this.get(index);
        this.elementData[index] = obj;
        return oldVal;
    }

    /**
     * 요소 반환
     * @param index 위치
     * @return 요소
     */
    public Object get(int index) {
        return this.elementData[index];
    }

    /**
     * 마지막 위치에 요소 추가
     * @param obj 추가할 요소
     */
    public void add(Object obj) {
        if (this.size == this.elementData.length) {
            sizeUp();
        }

        this.elementData[this.size] = obj;
        this.size++;
    }

    /**
     * 지정 위치에 요소 추가
     * @param index 위치
     * @param obj 추가할 요소
     */
    public void add(int index, Object obj) {
        if (this.size == this.elementData.length) {
            sizeUp();
        }

        shiftRightFrom(index);
        this.elementData[index] = obj;
        this.size++;
    }

    /**
     * 요소 삭제
     * @param index 위치
     * @return 삭제된 요소
     */
    public Object remove(int index) {
        Object oldVal = get(index);

        this.shiftLeftFrom(index);
        this.size--;
        this.elementData[this.size] = null;

        return oldVal;
    }

    /**
     * 요소 위치 반환 (없으면 -1)
     * @param obj 찾을 요소
     * @return 인덱스
     */
    public int indexOf(Object obj) {
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(this.elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 사이즈 반환
     * @return 리스트 크기
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 배열 크기 증가 (2배 확장)
     */
    private void sizeUp() {
        int oldSize = this.elementData.length;
        int newSize = oldSize * 2;

        this.elementData = Arrays.copyOf(this.elementData, newSize);
    }

    /**
     * 요소를 오른쪽으로 이동
     * @param index 시작 위치
     */
    private void shiftRightFrom(int index) {
        for (int i = this.size; i > index; i--) {
            this.elementData[i] = this.elementData[i - 1];
        }
    }

    /**
     * 요소를 왼쪽으로 이동
     * @param index 시작 위치
     */
    private void shiftLeftFrom(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.elementData, this.size))
                + " size=" + this.size
                + ", capacity=" + this.elementData.length;
    }
}
