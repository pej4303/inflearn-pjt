package kuke.board.like.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Q. @NoArgsConstructor(access = AccessLevel.PRIVATE)
 * A. 기본 생성자를 private으로 생성하여 외부에서 객체 생성을 막는다.
 *    유틸리티 클래스나 싱글턴, 정적 팩토리 메서드 패턴 등에서 사용한다.
 *    Lombok이 아래와 같은 생성자를 자동 생성한다.
 *    private 클래스명() { }
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageCalculator {
    public static Long calculatePageLimit(Long page, Long pageSize, Long movablePageCount) {
        return ( ( (page -1) / movablePageCount ) + 1 ) * pageSize * movablePageCount + 1;
    }
}

