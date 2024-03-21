package com.example.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;


import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/judgeLogin","/login.html","/user/login","/index.html","/index","/css/**","/js/**","/img/**","/fonts/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }
    /*
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

        argumentResolvers.add(new JsonParameterBinder());
    }
    */

    /**
     *  使用 FastJsonHttpMessageConverter 来替换 Spring MVC 默认的 HttpMessageConverter
     *  以提高 @RestController @ResponseBody @RequestBody 注解的 JSON序列化和反序列化速度。
     * */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1.转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        converter.setFastJsonConfig(new FastJsonConfig());
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        converters.add(0, converter);
    }
    // Set to allow cross-domain
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .maxAge(3600);
    }
}
