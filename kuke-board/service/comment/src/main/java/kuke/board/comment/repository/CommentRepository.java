package kuke.board.comment.repository;

import kuke.board.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    /**
     * 특정 게시글에서 상위 댓글 ID에 :parentCommentId 인 댓글의 개수
     *
     * @param articleId
     * @param parentCommentId
     * @param limit
     * @return
     */
    @Query(value = "SELECT COUNT(*)\n" +
                   "  FROM (\n" +
                   "    SELECT TC.COMMENT_ID\n" +
                   "      FROM TB_COMMENT TC\n" +
                   "     WHERE TC.ARTICLE_ID = :articleId\n" +
                   "       AND TC.PARENT_COMMENT_ID = :parentCommentId\n" +
                   "     FETCH NEXT :limit ROWS ONLY\n" +
                   ")",
            nativeQuery = true)
    Long countBy(
            @Param("articleId") Long articleId,
            @Param("parentCommentId") Long parentCommentId,
            @Param("limit") Long limit );


    /**
     * 댓글 목록 조회
     * @param articleId
     * @param offset
     * @param limit
     * @return
     */
    @Query(
            value = "SELECT A.COMMENT_ID \n" +
                    "     , A.CONTENT \n" +
                    "     , A.PARENT_COMMENT_ID \n" +
                    "     , A.ARTICLE_ID\n" +
                    "     , A.WRITER_ID\n" +
                    "     , A.CREATED_AT\n" +
                    "     , A.MODIFIED_AT\n" +
                    "     , A.DEL_YN \n" +
                    " FROM (\n" +
                    "    SELECT TC.COMMENT_ID \n" +
                    "      FROM TB_COMMENT TC \n" +
                    "     WHERE TC.ARTICLE_ID = :articleId \n" +
                    "     ORDER BY TC.PARENT_COMMENT_ID , TC.COMMENT_ID \n" +
                    "    OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY\n" +
                    "  ) T\n" +
                    "LEFT JOIN TB_COMMENT A\n" +
                    "  ON T.COMMENT_ID = A.COMMENT_ID",
            nativeQuery = true
    )
    List<Comment> findAll(
            @Param("articleId") Long articleId, // 게시글 ID
            @Param("offset") Long offset,   // 시작 위치 (페이징용)
            @Param("limit") Long limit      // 조회할 글 수 (페이징용)
    );

    /**
     * 목록 건수 조회
     * @param articleId
     * @param limit
     * @return
     */
    @Query(value = "SELECT COUNT(*) \n" +
            "         FROM (\n" +
            "            SELECT COMMENT_ID\n" +
            "              FROM TB_COMMENT\n" +
            "             WHERE ARTICLE_ID = :articleId\n" +
            "            FETCH FIRST :limit ROWS ONLY\n" +
            "      ) T",
            nativeQuery = true)
    Long count(@Param("articleId") Long articleId, @Param("limit") Long limit);

    /**
     * 무한 스크롤 초기 조회
     * @param articleId
     * @param limit
     * @return
     */
    @Query(
            value = "SELECT A.COMMENT_ID\n" +
                    "     , A.CONTENT\n" +
                    "     , A.PARENT_COMMENT_ID\n" +
                    "     , A.ARTICLE_ID\n" +
                    "     , A.WRITER_ID\n" +
                    "     , A.CREATED_AT\n" +
                    "     , A.MODIFIED_AT\n" +
                    "     , A.DEL_YN \n" +
                    "  FROM TB_COMMENT A \n" +
                    " WHERE A.ARTICLE_ID = :articleId\n" +
                    " ORDER BY A.PARENT_COMMENT_ID, A.COMMENT_ID \n" +
                    " FETCH NEXT :limit ROWS ONLY\n" ,
            nativeQuery = true
    )
    List<Comment> findAllInitScroll(
            @Param("articleId") Long articleId, // 게시글 ID
            @Param("limit") Long limit      // 조회할 글 수 (페이징용)
    );

    /**
     * 무한 스크롤 조회
     *
     * DESC 정렬이면 → id < lastId
     * ASC 정렬이면 → id > lastId
     *
     * @param articleId
     * @param lastParentCommentId
     * @param lastCommentId
     * @param limit
     * @return
     */
    @Query(
            value = "SELECT A.COMMENT_ID\n" +
                    "     , A.CONTENT\n" +
                    "     , A.PARENT_COMMENT_ID\n" +
                    "     , A.ARTICLE_ID\n" +
                    "     , A.WRITER_ID\n" +
                    "     , A.CREATED_AT\n" +
                    "     , A.MODIFIED_AT\n" +
                    "     , A.DEL_YN \n" +
                    "  FROM TB_COMMENT A \n" +
                    " WHERE A.ARTICLE_ID = :articleId\n" +
                    "   AND ( \n" +
                    "    A.PARENT_COMMENT_ID > :lastParentCommentId OR (A.PARENT_COMMENT_ID = :lastParentCommentId AND A.COMMENT_ID > :lastCommentId ) \n " +
                    "   )\n" +
                    " ORDER BY A.PARENT_COMMENT_ID, A.COMMENT_ID \n" +
                    " FETCH NEXT :limit ROWS ONLY\n" ,
            nativeQuery = true
    )
    List<Comment> findAllScroll(
            @Param("articleId") Long articleId,                      // 게시글 ID
            @Param("limit") Long limit,                              // 조회할 글 수 (페이징용)
            @Param("lastParentCommentId") Long lastParentCommentId,  // 최근 조회된 PARENT_COMMENT_ID
            @Param("lastCommentId") Long lastCommentId              // 최근 조회된 COMMENT_ID
    );
}
