package enumeration.test;

/**
 * 문제1
 *
 * 회원의 인증등급을 AuthGrade라는 이름의 열거형으로 만들어라.
 * 인증 등급은 3가지이고, 등급에 따른 레벨과 설명을 가진다.
 * 레벨과 설명을 getXX() 메서드로 조회 할 수 있어야 한다.
 *
 * GUEST(손님)
 *  - level = 1
 *  - description = 손님
 * LOGIN(로그인 회원)
 *  - level = 2
 *  - description = 로그인 회원
 * ADMIN(관리자)
 *  - level = 3
 *  - description = 관리자
 */
public enum AuthGrade {
    GUEST(1, "손님", new String[]{"메인 화면"}),
    LOGIN(2, "로그인 회원", new String[]{"메인 화면", "이메일 관리 화면"}),
    ADMIN(3, "관리자", new String[]{"메인 화면", "이메일 관리 화면", "관리자 화면"});

    private final int level;   // 레벨
    private final String description;  // 설명
    private final String[] menu;       // 메뉴

    AuthGrade(int level, String description, String[] menu) {
        this.level = level;
        this.description = description;
        this.menu = menu;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public String[] getMenu() {
        return menu;
    }
}
