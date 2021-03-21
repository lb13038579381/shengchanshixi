package com.csq.config;

import com.csq.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvnConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(new LoginInterceptor());
        ir.addPathPatterns("/**");
        ir.excludePathPatterns("/loginController/login", "/js/**", "/css/**", "/font/**", "/fonts/**", "/images/**", "/public/error/**", "/static/**", "/system/**", "/templates/**");
    }
    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
}
