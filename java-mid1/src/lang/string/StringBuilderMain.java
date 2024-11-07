package lang.string;

public class StringBuilderMain {
    public static void main(String[] args) {
        // 불변 객체가 아니기때문에 변경값을 다시 받을 필요가 없음
        // 가변적이기때문에 새로운 객체를 생성하지 않음. 이로 인해 메모리 사용을 줄이고 성능을 향상시킬 수 있음
        StringBuilder sb = new StringBuilder("");
        sb.append("p");
        sb.append("e");
        sb.append("j");

        sb.insert(0, "안녕");

        System.out.println(sb);
    }
}
