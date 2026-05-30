package section08_map.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제6 - 회원 관리 저장소
 *
 * - 문제 설명
 * Map을 사용해서 회원을 저장하고 관리하는 MemberRepository 코드를 완성하자.
 * Member , MemberRepositoryMain 코드와 실행 결과를 참고하자.
 *
 * - 실행 결과
 * findMember1 = Member{id='id1', name='회원1'}
 * findMember3 = Member{id='id3', name='회원3'}
 * removedMember1 = null
 */
public class MemberRepository {
    private Map<String, Member> memberMap = new HashMap<>();

    public void save(Member member) {
        // 코드 작성
        memberMap.put(member.getId(), member);
    }

    public void remove(String id) {
        // 코드 작성
        memberMap.remove(id);
    }

    public Member findById(String id) {
        // 코드 작성
        Member member = memberMap.get(id);
        return member;
    }

    public Member findByName(String name) {
        // 코드 작성
        for (Member member : memberMap.values()) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }
}
