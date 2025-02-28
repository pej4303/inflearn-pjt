package enumeration.test;

/**
 * 문제2
 *
 * AuthGradeMain1 이라는 클래스를 만들고 다음 결과가 출력되도록 코드를 작성해라.
 * 앞서 만든 AuthGrade을 활용하자.
 * [결과]
 * grade=GUEST, level=1, 설명=손님
 * grade=LOGIN, level=2, 설명=로그인 회원
 * grade=ADMIN, level=3, 설명=관리자
 */
public class AuthGradeMain1 {
    public static void main(String[] args) {
        AuthGrade[] gradeArr = AuthGrade.values();
        // System.out.println(Arrays.toString(gradeArr));

        for (AuthGrade item : gradeArr) {
            System.out.println( String.format("grade=%s, level=%d, 설명=%s", item.name(), item.getLevel(), item.getDescription()) );

        }
    }
}
