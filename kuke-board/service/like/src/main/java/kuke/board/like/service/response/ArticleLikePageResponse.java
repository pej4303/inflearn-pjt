package kuke.board.like.service.response;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ArticleLikePageResponse {
    private List<ArticleLikeResponse> articles;
    private Long articleCount;

    public static ArticleLikePageResponse of(List<ArticleLikeResponse> articles, Long articleCount) {
        ArticleLikePageResponse response = new ArticleLikePageResponse();
        response.articles = articles;
        response.articleCount = articleCount;
        return response;
    }
}
