package kuke.board.comment.service.response;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CommentPageResponse {
    private List<CommentResponse> articles;
    private Long articleCount;

    public static CommentPageResponse of(List<CommentResponse> articles, Long articleCount) {
        CommentPageResponse response = new CommentPageResponse();
        response.articles = articles;
        response.articleCount = articleCount;
        return response;
    }
}
