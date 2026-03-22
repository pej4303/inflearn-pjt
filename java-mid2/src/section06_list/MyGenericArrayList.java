package section06_list;

import java.util.Arrays;

public class MyGenericArrayList<E> implements MyList<E> {
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
     * 요소 변경 (기존값 반환)
     * @param index 위치
     * @param e 변경할 요소
     * @return 기존 요소
     */
    @Override
    public E set(int index, E e) {
        E oldVal = this.get(index);
        this.elementData[index] = e;
        return oldVal;
    }

    /**
     * 요소 반환
     * @param index 위치
     * @return 요소
     */
    @Override
    public E get(int index) {
        // 조회할 때는 Object 타입을 지정한 타입 매개변수로 다운캐스팅 해줘야 한다.
        return (E) this.elementData[index];
    }

    /**
     * 마지막 위치에 요소 추가
     * @param e 추가할 요소
     */
    @Override
    public void add(E e) {
        if (this.size == this.elementData.length) {
            sizeUp();
        }

        this.elementData[this.size] = e;
        this.size++;
    }

    /**
     * 지정 위치에 요소 추가
     * @param index 위치
     * @param e 추가할 요소
     */
    @Override
    public void add(int index, E e) {
        if (this.size == this.elementData.length) {
            sizeUp();
        }
        shiftRightFrom(index);
        this.elementData[index] = e;
        this.size++;
    }

    /**
     * 요소 삭제
     * @param index 위치
     * @return 삭제된 요소
     */
    @Override
    public E remove(int index) {
        E oldVal = get(index);
        this.shiftLeftFrom(index);

        this.size--;
        this.elementData[index] = null;
        return oldVal;
    }

    /**
     * 요소 위치 반환 (없으면 -1)
     * @param obj 찾을 요소
     * @return 인덱스
     */
    @Override
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
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 지정 위치부터 오른쪽으로 이동
     * @param index 시작 위치
     */
    private void shiftRightFrom(int index) {
        for (int i = this.size; i > index; i--) {
            this.elementData[i] = this.elementData[i - 1];
        }
    }

    /**
     * 지정 위치부터 왼쪽으로 이동
     * @param index 시작 위치
     */
    private void shiftLeftFrom(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
    }

    /**
     * 배열 크기 증가
     */
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

    @Override
    public String toString() {
        // [1,2,3,null] => [1,2,3] 출력되게
        return Arrays.toString(Arrays.copyOf(this.elementData, this.size)) + " size=" + this.size + ", capacity=" + this.elementData.length;
    }
}
