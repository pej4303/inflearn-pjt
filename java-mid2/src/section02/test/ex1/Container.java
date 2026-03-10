package section2.test.ex1;

public class Container<T> {

    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public boolean isEmpty() {
        // 해당 인스턴스가 null인지만 체크
        return item == null;
    }
}