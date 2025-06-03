package kuke.board.article.controller;

import kuke.board.article.service.ArticleService;
import kuke.board.article.service.request.ArticleCreateRequest;
import kuke.board.article.service.request.ArticleUpdateRequest;
import kuke.board.article.service.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    /**
     * 게시글 조회
     * @param articleId
     * @return
     */
   @GetMapping("/v1/article/{articleId}")
   public ArticleResponse search(@PathVariable Long articleId) {
       /**
        * Q. @PathVariable ?
        * A. URL 경로에 포함된 값을 메서드의 파라미터로 전달받을 때 사용하는 어노테이션이다.
        *    예를 들어 "/v1/article/123" 요청 시  {articleId}에 해당하는 123이 Long 타입 articleId 변수에 매핑된다.
        *    → RESTful 방식에서 자원 식별자를 명확히 표현하는 데 적합하다.
        */
        return articleService.search(articleId);
    }

    /**
     * 게시글 등록
     * @param request
     * @return
     */
    @PostMapping("/v1/article/")
    public ArticleResponse add(@RequestBody ArticleCreateRequest request) {
       return articleService.add(request);
    }

    /**
     * 게시글 수정
     * @param articleId
     * @param request
     * @return
     */
    @PutMapping("/v1/article/{articleId}")
    public ArticleResponse modifiy(@PathVariable Long articleId, @RequestBody ArticleUpdateRequest request) {
        return articleService.modifiy(articleId, request);
    }

    /**
     * 게시글 삭제
     * @param articleId
     */
    @DeleteMapping("/v1/article/{articleId}")
    public void remove(@PathVariable Long articleId) {
        articleService.remove(articleId);
    }
}
