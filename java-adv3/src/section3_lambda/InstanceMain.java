package section3_lambda;

import lambda.Procedure;

public class InstanceMain {
    public static void main(String[] args) {
        Procedure procedure1 = new Procedure() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };

        System.out.println("익명클래스 : " + procedure1.getClass());
        System.out.println("익명클래스 인스턴스 : " + procedure1); // section3_lambda.InstanceMain$1@7291c18f => 7291c18f 인스턴스명

        Procedure procedure2 = () -> {
            System.out.println("Hello World");
        };
        System.out.println("람다클래스 : " + procedure2.getClass());
        System.out.println("람다클래스 인스턴스 : " + procedure2); // section3_lambda.InstanceMain$$Lambda/0x000001c73b003948@7cc355be => 7cc355be 인스턴스명
    }
}
