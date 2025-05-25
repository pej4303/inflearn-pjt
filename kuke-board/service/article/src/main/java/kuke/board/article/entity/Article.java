package kuke.board.article.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

/**
 * 게시글 엔티티 클래스
 * DB의 TB_ARTICLE 테이블과 매핑되며 게시글의 정보를 담는다.
 */
@Entity
@Table(name = "TB_ARTICLE")
@Getter   // 모든 필드의 getter 자동 생성 (불변 객체처럼 다루기 위함)
@ToString // 객체를 문자열로 표현할 때 필드 값을 자동으로 출력해주는 toString 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 스펙상 기본 생성자가 필요하지만, 외부에서 직접 생성하는 것을 막기 위해 protected 접근 제어자 사용
public class Article {
    @Id
    @Column(name = "ARTICLE_ID", nullable = false, precision = 19)
    @Comment("게시글ID")
    private Long articleId;  // 게시글ID

    @Column(name = "TITLE", length = 100, nullable = false)
    @Comment("제목")
    private String title;  // 제목

    @Column(name = "CONTENT", length = 3000)
    @Comment("내용")
    private String content;  // 내용

    @Column(name = "BOARD_ID", nullable = false, precision = 19)
    @Comment("게시판ID (Shard Key)")
    private Long boardId;  // 게시판ID (Shard Key)

    @Column(name = "WRITER_ID", nullable = false, precision = 19)
    @Comment("작성자ID")
    private Long writerId;  // 작성자ID

    @Column(name = "CREATED_AT", columnDefinition = "DATE DEFAULT SYSDATE")
    @Comment("생성시간")
    private LocalDateTime createdAt;  // 생성시간

    @Column(name = "MODIFIED_AT")
    @Comment("수정시간")
    private LocalDateTime modifiedAt;  // 수정시간


    /**
     * 게시글 생성
     * @param articleId
     * @param title
     * @param content
     * @param boardId
     * @param writerId
     * @return
     */
    public static Article create(Long articleId, String title, String content, Long boardId, Long writerId) {
        /**
         * 팩토리 메서드 패턴 : Article 객체 생성을 외부에서 new로 하지 않고 static 메서드를 통해 캡슐화하였다. → 코드의 의도가 명확해지고 생성 로직을 제어할 수 있다.
         */
        Article article = new Article(); // 기본 생성자 사용

        article.articleId = articleId;
        article.title = title;
        article.content = content;
        article.boardId = boardId;
        article.writerId = writerId;
        article.createdAt = LocalDateTime.now();
        article.modifiedAt = article.createdAt;

        return article;
    }

    /**
     * 게시글 수정
     * @param title
     * @param content
     */
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.modifiedAt = LocalDateTime.now();
    }
}