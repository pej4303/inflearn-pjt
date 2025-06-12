package kuke.board.comment.controller;

import kuke.board.comment.service.CommentService;
import kuke.board.comment.service.request.CommentCreateRequest;
import kuke.board.comment.service.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
