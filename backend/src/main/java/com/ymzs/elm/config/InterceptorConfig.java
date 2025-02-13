package com.ymzs.elm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ymzs.elm.interceptor.AuthInterceptor;
import com.ymzs.elm.interceptor.LoggingInterceptor;

/**
 * 拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor()).addPathPatterns("/**");

        // 排除登录接口/login /register
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login", "/user/register",
                        "/business/**",
                        // 静态资源
                        "/", "/css/**", "/js/**", "/img/**", "/json/**", "/fonts/**", "/*.html");

    }
}
