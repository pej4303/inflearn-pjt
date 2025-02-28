package lang.string;

public class StringMain {
    public static void main(String[] args) {
        StringMain main = new StringMain();
//        main.string();
        main.stringEqualus();

    }

    /***
     * String
     */
    public void string() {
        // 일반적으로 char를 잘 쓰지 않음 => String 사용하면 되기 때문에
        char[] charArr = new char[]{'P', 'E', 'J'};
        // System.out.println(charArr);

        // 참조형은 대문자로 시작함 =>
        // 기본형은 소문자로 시작함 => int, char, boolean

        /*
         *  String 선언 방법
         * */
        // 방법1) 리터럴 방식
        String str1 = "pej"; // => 방법2처럼 자바 알아서 변경해줌 => 인프런 문의글 남겼는데 사실이 아님!!!(https://www.inflearn.com/community/questions/1423424/string%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%A6%AC%ED%84%B0%EB%9F%B4-%EB%B0%A9%EC%8B%9D-%EA%B4%80%EB%A0%A8-%EC%A7%88%EB%AC%B8)
        // 방법2) new 연산자를 이용한 방식
        String str2 = new String("pej");

        /**
         * 자바 9 이전에는 char[]을 이용해서 String 클래스 데이터를 저장하였는데
         * 자바 9 이후부터는 byte[]을 이용해서 데이터를 저장함
         * private final byte[] value;
         *
         * char는 무조건 2byte 였는데 byte는 영어, 숫자는 1byte를 사용하고 나머지 경우는 2byte를 사용해서 더 메모리를 효율적으로 사용할 수 있게 변경되었음
         */

        /**
         * String은 참조형이기때문에 값을 가지고 있는게 아니라 참조값이 있음
         * "+" 연산이 되면 안되지만 결과를 보면 "+" 연산이 됨
         * String이 너무 많이 다뤄지기 때문에 편의상 특별하게 "+" 연산을 허용해줌
         */
        String str3 = str1 + str2;
        String str4 = str1.concat(str2);

        System.out.println(str3);
        System.out.println(str4);
    }


    /**
     * String 비교
     */
    public void stringEqualus() {
        String str1 = new String("pej");  // => 참조값 : x100
        String str2 = new String("pej"); // => 참조값 : x200

        // == 비교는 참조값이 같은지 판단하기 때문에 다르다고 나옴
        System.out.println("== =>" + (str1 == str2));

        // 단순히 문자열만 비교하기 때문에 같다고 나옴
        // (Object의 equals는 객체의 주소값을 비교하는거지만 String 클래스는 오버라이딩해서 단순히 문자만 같으면 같은걸로 나오게 되어있음)
        System.out.println("equals =>" + (str1.equals(str2)));


        // String Pool을 이용하기 때문에 str3, str4의 참조값은 같아지는건가? => 같은 주소값을 바라보게 됨
        String str3 = "pej";
        String str4 = "pej";

        // 문자열 리터널을 사용하는 경우 같은 주소값을 바라보게 되므로 == 비교도 true가 나옴
        System.out.println("== =>" + (str3 == str4));
        System.out.println("equals =>" + (str3.equals(str4)));
    }
}
