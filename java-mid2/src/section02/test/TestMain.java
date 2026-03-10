package section02.test;

import section02.test.unit.*;

public class TestMain {
//    public static void main(String[] args) {
//        Marine m1 = new Marine("마린1", 40);
//        Marine m2 = new Marine("마린2", 50);
//        Marine resultMarine = UnitUtil.maxHp(m1, m2);
//        System.out.println("resultMarine = " + resultMarine);
//
//        Zealot z2 = new Zealot("질럿2", 100);
//        Zealot z1 = new Zealot("질럿1", 100);
//        Zealot resultZealot = UnitUtil.maxHp(z1, z2);
//        System.out.println("resultZealot = " + resultZealot);
//    }

//    public static void main(String[] args) {
//        Shuttle<Marine> shuttle1 = new Shuttle<>();
//        shuttle1.in(new Marine("마린", 40));
//        shuttle1.showInfo();
//
//        Shuttle<Zergling> shuttle2 = new Shuttle<>();
//        shuttle2.in(new Zergling("저글링", 35));
//        shuttle2.showInfo();
//
//        Shuttle<Zealot> shuttle3 = new Shuttle<>();
//        shuttle3.in(new Zealot("질럿", 100));
//        shuttle3.showInfo();
//    }

    public static void main(String[] args) {
        Shuttle<Marine> shuttle1 = new Shuttle<>();
        shuttle1.in(new Marine("마린", 40));

        Shuttle<Zergling> shuttle2 = new Shuttle<>();
        shuttle2.in(new Zergling("저글링", 35));

        Shuttle<Zealot> shuttle3 = new Shuttle<>();
        shuttle3.in(new Zealot("질럿", 100));

        UnitPrinter.printV1(shuttle1);
        UnitPrinter.printV2(shuttle2);
    }
}
