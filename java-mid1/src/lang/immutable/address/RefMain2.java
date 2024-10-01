package lang.immutable.address;

public class RefMain2 {
    public static void main(String[] args) {
        Address addressA = new Address("인천");
        Address addressB = addressA;

        System.out.println("addressA = " + addressA);
        System.out.println("addressB = " + addressB);

        change(addressB, "부산");
        System.out.println("부산으로 변경");
        System.out.println("addressA = " + addressA);
        System.out.println("addressB = " + addressB);
    }

    private static void change(Address address, String changeAddress) {
        address.setValue(changeAddress);
    }
}
