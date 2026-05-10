package section07_set;

/**
 * 공통 기능을 가진 제네릭 Set 인터페이스
 * => Set 추상화
 * @param <E> 리스트에 저장될 요소 타입
 */
public interface MySet<E> {
    /**
     * 요소 추가
     * @param e 추가할 요소
     */
    boolean add(E e);

    /**
     * 요소 삭제
     * @param e
     * @return
     */
    boolean remove(E e);

    /**
     * 요소 값 여부
     * @param e
     * @return
     */
    boolean contains(E e);
}
