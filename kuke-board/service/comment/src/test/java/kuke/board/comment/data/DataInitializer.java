package kuke.board.comment.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kuke.board.comment.entity.Comment;
import kuke.board.common.snowflake.Snowflake;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@SpringBootTest
@TestPropertySource(properties = "jasypt.encryptor.password=1q2w3e4r")
class DataInitializer {
    @PersistenceContext
    EntityManager entityManager;  // JPA 엔티티 매니저

    @Autowired
    TransactionTemplate transactionTemplate;  // 트랜잭션 관리용 템플릿

    Snowflake snowflake = new Snowflake();  // 고유 ID 생성기 (Snowflake 알고리즘)
    CountDownLatch latch = new CountDownLatch(EXCUTE_CNT); // 실행 완료 동기화용 카운트다운 렌치

    static final int BULK_SIZE = 2000;    // 한 트랜잭션에 저장할 데이터 개수
    static final int EXCUTE_CNT = 6000;   // 전체 작업 개수 (스레드에서 수행할 작업 수)

    @Test
    void initalize() throws Exception {
        // 멀티스레드로 수행될 예정
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
            Comment prev = null;

            for (int i=0; i<BULK_SIZE; i++) {
                Comment comment = Comment.create(
                         snowflake.nextId() // 댓글 ID
                        ,"content" + i  // 내용
                        , (i % 2 == 0) ? null : prev.getParentCommentId()   // 상위 댓글 ID
                        , (i % 2 == 0) ? 1L : 2L    // 게시글 ID
                        , (i % 2 == 0) ? 1L : 2L    // 작성자 ID
                );

                prev = comment;

                entityManager.persist(comment);
            }
        });
    }
}