package section06_list;

/**
 * 공통 기능을 가진 제네릭 리스트 인터페이스
 * => 리스트 추상화
 * @param <E> 리스트에 저장될 요소 타입
 */
public interface MyList<E> {

    /**
     * 요소 변경 (기존값 반환)
     * @param index 위치
     * @param e 변경할 요소
     * @return 기존 요소
     */
    E set(int index, E e);

    /**
     * 요소 반환
     * @param index 위치
     * @return 요소
     */
    E get(int index);

    /**
     * 마지막 위치에 요소 추가
     * @param e 추가할 요소
     */
    void add(E e);

    /**
     * 지정 위치에 요소 추가
     * @param index 위치
     * @param e 추가할 요소
     */
    void add(int index, E e);

    /**
     * 요소 삭제
     * @param index 위치
     * @return 삭제된 요소
     */
    E remove(int index);

    /**
     * 요소 위치 반환 (없으면 -1)
     * @param o 찾을 요소
     * @return 인덱스
     */
    int indexOf(E o);

    /**
     * 사이즈 반환
     * @return 리스트 크기
     */
    int size();
}