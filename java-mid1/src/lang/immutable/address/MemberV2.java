package lang.immutable.address;

// 불변 객체를 사용해서 address 값 변경이 안되게 함
public class MemberV2 {
    private String name;
    private ImmutableAddress address;
    public MemberV2(String name, ImmutableAddress address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public ImmutableAddress getAddress() {
        return address;
    }
    public void setAddress(ImmutableAddress address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
