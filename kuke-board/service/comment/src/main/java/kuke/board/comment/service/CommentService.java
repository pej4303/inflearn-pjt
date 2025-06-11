package kuke.board.comment.service;

import kuke.board.comment.entity.Comment;
import kuke.board.comment.service.request.CommentCreateRequest;
import kuke.board.comment.service.response.CommentResponse;
import org.springframework.transaction.annotation.Transactional;
import kuke.board.comment.repository.CommentRepository;
import kuke.board.common.snowflake.Snowflake;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.function.Predicate.not;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final Snowflake snowflake = new Snowflake(); // 유니크 ID 생성기 (트위터 Snowflake 알고리즘 기반)

    /**
     * 게시글 조회
     * @param commentId
     * @return
     */
    public CommentResponse search(Long commentId) {
        return CommentResponse.from(commentRepository.findById(commentId).orElseThrow());
    }

    /**
     * 댓글 생성
     * @param request
     * @return
     */
    @Transactional
    public CommentResponse add(CommentCreateRequest request) {
        // 상위 댓글 찾기
        Comment parent = findParent(request);

        Comment comment = commentRepository.save(
                Comment.create(
                        snowflake.nextId(),                    // 댓글 ID (고유 ID 생성)
                        request.getContent(),                 // 내용
                        parent == null ? null : parent.getCommentId(),         // 상위 댓글 ID
                        request.getArticleId(),               // 게시글 ID
                        request.getWriterId()                 // 작성자 ID
                )
        );

        // 엔티티 객체 → 응답 DTO로 변환 (서비스 외부에 내부 구현 정보 노출 방지)
        return CommentResponse.from(comment);
    }

    @Transactional
    public void remove(Long commentId) {
        // 하위 댓글이 있으면 삭제 할 수 없음
        commentRepository.findById(commentId)
                // 삭제 안 된 경우만
                .filter(not(Comment::isDelYn))
                .ifPresent(comment -> {
                    if (hasChildren(comment)) {
                        comment.delete();
                    } else {
                        remove(comment);
                    }
                });
    }

    /**
     * 하위 댓글이 삭제 되었으면 상위 댓글도 삭제를 재귀적으로 해줘야 함
     * @param comment
     */
    private void remove(Comment comment) {
        commentRepository.delete(comment);

        // 루트가 아니라면 상위 댓글이 존재 할 수 있음
        if (!comment.isRoot()) {
            // 상위 댓글 찾기
            commentRepository.findById(comment.getParentCommentId())
                    .filter(Comment::isDelYn)  // 삭제 되어있는지
                    .filter(not(this::hasChildren)) // 자식이 없어야 함
                    .ifPresent(this::remove);
        }
    }

    /**
     * 자식 댓글이 있는지 확인
     * @param comment
     * @return
     */
    private boolean hasChildren(Comment comment) {
        // 최대 2뎁스라고 가정
        return commentRepository.countBy(comment.getArticleId(), comment.getCommentId(), 2L) == 2;
    }

    /**
     * 상위 댓글 찾기
     * @param request
     * @return
     */
    private Comment findParent(CommentCreateRequest request) {
        Long parentCommentId = request.getParentCommentId();

        if (parentCommentId == null) {
            return null;
        } else {
            // 현재 댓글은 2뎁스만 작성 가능하기 때문에
            return commentRepository.findById(parentCommentId)
                    .filter(not(Comment::isDelYn)) // 삭제 안 된 경우만
                    .filter(Comment::isRoot)        // 루트 댓글인 경우만
                    .orElseThrow();
        }
    }
}

