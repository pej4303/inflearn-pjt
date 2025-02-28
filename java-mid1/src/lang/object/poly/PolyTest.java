package lang.object.poly;

public class PolyTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal2 = new Jaelong();

        animal.print();
        animal2.print();

        // animal2.sound(); // 컴파일 에러
        ((Jaelong) animal2).sound(); // 다운 캐스팅후 호출
    }
}
