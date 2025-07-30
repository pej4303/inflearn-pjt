package kuke.board.like.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ARTICLE_LIKE")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleLike {
    @Id
    @Column(name = "ARTICLE_LIKE_ID")
    private Long articleLikeId;
    @Column(name = "ARTICLE_ID")
    private Long articleId; // 샤드키
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    // 팩토리 메서드
    public static ArticleLike create(Long articleLikeId, Long articleId, Long userId) {
        ArticleLike articleLike = new ArticleLike();
        articleLike.articleLikeId = articleLikeId;
        articleLike.articleId = articleId;
        articleLike.userId = userId;
        articleLike.createdAt = LocalDateTime.now();
        return articleLike;
    }
}
