package kuke.board.article.repository;

import kuke.board.article.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Q. @Slf4j란?
 * A. Lombok 라이브러리에 있으며 클래스 내부에 log라는 이름의 Logger 객체를 자동 생성해준다.
 *   로그 찍을 때 Logger logger = LoggerFactory.getLogger(클래스명.class); 이런 코드 안 써도 된다.
 */
@Slf4j
@SpringBootTest
class ArticleRepositoryTest {
    @Autowired
    ArticleRepository articleRepository;

    @Test
    @DisplayName("페이징 건수 테스트")
    void findAllTest() {
        List<Article> list = articleRepository.findAll(1L, 1499970L, 30L);
        log.info("size = {}", list.size());

        list.forEach(i -> log.info("article = {}", i));
    }

    @Test
    @DisplayName("페이징 건수 조회 테스트")
    void countTest() {
        // 1번 게시판에서 10000건만 조회
        Long cnt = articleRepository.count(1L, 10000L);
        log.info("cnt = {}", cnt);
    }

    @Test
    @DisplayName("무한 스크롤 테스트")
    void findAllScrollTest() {
        List<Article> initList = articleRepository.findAllInitScroll(1L, 30L);
        log.info("getArticleId = {}", initList.getLast().getArticleId());

        Long lastId = initList.getLast().getArticleId();
        List<Article> scrollList = articleRepository.findAllScroll(1L, 30L, lastId);
        scrollList.forEach(i -> log.info("item = {}", i.getArticleId()));
    }
}