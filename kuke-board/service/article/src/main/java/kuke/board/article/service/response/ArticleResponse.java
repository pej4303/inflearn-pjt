package kuke.board.article.service.response;

import kuke.board.article.entity.Article;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@ToString
public class ArticleResponse {
    private Long articleId;  // 게시글ID
    private String title;  // 제목
    private String content;  // 내용
    private Long boardId;  // 게시판ID (Shard Key)
    private Long writerId;  // 작성자ID
    private LocalDateTime createdAt;  // 생성시간
    private LocalDateTime modifiedAt;  // 수정시간

    public static ArticleResponse from(Article article) {
        /**
         * ArticleResponse 객체를 만들기 위해 직접 생성자를 호출하지 않고 정적 메서드를 통해 생성하고 필요한 값을 초기화하는 역할을 한다.
         * 이처럼 new ArticleResponse() 대신 ArticleResponse.from()으로 생성하도록 만드는 것이 팩토리 메서드 패턴이라고 한다.
         */
        ArticleResponse articleResponse = new ArticleResponse();
        articleResponse.articleId = article.getArticleId();
        articleResponse.title = article.getTitle();
        articleResponse.content = article.getContent();
        articleResponse.boardId = article.getBoardId();
        articleResponse.writerId = article.getWriterId();
        articleResponse.createdAt = article.getCreatedAt();
        articleResponse.modifiedAt = article.getModifiedAt();

        return articleResponse;
    }
}
