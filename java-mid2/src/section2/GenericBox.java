package section2;

/**
 * 제네릭 클래스
 *
 * @param <T>
 */
public class GenericBox<T> {
    /**
     * - <>를 이용해서 제네릭 클래스를 만든다.
     * - 여기서 T 는 타입 매개 변수라고 한다.
     */
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

