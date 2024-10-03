package lang.immutable.address;

// setValue() 가 없으므로 객체의 상태를 바꿀수 없는 "불변객체"가 되었다.
public class ImmutableAddress {
    private final String value;

    public ImmutableAddress(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Address{" +
                "value='" + value + '\'' +
                '}';
    }
}
