package kuke.board.article.controller;

import kuke.board.article.service.ArticleService;
import kuke.board.article.service.request.ArticleCreateRequest;
import kuke.board.article.service.request.ArticleUpdateRequest;
import kuke.board.article.service.response.ArticlePageResponse;
import kuke.board.article.service.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 게시글 페이징 조회
     *
     * @param boardId  게시판 ID (조회할 게시판을 지정)
     * @param page     조회할 페이지 번호 (0부터 시작)
     * @param pageSize 한 페이지에 조회할 게시글 수
     * @return         게시글 목록과 페이징 정보가 포함된 응답 객체
     */
    @GetMapping("/v1/article")
    public ArticlePageResponse searchAll(@RequestParam("boardId") Long boardId,
                                         @RequestParam("page") Long page,
                                         @RequestParam("pageSize") Long pageSize) {
        return articleService.searchAll(boardId, page, pageSize);
    }

    /**
     * 게시글 페이징 조회 - 무한 스크롤 방식
     *
     * @param boardId  게시판 ID (조회할 게시판을 지정)
     * @param pageSize 한 페이지에 조회할 게시글 수
     * @param lastArticleId  최근 조회된 ArticleID
     * @return         게시글 목록과 페이징 정보가 포함된 응답 객체
     */
    @GetMapping("/v1/article/scroll")
    public List<ArticleResponse> searchAllScroll(@RequestParam("boardId") Long boardId,
                                                 @RequestParam("pageSize") Long pageSize,
                                                 @RequestParam(value = "lastArticleId", required = false) Long lastArticleId) {
        return articleService.searchAllScroll(boardId, pageSize, lastArticleId);
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
