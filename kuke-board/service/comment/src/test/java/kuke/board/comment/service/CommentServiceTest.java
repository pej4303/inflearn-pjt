package kuke.board.comment.service;

import kuke.board.comment.entity.Comment;
import kuke.board.comment.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * CommentService의 단위 테스트 클래스입니다.
 * Mockito를 활용하여 CommentRepository를 mocking하고,
 * CommentService의 로직을 검증합니다.
 */
@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    // 테스트 대상 클래스
    @InjectMocks
    CommentService commentService;

    // 의존성으로 주입될 Repository (Mock 객체)
    @Mock
    CommentRepository commentRepository;

    @Test
    void test2() {
        System.out.println("나오니");
    }

    @Test
    @DisplayName("삭제할 댓글이 자식이 있으면, 삭제 표시만 한다")
    void test1() {
        // given: 테스트에 필요한 데이터 및 Mock 설정
        Long articleId = 1L;
        Long commentId = 2L;

        // Mock Comment 객체 생성
        Comment comment = createComment(articleId, commentId);

        // commentRepository가 commentId로 댓글을 조회했을 때, 해당 comment를 반환하도록 설정
        given(commentRepository.findById(commentId)).willReturn(Optional.of(comment));

        // 해당 댓글에 자식 댓글이 2개 있다고 가정
        given(commentRepository.countBy(articleId, commentId, 2L)).willReturn(2L);

        // when: 실제 서비스 메서드 호출
        commentService.remove(commentId);

        // then: 댓글이 delete() 메서드를 호출했는지 확인 (삭제 표시)
        verify(comment).delete();
    }

    /**
     * Comment 테스트 데이터를 생성합니다.
     * Mockito의 mock()을 이용해 가짜 Comment 객체를 만들고,
     * articleId와 commentId에 대한 getter 동작을 설정합니다.
     *
     * @param articleId 게시글 ID
     * @param commentId 댓글 ID
     * @return Mock Comment 객체
     */
    private Comment createComment(Long articleId, Long commentId) {
        Comment comment = mock(Comment.class);
        given(comment.getArticleId()).willReturn(articleId);
        given(comment.getCommentId()).willReturn(commentId);
        return comment;
    }

    /**
     * 부모 댓글 ID를 포함한 Comment 테스트 데이터를 생성합니다.
     *
     * @param articleId       게시글 ID
     * @param commentId       댓글 ID
     * @param parentCommentId 부모 댓글 ID
     * @return Mock Comment 객체
     */
    private Comment createComment(Long articleId, Long commentId, Long parentCommentId) {
        Comment comment = mock(Comment.class);
        given(comment.getParentCommentId()).willReturn(parentCommentId);
        return comment;
    }
}