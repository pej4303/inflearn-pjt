package section08_map.test;

import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제2 - 브라우저 히스토리 관리
 *
 * - 문제 설명
 * BrowserHistoryTest와  실행 결과를 참고해서 BrowserHistory 클래스를 완성하자.
 * 브라우저의 방문 기록 관리 기능을 개발하자.
 * 다음 기능을 개발해야 한다.
 *
 * visitPage(): 특정 페이지 방문
 * goBack(): 뒤로가기
 *
 * 뒤로가기는 가장 나중에 넣은 데이터가 먼저 나온다.
 * 따라서 스택 구조를 고려하는 것이 좋다.
 *
 * - 실행 결과
 * 방문: youtube.com
 * 방문: google.com
 * 방문: facebook.com
 * 뒤로 가기: google.com
 * currentPage1 = google.com
 * 뒤로 가기: youtube.com
 * currentPage2 = youtube.com
 */
public class BrowserHistory {
    private Deque<String> browserStack = new ArrayDeque<>();

    public BrowserHistory() {

    }

    public void visitPage(String url) {
        browserStack.push(url);
        System.out.println("방문: " + url);
    }

    public String goBack() {
        String currentPage = browserStack.pop();
        System.out.println("뒤로 가기:  " + currentPage);
        return currentPage;
    }
}
