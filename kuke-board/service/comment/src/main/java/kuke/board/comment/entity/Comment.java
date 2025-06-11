package kuke.board.comment.entity;

import jakarta.persistence.*;
import kuke.board.comment.convert.BooleanYNConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 댓글 엔티티 클래스
 * DB의 TB_COMMENT 테이블과 매핑되며 게시글의 정보를 담는다.
 */
@Entity
@Table(name = "TB_COMMENT")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @Column(name = "COMMENT_ID")
    private Long commentId; // 댓글ID

    @Column(name = "CONTENT", nullable = false, length = 3000)
    private String content; // 내용

    @Column(name = "ARTICLE_ID", nullable = false)
    private Long articleId; // 게시글ID

    @Column(name = "PARENT_COMMENT_ID", nullable = false)
    private Long parentCommentId;   // 상위 댓글 ID

    @Column(name = "WRITER_ID", nullable = false)
    private Long writerId;  // 작성자ID

    @Convert(converter = BooleanYNConverter.class)
    @Column(name = "DEL_YN", nullable = false, length = 1)
    private boolean delYn;  // 삭제여부

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;    // 생성시간

    @Column(name = "MODIFIED_AT")
    private LocalDateTime modifiedAt;   // 수정시간


    /**
     * 댓글 생성
     * @param commentId
     * @param content
     * @param parentCommentId
     * @param articleId
     * @param writerId
     * @return
     */
    public static Comment create(Long commentId, String content, Long parentCommentId, Long articleId, Long writerId) {
        Comment comment = new Comment();
        comment.commentId = commentId;
        comment.content = content;
        comment.parentCommentId = parentCommentId == null ? commentId : parentCommentId;
        comment.articleId = articleId;
        comment.writerId = writerId;
        comment.delYn = false;
        comment.createdAt = LocalDateTime.now();

        return comment;
    }

    /**
     * 상위 댓글 여부 
     * @return
     */
    public Boolean isRoot() {
        return parentCommentId.longValue() == commentId;
    }

    /**
     * 댓글 삭제
     */
    public void delete() {
        delYn = true;
    }
}