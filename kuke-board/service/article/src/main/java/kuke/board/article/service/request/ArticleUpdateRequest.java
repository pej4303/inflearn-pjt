package kuke.board.article.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor // 테스트할때는 주석 풀어야함
public class ArticleUpdateRequest {
    private String title;    // 제목
    private String content;  // 내용
}
