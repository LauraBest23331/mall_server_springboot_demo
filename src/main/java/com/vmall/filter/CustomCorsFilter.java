package com.vmall.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Component
public class CustomCorsFilter extends CorsFilter{

    public CustomCorsFilter(CorsConfigurationSource configSource) {
        super(configSource);
    }

    @Bean
        public CorsFilter corsFilter() {
            //1.添加CORS配置信息
            CorsConfiguration config =new CorsConfiguration();
            //放行哪些原始域
            config.addAllowedOrigin("*");
            //是否发送Cookie信息
            config.setAllowCredentials(true);
            //放行哪些原始域(请求方式)
            config.addAllowedMethod("*");
            //放行哪些原始域(头部信息
            config.addAllowedHeader("*");
            //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
            config.addExposedHeader("*");

            //2.添加映射路
            UrlBasedCorsConfigurationSource configSource =new UrlBasedCorsConfigurationSource();
            configSource.registerCorsConfiguration("/**", config);

            //3.返回新的CorsFilter.
            return new CorsFilter(configSource);
        }

}
