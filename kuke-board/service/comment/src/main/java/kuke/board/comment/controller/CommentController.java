package kuke.board.comment.controller;

import kuke.board.comment.service.CommentService;
import kuke.board.comment.service.request.CommentCreateRequest;
import kuke.board.comment.service.response.CommentPageResponse;
import kuke.board.comment.service.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    /**
     * 댓글 조회
     * @param commentId
     * @return
     */
    @GetMapping("/v1/comment/{commentId}")
    public CommentResponse search(@PathVariable Long commentId) {
        return commentService.search(commentId);
    }

    /**
     * 댓글 페이징 조회
     *
     * @param articleId  게시글 ID
     * @param page     조회할 페이지 번호 (0부터 시작)
     * @param pageSize 한 페이지에 조회할 댓글 수
     * @return         댓글 목록과 페이징 정보가 포함된 응답 객체
     */
    @GetMapping("/v1/comment")
    public CommentPageResponse searchAll(@RequestParam("articleId") Long articleId,
                                         @RequestParam("page") Long page,
                                         @RequestParam("pageSize") Long pageSize) {
        return commentService.searchAll(articleId, page, pageSize);
    }

    /**
     * 댓글 페이징 조회 - 무한 스크롤 방식
     *
     * @param articleId  게시글 ID
     * @param pageSize 한 페이지에 조회할 댓글 수
     * @param lastParentCommentId  최근 조회된 상위댓글ID
     * @param lastCommentId  최근 조회된 댓글ID
     * @return         댓글 목록과 페이징 정보가 포함된 응답 객체
     */
    @GetMapping("/v1/comment/scroll")
    public List<CommentResponse> searchAllScroll(@RequestParam("articleId") Long articleId,
                                                 @RequestParam("pageSize") Long pageSize,
                                                 @RequestParam(value = "lastParentCommentId", required = false) Long lastParentCommentId,
                                                 @RequestParam(value = "lastCommentId", required = false) Long lastCommentId) {
        return commentService.searchAllScroll(articleId, pageSize, lastParentCommentId, lastCommentId);
    }

    /**
     * 댓글 등록
     * @param request
     * @return
     */
    @PostMapping("/v1/comment/")
    public CommentResponse add(@RequestBody CommentCreateRequest request) {
        return commentService.add(request);
    }

    /**
     * 댓글 삭제
     * @param commentId
     */
    @DeleteMapping("/v1/comment/{commentId}")
    public void remove(@PathVariable("commentId") Long commentId) {
        commentService.remove(commentId);
    }
}
