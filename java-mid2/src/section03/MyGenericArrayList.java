package section03;

import java.util.Arrays;

/**
 * MyArrayList 에서 제네릭을 도입하여 타입 안정성을 확보
 * => 데이터를 넣는 부분을 변경함
 */
public class MyGenericArrayList<E> {
    // 기본 사이즈
    private static final int DEFAULT_SIZE = 5;
    private Object[] elementData;
    private int size = 0;

    /**
     * 생성자
     */
    public MyGenericArrayList() {
        //
        /**
         * 타입 이레이저에 의해 타입 정보가 사라진다.
         * => 이게 제네릭의 한계
         * new E[DEFAULT_SIZE]; => 오류
         */
        this.elementData = new Object[DEFAULT_SIZE];
    }

    public MyGenericArrayList(int initSize) {
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
     * @param e
     */
    public void add(E e) {
        if (this.size == this.elementData.length) {
            sizeUp();
        }

        this.elementData[this.size] = e;
        this.size++;
    }

    public void add(int index, E e) {
        if (this.size == this.elementData.length) {
            sizeUp();
        }
        shiftRightFrom(index);
        this.elementData[index] = e;
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
    public E remove(int index) {
        E oldVal = get(index);
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
    public E get(int index) {
        // 조회할 때는 Object 타입을 지정한 타입 매개변수로 다운캐스팅 해줘야 한다.
        return (E) this.elementData[index];
    }

    public E set(int index, E e) {
        E oldVal = this.get(index);
        this.elementData[index] = e;
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
