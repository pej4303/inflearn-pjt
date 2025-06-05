package kuke.board.article.service;

import kuke.board.article.entity.Article;
import kuke.board.article.repository.ArticleRepository;
import kuke.board.article.service.request.ArticleCreateRequest;
import kuke.board.article.service.request.ArticleUpdateRequest;
import kuke.board.article.service.response.ArticlePageResponse;
import kuke.board.article.service.response.ArticleResponse;
import kuke.board.common.snowflake.Snowflake;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
/**
 * Q. @RequiredArgsConstructor ?
 * A. final 필드를 가진 생성자를 Lombok이 자동 생성해준다. (생성자 주입 방식) → 의존성 주입 시 생성자를 직접 작성하지 않아도 되어 간결함 + 테스트 용이성 향상
 */
@RequiredArgsConstructor
public class ArticleService {
    /**
     * Q. 이렇게 주입받는 이유는?
     * A. 생성자 주입을 통해 의존성을 명시적으로 설정하고 final를 사용하여 불변성을 보장한다.
     *    스프링이 자동으로 ArticleRepository Bean을 주입해준다.
     */
    private final ArticleRepository articleRepository;
    /**
     * Q. Snowflake는 왜 new로 생성하는가?
     * A. Snowflake는 외부에서 주입받기보다는 내부 고정 로직으로 간주되어 직접 생성한 것으로 보인다. 필요 시 Bean으로 등록해 주입받도록 변경 가능
     */
    private final Snowflake snowflake = new Snowflake(); // 유니크 ID 생성기 (트위터 Snowflake 알고리즘 기반)

    /**
     * 게시글 조회
     * @param articleId
     * @return
     */
    public ArticleResponse search(Long articleId) {
        return ArticleResponse.from(articleRepository.findById(articleId).orElseThrow());
    }

    /**
     * 게시글 등록
     * @param request
     * @return
     */
    @Transactional
    public ArticleResponse add(ArticleCreateRequest request) {
        /**
         * Q. 이렇게 하는 이유는?
         * A. 객체 생성 로직을 Article 엔티티 내부의 정적 팩토리 메서드 `create()`로 위임하는 방식으로
         *    생성 책임을 명확히 분리하고 추후 생성 로직 변경 시에도 service 수정 없이 유지 가능하다.
         */
        Article article = articleRepository.save(
                Article.create(
                        snowflake.nextId(),                    // 게시글 ID (고유 ID 생성)
                        request.getTitle(),                    // 제목
                        request.getContent(),                  // 내용
                        request.getBoardId(),                  // 게시판 ID
                        request.getWriterId()                  // 작성자 ID
                )
        );

        // 엔티티 객체 → 응답 DTO로 변환 (서비스 외부에 내부 구현 정보 노출 방지)
        return ArticleResponse.from(article);
    }

    /**
     * 게시글 수정
     * @param articleId
     * @param request
     * @return
     */
    @Transactional
    public ArticleResponse modifiy(Long articleId, ArticleUpdateRequest request) {
        // 없으면 오류 발생
        Article article = articleRepository.findById(articleId).orElseThrow();
        article.update(request.getTitle(), request.getContent());

        return ArticleResponse.from(article);
    }

    /**
     * 게시글 삭제
     * @param articleId
     */
    @Transactional
    public void remove(Long articleId) {
        /**
         * Q. 삭제만 void인 이유?
         * A. 삭제는 결과를 반환할 필요가 없는 "명령(Command)" 역할이기 때문이다.
         *    - 조회(Select) → 데이터를 반환하는 것이 목적
         *    - 등록/수정(Create/Update) → 저장된 객체의 상태를 확인할 수 있도록 반환하는 것이 일반적
         *    - 삭제(Delete) → 단순히 “지워라”는 명령형 행위이기 때문에, 보통 결과를 반환하지 않음
         */
        articleRepository.deleteById(articleId);
    }

    /**
     * 페이징 조회
     * @param boardId
     * @param page
     * @param pageSize
     * @return
     */
    public ArticlePageResponse searchAll(Long boardId, Long page, Long pageSize) {
        return ArticlePageResponse.of(
                articleRepository.findAll(boardId, (page - 1) * pageSize, pageSize).stream().map(ArticleResponse::from).toList(),
                articleRepository.count(boardId, PageCalculator.calculatePageLimit(page, pageSize, 10L))
        );
    }

    /**
     * 무한 스크롤 조회
     * @param boardId
     * @param pageSize
     * @param lastArticleId
     * @return
     */
    public List<ArticleResponse> searchAllScroll(Long boardId, Long pageSize, Long lastArticleId) {
        List<Article> list = null;

        if (lastArticleId == null) {
            list = articleRepository.findAllInitScroll(boardId, pageSize);
        } else {
            list = articleRepository.findAllScroll(boardId, pageSize, lastArticleId);
        }

        return list.stream().map(ArticleResponse::from).toList();
    }
}
