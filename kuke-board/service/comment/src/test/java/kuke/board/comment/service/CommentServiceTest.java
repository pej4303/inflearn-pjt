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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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
    @DisplayName("삭제할 댓글이 자식이 있으면, 삭제 표시만 한다")
    void test1() {
        // given: 테스트에 필요한 데이터 및 Mock 설정
        Long articleId = 1L;
        Long commentId = 2L;

        // Mock Comment 객체 생성
        Comment comment = createComment(articleId, commentId);

        // commentRepository가 commentId로 댓글을 조회했을 때, 해당 comment를 반환하도록 설정
        /**
         * Q. Optional.of()를 왜 사용하지?
         * A. findById()의 반환 타입이 Optional<Comment>이므로 Mock Comment 객체를 넘겨줄 때도 Optional로 감싸야 한다.
         */
        given(commentRepository.findById(commentId)).willReturn(Optional.of(comment));

        // 해당 댓글에 자식 댓글이 2개 있다고 가정
        given(commentRepository.countBy(articleId, commentId, 2L)).willReturn(2L);

        // when: 실제 서비스 메서드 호출
        commentService.remove(commentId);

        // then: 댓글이 delete() 메서드를 호출했는지 확인 (삭제 표시)
        // comment 객체의 delete() 메서드가 실제로 호출되었는지 확인 아니면 테스트 실패!
        verify(comment).delete();
    }

    @Test
    @DisplayName("하위 댓글이 삭제되고, 삭제되지 않은 부모면, 하위 댓글만 삭제한다.")
    void test2() {
        // given: 테스트에 필요한 데이터 및 Mock 설정
        Long articleId = 1L;
        Long commentId = 2L;
        Long parentCommentId = 1L;

        // Mock Comment 객체 생성
        Comment comment = createComment(articleId, commentId, parentCommentId);
        given(comment.isRoot()).willReturn(false);
        // Mock 상위 Comment 객체 생성
        Comment parentComment = mock(Comment.class);
        given(parentComment.isDelYn()).willReturn(false);

        // Mock Comment 객체
        given(commentRepository.findById(commentId)).willReturn(Optional.of(comment));
        given(commentRepository.countBy(articleId, commentId, 2L)).willReturn(1L);
        // Mock 상위 Comment 객체
        given(commentRepository.findById(parentCommentId)).willReturn(Optional.of(parentComment));

        // when : 실제 서비스 메서드 호출
        commentService.remove(commentId);

        // then: 실제 서비스 메서드 호출했는지 확인
        verify(commentRepository).delete(comment);
        // 상위 댓글이 삭제 안 되었는지 확인
        verify(commentRepository, never()).delete(parentComment);
    }

    @Test
    @DisplayName("하위 댓글이 삭제되고, 삭제된 부모면, 재귀적으로 모두 삭제한다.")
    void test3() {
        // given: 테스트에 필요한 데이터 및 Mock 설정
        Long articleId = 1L;
        Long commentId = 2L;
        Long parentCommentId = 1L;

        // Mock Comment 객체 생성
        Comment comment = createComment(articleId, commentId, parentCommentId);
        given(comment.isRoot()).willReturn(false);

        // Mock 상위 Comment 객체 생성
        Comment parentComment = createComment(articleId, parentCommentId);
        given(parentComment.isRoot()).willReturn(true);
        // 삭제된 부모면
        given(parentComment.isDelYn()).willReturn(true);

        given(commentRepository.findById(commentId)).willReturn(Optional.of(comment));
        given(commentRepository.countBy(articleId, commentId, 2L)).willReturn(1L);

        // 상위 댓글이면
        given(commentRepository.findById(parentCommentId)).willReturn(Optional.of(parentComment));
        given(commentRepository.countBy(articleId, parentCommentId, 2L)).willReturn(1L);

        // when : 실제 서비스 메서드 호출
        commentService.remove(commentId);

        // then: 실제 서비스 메서드 호출했는지 확인
        verify(commentRepository).delete(comment);
        verify(commentRepository).delete(parentComment);
    }

    /**
     * Comment 테스트 데이터를 생성합니다.
     * Mockito의 mock()을 이용해 가짜 Comment 객체를 만들고,
     * articleId와 commentId에 대한 getter 동작을 설정합니다.
     *
     * → createComment()는 테스트에서 자주 사용하는 Mock Comment 객체 생성을 재사용 가능한 유틸 메서드로 분리한 것으로
     *   이런 방식은 실제 테스트 코드 작성 시 강력하게 추천되는 패턴이다.
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
        // Mock 객체는 실제 필드(setter를 통한 값 저장)를 사용하지 않고, getter 호출 시 어떤 값을 "리턴할지"만 설정해서 사용하는 방식
        Comment comment = mock(Comment.class); // 가짜 객체 생성
        given(comment.getArticleId()).willReturn(articleId); // articleId 리턴 설정
        given(comment.getCommentId()).willReturn(commentId); // commentId 리턴 설정
        given(comment.getParentCommentId()).willReturn(parentCommentId); // parentCommentId 리턴 설정
        return comment;
    }
}