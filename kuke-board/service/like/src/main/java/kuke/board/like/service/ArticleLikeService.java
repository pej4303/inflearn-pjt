package kuke.board.like.service;


import kuke.board.common.snowflake.Snowflake;
import kuke.board.like.entity.ArticleLike;
import kuke.board.like.repository.ArticleLikeRepository;
import kuke.board.like.service.response.ArticleLikeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleLikeService {
   private final ArticleLikeRepository articleLikeRepository;
   private final Snowflake snowflake = new Snowflake();

    /**
     * 좋아요 조회
     * @param articleId
     * @param userId
     * @return
     */
    public ArticleLikeResponse search(Long articleId, Long userId) {
        return ArticleLikeResponse.from(articleLikeRepository.findByArticleIdAndUserId(articleId, userId).orElseThrow());
    }

    /**
     * 좋아요 처리
     * @param articleId
     * @param userId
     * @return
     */
    @Transactional
    public void like(Long articleId, Long userId) {
        articleLikeRepository.save(
            ArticleLike.create(
                snowflake.nextId(),       // 좋아요 ID (고유 ID 생성)
                articleId,                // 게시글 ID
                userId                    // 작성자 ID
            )
        );
    }

    /**
     * 좋아요 취소 처리
     * @param articleId
     * @param userId
     * @return
     */
    @Transactional
    public void unlike(Long articleId, Long userId) {
        // 먼저 데이터를 조회해서 있으면 좋아요 삭제 처리
        articleLikeRepository.findByArticleIdAndUserId(articleId, userId)
                .ifPresent(articleLikeRepository::delete);
        
    }

}
