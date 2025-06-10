package kuke.board.comment.repository;

import kuke.board.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
}
