package com.pej.portfolio_pej.admin.inertceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

@Component
class AdminInterceptor: HandlerInterceptor {
    // HandlerInterceptor :  Spring MVC에서 요청을 가로채는 인터페이스
    // AdminInterceptor는 HandlerInterceptor를 구현(상속) 했기 때문에 HTTP 요청이 컨트롤러에 도달하기 전에 추가 로직을 수행할 수 있다.
    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        super.postHandle(request, response, handler, modelAndView)
    }
}