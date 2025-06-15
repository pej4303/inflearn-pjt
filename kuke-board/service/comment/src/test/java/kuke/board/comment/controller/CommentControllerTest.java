package kuke.board.comment.controller;

import kuke.board.comment.service.response.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

@Slf4j
class CommentControllerTest {
    String URL = "http://localhost:9001";

    String URI = "/v1/comment/{commentId}";
    String POST_URI = "/v1/comment/";

    RestClient restClient = RestClient.create(URL);

    @Test
    @DisplayName("댓글 생성 - 상위 댓글 1개, 하위 댓글 2개")
    void test1() {
        CommentResponse response1 = createComment(new CommentCreateRequest(1L, "댓글1", null, 1L));
        CommentResponse response2 = createComment(new CommentCreateRequest(1L, "댓글2", response1.getCommentId(), 1L));
        CommentResponse response3 = createComment(new CommentCreateRequest(1L, "댓글3", response1.getCommentId(), 1L));

        log.info("response1.getCommentId : {}", response1.getCommentId());
        log.info("response2.getCommentId : {}", response2.getCommentId());
        log.info("response3.getCommentId : {}", response3.getCommentId());

//        response1.getCommentId : 191436803121643520
//        response2.getCommentId : 191436805382373376
//        response3.getCommentId : 191436805453676544
    }

    @Test
    @DisplayName("댓글 조회 - 생성 후 조회해야한다.")
    void test2() {
        CommentResponse response =
                restClient.get()
                          .uri(URI, 191472437325869065L)
                          .retrieve()
                          .body(CommentResponse.class);

        log.info("response : {}", response.toString());
    }

    @Test
    @DisplayName("댓글 삭제 - case 하위 댓글이 있는 경우 삭제 표시만 변경되어야 함")
    void test3() {
        /**
         * CommentId : 191436803121643520 → 테스트 대상
         *  └ CommentId : 191436805382373376
         *  └ CommentId : 191436805453676544
         */

        /**
         *  case 하위 댓글이 있는 경우 삭제 표시만 변경되어야 함
         *  case 하위 댓글이 없는 경우 실제로 delete가 되어야 함
         */
        ResponseEntity<Void> response = restClient.delete()
                .uri(URI, 191436803121643520L)
                .retrieve()
                .toBodilessEntity();

        log.info("응답 코드: {}", response.getStatusCode());
    }

    @Test
    @DisplayName("댓글 삭제 - case 하위 댓글이 없는 경우 실제로 delete가 되어야 함")
    void test4() {
        /**
         * CommentId : 191436803121643520
         *  └ CommentId : 191436805382373376 → 테스트 대상
         *  └ CommentId : 191436805453676544
         */

        /**
         *  case 하위 댓글이 있는 경우 삭제 표시만 변경되어야 함
         *  case 하위 댓글이 없는 경우 실제로 delete가 되어야 함
         */
        ResponseEntity<Void> response = restClient.delete()
                .uri(URI, 191436805453676544L)
                .retrieve()
                .toBodilessEntity();    // 바디가 없는 응답을 처리할 때 이렇게 해야 된다. 이게 실제 호출임!!!

        log.info("응답 코드: {}", response.getStatusCode());
    }

    private CommentResponse createComment(CommentCreateRequest request) {
        return restClient.post()
                         .uri(POST_URI)
                         .body(request)
                         .retrieve()
                         .body(CommentResponse.class);
    }

    @Getter
    @AllArgsConstructor
    public static class CommentCreateRequest {
        private Long articleId;
        private String content;
        private Long parentCommentId;
        private Long writerId;
    }
}