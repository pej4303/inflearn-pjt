package kuke.board.like.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class ArticleLikeControllerTest {
    String restUrl = "http://localhost:9002";

    RestClient restClient = RestClient.create(restUrl);

    @Test
    void search() {
    }

    @Test
    @DisplayName("좋아요 기능 테스트")
    void like() {
        // given
        String url = "/v1/article-like/articles/{articleId}/users/{userId}";
        Long articleId = 9999L;
        Long userId = 1L;

        // when
        var responseSpec = restClient.post()
                                     .uri(url, articleId, userId)
                                     .retrieve();
        // then
        var response = responseSpec.toBodilessEntity();
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }

    @Test
    @DisplayName("좋아요 취소 기능 테스트")
    void unlike() {
        // given
        String url = "/v1/article-like/articles/{articleId}/users/{userId}";
        Long articleId = 9999L;
        Long userId = 1L;

        // when
        var responseSpec = restClient.delete()
                .uri(url, articleId, userId)
                .retrieve();
        // then
        var response = responseSpec.toBodilessEntity();
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }
}