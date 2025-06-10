package kuke.board.comment.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
//@AllArgsConstructor
public class CommentCreateRequest {
    private Long articleId;   // 게시글 ID
    private String content;  // 내용
    private Long parentCommentId;   // 상위 댓글 ID
    private Long writerId;   // 작성자ID
}
