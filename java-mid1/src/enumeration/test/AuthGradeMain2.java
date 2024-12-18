package enumeration.test;

import java.util.Scanner;

/**
 * 문제3
 *
 * AuthGradeMain2 이라는 클래스에 코드를 작성하자.
 * 인증 등급을 입력 받아서 앞서 만든 AuthGrade 열거형으로 변환하자.
 * 인증 등급에 따라 접근 할 수 있는 화면이 다르다.
 *
 * 예를 들어 GUEST 등급은 메인 화면만 접근 할 수 있고,
 * ADMIN 등급은 모든 화면에 접근 할 수 있다.
 * 각각의 등급에 따라서 출력되는 메뉴 목록이 달라진다.
 *
 * 다음 출력 결과를 참고해서 코드를 완성하자.
 *
 * [GUEST 입력 예]
 * 당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: GUEST
 * 당신의 등급은 손님입니다.
 * ==메뉴 목록==
 * - 메인 화면
 *
 * [LOGIN 입력 예]
 * 당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: LOGIN
 * 당신의 등급은 로그인 회원입니다.
 *  ==메뉴 목록==
 *  - 메인 화면-
 *  - 이메일 관리 화면
 *
 * [ADMIN 입력 예]
 *  당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ADMIN
 * 당신의 등급은 관리자입니다.
 *  ==메뉴 목록==
 *  - 메인 화면
 *  - 이메일 관리 화면
 *  - 관리자 화면
 *
 * [잘못된 값이 입력되는 경우]
 * 당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: x
 */
public class AuthGradeMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ");
        String grade = sc.nextLine().toUpperCase();

        try {
            AuthGrade authGrade = AuthGrade.valueOf(grade);

            // 출력
            System.out.println( String.format("당신의 등급은 %s입니다.", authGrade.getDescription()) );
            System.out.println("==메뉴 목록==");
            for ( String str : authGrade.getMenu() ) {
                System.out.println("- " + str);
            }
        } catch (Exception e) {
            System.out.println("x");
        }
    }
}
