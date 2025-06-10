package kuke.board.comment.service.response;

import kuke.board.comment.entity.Comment;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@ToString
public class CommentResponse {
    private Long commentId;             // 댓글ID
    private String content;             // 내용
    private Long articleId;             // 게시글ID
    private Long parentCommentId;       // 상위 댓글 ID
    private Long writerId;              // 작성자ID
    private String delYn = "N";         // 삭제여부
    private LocalDateTime createdAt;    // 생성시간
    private LocalDateTime modifiedAt;   // 수정시간

    public static CommentResponse from(Comment comment) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.commentId = comment.getCommentId();
        commentResponse.content = comment.getContent();
        commentResponse.parentCommentId = comment.getParentCommentId();
        commentResponse.articleId = comment.getArticleId();
        commentResponse.writerId = comment.getWriterId();
        commentResponse.delYn = comment.getDelYn();
        commentResponse.createdAt = comment.getCreatedAt();
        commentResponse.modifiedAt = comment.getModifiedAt();

        return commentResponse;
    }
}
