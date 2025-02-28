package lang.immutable.address;

public class RefMain {
    public static void main(String[] args) {
        // 기본형은 절대로 같은값을 공유하지 않음
        int a = 10;
        int b = a; // a의 값을 복사해서 b 변수에 넣음

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b = 20;
        System.out.println("20으로 변경");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // 참조형 변수는 하나의 인스턴스를 공유 할 수 있음
        Address addressA = new Address("인천");
        // Address addressB = addressA; // addressA의 참조값(번지수)를 복사했으므로 같은 번지수를 바라보게 됨
        Address addressB = new Address("인천");; // addressB 변수도 번지수를 다르게 해야됨

        System.out.println("addressA = " + addressA);
        System.out.println("addressB = " + addressB);

        addressB.setValue("부산");
        System.out.println("부산으로 변경");
        System.out.println("addressA = " + addressA);
        System.out.println("addressB = " + addressB);
    }
}
