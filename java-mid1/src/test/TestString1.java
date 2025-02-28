package test;

public class TestString1 {
    // startsWith() 사용해서 url이 https://로 시작하는지 확인해라.
    public static void main(String[] args) {
        String url = "https://www.example.com";
        // 코드 작성
        if (url.startsWith("https://")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}