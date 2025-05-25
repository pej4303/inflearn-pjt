package kuke.board.article.service.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ArticleCreateRequest {
    private String title;    // 제목
    private String content;  // 내용
    private Long boardId;    // 게시판ID (Shard Key)
    private Long writerId;   // 작성자ID
}
