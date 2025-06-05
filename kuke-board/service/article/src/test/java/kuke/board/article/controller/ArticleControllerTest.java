package kuke.board.article.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kuke.board.article.entity.Article;
import kuke.board.article.service.ArticleService;
import kuke.board.article.service.request.ArticleCreateRequest;
import kuke.board.article.service.request.ArticleUpdateRequest;
import kuke.board.article.service.response.ArticlePageResponse;
import kuke.board.article.service.response.ArticleResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.web.client.RestClient;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@Slf4j
@SpringBootTest  // 스프링 컨테이너를 로딩하여 통합 테스트를 수행
@AutoConfigureMockMvc  // MockMvc를 자동으로 설정해준다. 웹 계층 테스트 시 사용
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;  // MockMvc: 실제 서블릿 컨테이너 없이 MVC 테스트 수행용 객체

    @MockitoBean
    private ArticleService articleService;  // ArticleService를 Mockito로 Mock 처리 (실제 호출 안함)

    @Autowired
    private ObjectMapper objectMapper;  // JSON 변환용 (객체 <-> JSON)

    RestClient restClient = RestClient.create("http://localhost:9000");

    @Test
    @DisplayName("게시글 조회 테스트")
    void search() throws Exception {
        Long articleId = 1L;
        // 테스트용 게시글 엔티티 생성
        Article article = Article.create(articleId, "제목1", "내용1", 1L, 1L);
        // 응답 DTO 생성
        ArticleResponse mockResponse = ArticleResponse.from(article);

        // articleService.search(articleId) 호출 시 mockResponse 반환하도록 Mock 설정
        given(articleService.search(articleId)).willReturn(mockResponse);

        // GET /v1/article/{articleId} 요청을 모의 수행
        mockMvc.perform(get("/v1/article/{articleId}", articleId))
                .andDo(print())  // 요청과 응답 로그 출력
                .andExpect(status().isOk())  // HTTP 200 OK 기대
                .andExpect(jsonPath("$.title").value("제목1"))  // 응답 JSON에서 title 값 검증
                .andExpect(jsonPath("$.content").value("내용1")); // 응답 JSON에서 content 값 검증
    }

    @Test
    @DisplayName("게시글 페이징 조회 테스트")
    void searchAll()  {
        ArticlePageResponse response = restClient.get()
                .uri("/v1/article?boardId=1&pageSize=30&page=1")
                .retrieve()
                .body(ArticlePageResponse.class);

        log.info("getArticleCount = {}", response.getArticleCount());

    }

    @Test
    @DisplayName("게시글 페이징 조회 테스트 - 무한 스크롤")
    void searchAllScroll()  {
         List<ArticleResponse> response = restClient.get()
                .uri("/v1/article/scroll?boardId=1&pageSize=5")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ArticleResponse>>() {
                });

         log.info("첫번째 페이지 = {}", response.getLast().getArticleId());

         Long lastId = response.getLast().getArticleId();

         List<ArticleResponse> response2 = restClient.get()
                .uri("/v1/article/scroll?boardId=1&pageSize=5&lastArticleId=%s".formatted(lastId))
                .retrieve()
                .body(new ParameterizedTypeReference<List<ArticleResponse>>() {
                });
         response2.stream().forEach(i -> log.info("getArticleId = {}", i.getArticleId()));
    }

    @Test
    @DisplayName("게시글 등록 테스트")
    void add() throws Exception {
        ArticleCreateRequest request = new ArticleCreateRequest("제목1", "내용1", 1L, 1L);

        Article article = Article.create(1L, "제목1", "내용1", 1L, 1L);
        ArticleResponse mockResponse = ArticleResponse.from(article);

        // any()를 사용하면 파라미터에 상관없이 호출되면 무조건 mockResponse 반환하게 된다.
        given(articleService.add(any(ArticleCreateRequest.class))).willReturn(mockResponse);

        mockMvc.perform(post("/v1/article/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.title").value("제목1"))
                        .andExpect(jsonPath("$.content").value("내용1"));
    }

    @Test
    @DisplayName("게시글 수정 테스트")
    void modify() throws Exception {
        Long articleId = 1L;
        ArticleUpdateRequest request = new ArticleUpdateRequest("수정된 제목", "수정된 내용");

        Article article = Article.create(articleId, "수정된 제목", "수정된 내용", 1L, 1L);
        ArticleResponse mockResponse = ArticleResponse.from(article);

        given(articleService.modifiy(eq(articleId), any(ArticleUpdateRequest.class))).willReturn(mockResponse);

        mockMvc.perform(put("/v1/article/{articleId}", articleId)
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(request)))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.title").value("수정된 제목"))
               .andExpect(jsonPath("$.content").value("수정된 내용"));
    }

    @Test
    @DisplayName("게시글 삭제 테스트")
    void remove() throws Exception {
        Long articleId = 1L;

        willDoNothing().given(articleService).remove(articleId);

        mockMvc.perform(delete("/v1/article/{articleId}", articleId))
               .andExpect(status().isOk());
    }
}