package kuke.board.like.controller;


import kuke.board.like.service.ArticleLikeService;
import kuke.board.like.service.response.ArticleLikeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleLikeController {
    private final ArticleLikeService articleLikeService;

    /**
     * 좋아요 조회
     * @param articleId
     * @param userId
     * @return
     */
    @GetMapping("/v1/article-like/articles/{articleId}/users/{userId}")
    public ArticleLikeResponse search(@PathVariable("articleId") Long articleId,
                                      @PathVariable("userId") Long userId) {
        return articleLikeService.search(articleId, userId);
    }

    /**
     * 좋아요 처리
     * @param articleId
     * @param userId
     */
    @PostMapping("/v1/article-like/articles/{articleId}/users/{userId}")
    public void like(@PathVariable("articleId") Long articleId,
                                      @PathVariable("userId") Long userId) {
        articleLikeService.like(articleId, userId);
    }

    /**
     * 좋아요 취소 처리
     * @param articleId
     * @param userId
     */
    @DeleteMapping("/v1/article-like/articles/{articleId}/users/{userId}")
    public void unlike(@PathVariable("articleId") Long articleId,
                     @PathVariable("userId") Long userId) {
        articleLikeService.unlike(articleId, userId);
    }


}
