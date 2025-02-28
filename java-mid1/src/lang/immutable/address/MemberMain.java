package lang.immutable.address;

public class MemberMain {
    public static void main(String[] args) {
        Address address = new Address("인천");

        MemberV1 memberA = new MemberV1("회원A", address);
        MemberV1 memberB = new MemberV1("회원B", address);

        // 회원A, 회원B의 처음 주소는 모두 서울
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 회원B의 주소를 부산으로 변경해야함
        // 공유 참조로 memberA, memberB 모두 값이 변경됨 -> 주의깊게 코드를 살펴보지 않으면 놓치기 쉬움!
        memberB.getAddress().setValue("부산");
        System.out.println("부산 -> memberB.address");
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        System.out.println("===========================================");

        ImmutableAddress iAddress = new ImmutableAddress("인천");

        MemberV2 member1 = new MemberV2("회원A", iAddress);
        MemberV2 member2 = new MemberV2("회원B", iAddress);

        // 회원A, 회원B의 처음 주소는 모두 인천
        System.out.println("member1 = " + member1);
        System.out.println("member2 = " + member2);

        // 사이드 이펙트가 발생하지 않음
        member2.setAddress(new ImmutableAddress("부산"));

        System.out.println("부산 -> member2.address");
        System.out.println("member1 = " + member1);
        System.out.println("member2 = " + member2);
    }
}
