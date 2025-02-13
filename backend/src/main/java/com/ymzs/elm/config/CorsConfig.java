package com.ymzs.elm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有的当前站点的请求地址，都支持跨域访问。
                .allowedOriginPatterns("*") // 所有的外部域都可跨域访问。可以限制访问来源站点
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD") // 当前站点支持的跨域请求类型是什么
                .allowCredentials(true) // 是否支持跨域用户凭证
                .maxAge(3600) // 超时时长设置为1小时。 时间单位是秒。
                .allowedHeaders("*"); // 当前站点支持的跨域请求头
    }

}
