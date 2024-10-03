package lang.immutable.address;

public class RefMain3 {
    public static void main(String[] args) {
        ImmutableAddress iAddressA = new ImmutableAddress("인천");
        ImmutableAddress iAddressB = iAddressA; // 참조값 대입을 막을 수 있는 방법은 없다.
        System.out.println("iAddressA = " + iAddressA);
        System.out.println("iAddressB = " + iAddressB);

        iAddressB = new ImmutableAddress("부산");

        System.out.println("부산으로 변경");
        System.out.println("iAddressA = " + iAddressA);
        System.out.println("iAddressB = " + iAddressB);
    }
}
