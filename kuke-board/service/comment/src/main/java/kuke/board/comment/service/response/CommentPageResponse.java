package kuke.board.comment.service.response;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CommentPageResponse {
    private List<CommentResponse> pageList;
    private Long pageCount;

    public static CommentPageResponse of(List<CommentResponse> pageList, Long pageCount) {
        CommentPageResponse response = new CommentPageResponse();
        response.pageList = pageList;
        response.pageCount = pageCount;
        return response;
    }
}
