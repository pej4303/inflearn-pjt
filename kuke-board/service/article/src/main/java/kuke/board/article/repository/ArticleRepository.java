package kuke.board.article.repository;

import kuke.board.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    /**
     * 페이징 쿼리
     *
     * @Query 어노테이션을 사용하여 직접 SQL을 작성한다.
     * - nativeQuery = true : 실제 데이터베이스 SQL 문법을 그대로 사용한다.
     * - :파라미터명 은 @Param 과 매핑되어 바인딩된다.
     *
     * SQL 설명:
     * 1. TB_ARTICLE 테이블에서 특정 게시판 ID(boardId)에 해당하는 게시글을 ARTICLE_ID 기준 내림차순 정렬한다.
     * 2. 정렬된 결과에서 OFFSET과 LIMIT를 이용해 원하는 페이지 범위에 해당하는 ARTICLE_ID만 추출한다.
     * 3. 추출한 ARTICLE_ID를 기준으로 TB_ARTICLE과 다시 조인하여 해당 게시글의 모든 컬럼을 조회한다.
     *
     * Q. 왜 자기 자신을 다시 조인할까?
     * A. 대규모 시스템에서 이 방식은 성능 최적화를 위한 "절충안"일 수 있다.
     *    먼저 필요한 ARTICLE_ID만 추출해서 (인덱스를 타도록 유도)
     *    그 후에 실제 본문 데이터(여러 컬럼)를 조인해서 가져오는 방식이 더 효율적일 수 있다.
     *
     * @param boardId 게시판 ID
     * @Param offset 시작 위치 (페이징용)
     * @Param limit 조회할 글 수 (페이징용)
     * @return 조회된 게시글 리스트
     */
    @Query(
            value = "SELECT A.ARTICLE_ID\n" +
                    "     , A.TITLE\n" +
                    "     , A.CONTENT\n" +
                    "     , A.BOARD_ID\n" +
                    "     , A.WRITER_ID\n" +
                    "     , A.CREATED_AT\n" +
                    "     , A.MODIFIED_AT\n" +
                    "  FROM (\n" +
                    "    SELECT ARTICLE_ID\n" +
                    "      FROM TB_ARTICLE\n" +
                    "     WHERE BOARD_ID = :boardId\n" +
                    "     ORDER BY ARTICLE_ID DESC\n" +
                    "    OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY\n" +
                    "  ) T \n" +
                    "  LEFT JOIN TB_ARTICLE A\n" +
                    "    ON T.ARTICLE_ID = A.ARTICLE_ID",
            nativeQuery = true
    )
    List<Article> findAll(
            @Param("boardId") Long boardId, // 게시판 ID
            @Param("offset") Long offset,   // 시작 위치 (페이징용)
            @Param("limit") Long limit      // 조회할 글 수 (페이징용)
    );

    /**
     * 목록 건수 조회
     * @param boardId
     * @param limit
     * @return
     */
    @Query(value = "SELECT COUNT(*) \n" +
            "         FROM (\n" +
            "            SELECT ARTICLE_ID\n" +
            "              FROM TB_ARTICLE\n" +
            "             WHERE BOARD_ID = :boardId\n" +
            "            ORDER BY ARTICLE_ID DESC\n" +
            "            FETCH FIRST :limit ROWS ONLY\n" +
            "      ) T",
            nativeQuery = true)
    Long count(@Param("boardId") Long boardId, @Param("limit") Long limit);
}
