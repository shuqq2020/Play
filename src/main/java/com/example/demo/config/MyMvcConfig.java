package com.example.demo.config;

import com.example.demo.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/search").setViewName("search");
        registry.addViewController("/sort").setViewName("sort");
        registry.addViewController("/comment").setViewName("comment");
        registry.addViewController("/admin/admin_login").setViewName("admin/admin_login");
        registry.addViewController("/admin/admin_index").setViewName("admin/admin_index");
    }

    @Override
    public  void addInterceptors(InterceptorRegistry registry) {
        //SpringBoot已经做好了静态资源映射
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/",
                        "/login",
                        "/login.html",
                        "/user/login",
                        "/register.html",
                        "/register",
                        "/user/register",
                        "/admin/admin_login",
                        "/admin_index" ,
                        "/resources/favicon.ico",
                        "/asserts/css/**");
    }


}
