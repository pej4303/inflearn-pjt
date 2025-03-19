package com.pej.portfolio_pej.admin.inertceptor

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


/**
 * @Configuration : Spring 설정 클래스임을 표시한다.
 */
@Configuration
class AdminInterceptorConfiguration(
    // AdminInterceptor를 주입받음
    private val adminInterceptor: AdminInterceptor
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(adminInterceptor) // 인터셉터 등록
            .addPathPatterns("/admin/**")        // "/admin/**" 경로 요청만 가로챔
            .excludePathPatterns("/assets/**", "/css/**" , "/js/**", "h2**")
    }
}
