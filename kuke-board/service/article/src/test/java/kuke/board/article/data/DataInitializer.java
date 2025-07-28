package kuke.board.article.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kuke.board.article.entity.Article;
import kuke.board.article.service.ArticleService;
import kuke.board.article.service.request.ArticleCreateRequest;
import kuke.board.article.service.request.ArticleUpdateRequest;
import kuke.board.article.service.response.ArticleResponse;
import kuke.board.common.snowflake.Snowflake;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.support.TransactionTemplate;

import javax.swing.text.html.parser.Entity;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.mockito.ArgumentMatchers.any;

@Slf4j
@SpringBootTest
@TestPropertySource(properties = "jasypt.encryptor.password=1q2w3e4r")
class DataInitializer {
    @PersistenceContext
    EntityManager entityManager;  // JPA 엔티티 매니저

    @Autowired
    /**
     * TransactionTemplate
     * 사용 이유 : 트랜잭션 직접 제어DB 작업 묶어서 한번에 커밋할 때
     *            @Transactional 같은 어노테이션 없이도 프로그래밍적으로 트랜잭션을 시작하고 끝낼 수 있게 해준다.
     */
    TransactionTemplate transactionTemplate;  // 트랜잭션 관리용 템플릿

    Snowflake snowflake = new Snowflake();  // 고유 ID 생성기 (Snowflake 알고리즘)
    /**
     * CountDownLatch
     * 사용 이유 : 여러 스레드가 동시에 실행될 때 작업이 전부 완료됐는지 체크하고 기다리는 동기화 도구이다.
     */
    CountDownLatch latch = new CountDownLatch(EXCUTE_CNT); // 실행 완료 동기화용 카운트다운 렌치

    static final int BULK_SIZE = 2000;    // 한 트랜잭션에 저장할 데이터 개수
    static final int EXCUTE_CNT = 6000;   // 전체 작업 개수 (스레드에서 수행할 작업 수)

    @Test
    void initalize() throws Exception {
        // 멀티스레드로 수행될 예정
        /**
         * ExecutorService
         * 사용 이유 : 자바에서 멀티스레드를 편리하게 관리하고 실행하기 위한 도구이다.
         *            직접 Thread를 만들고 관리하는 것보다 훨씬 쉽고 스레드 제어에 유리하다.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);  // 스레드풀 10개 생성

        for (int i = 0; i < EXCUTE_CNT; i++) {
            executorService.submit(() -> {
                insert();           // 데이터 삽입 작업 수행
                latch.countDown();  // 작업 완료 후 카운트 감소
                log.info("## cnt = {}", latch.getCount());
            });
        }
        // 호출하면 카운트가 0이 될 때까지 기다린다. 모든 작업이 끝날 때까지 대기
        latch.await();
        executorService.shutdown();  // 스레드풀 종료
    }

    /**
     * 데이터 등록
     */
    void insert() {
        // transactionTemplate을 이용해서 데이터 등록
        // 트랜잭션이 종료될때 한번에 2000건 데이터가 삽입되게 된다.
        transactionTemplate.executeWithoutResult(status -> {
            for (int i=0; i<BULK_SIZE; i++) {
                Article article = Article.create(
                        snowflake.nextId(),  // 게시글 ID (고유 ID 생성)
                        "title" + i,         // 제목
                        "content" + i,       // 내용
                        1L,                  // 게시판 ID
                        1L                   // 작성자 ID
                );
                entityManager.persist(article);
            }
        });
    }
}