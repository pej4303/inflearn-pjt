package section3_lambda;

public class SamMain {
    public static void main(String[] args) {
        // 원래 인터페이스를 구현하려면 이렇게 해야 했음
        /*
        SamInterface samInterface = new SamInterface() {
            @Override
            public void run() {
                System.out.println("함수형 인터페이스임");
            }
        };
        */
        // 람다를 이용해서 구현
        SamInterface samInterface = ()  -> {
            System.out.println("함수형 인터페이스임");
        };

        samInterface.run();

        // Multiple non-overriding abstract methods found in NotSamInterface
//        NotSamInterface notSamInterface = () -> {
//            // run(), run2() 인지 알 수가 없기 때문에 컴파일 오류 발생
//            System.out.println("함수형 인터페이스 아님");
//        };
//        notSamInterface.run();
    }
}
