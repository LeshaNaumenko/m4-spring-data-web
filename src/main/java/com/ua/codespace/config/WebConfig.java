package com.ua.codespace.config;

import org.springframework.context.annotation.*;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.enterprise.context.Initialized;
import java.io.IOException;

@Configuration
@EnableWebMvc
@ComponentScan({"com.ua.codespace.web"})
@Import(RestConfig.class)
@EnableSpringDataWebSupport//allows spring to set pageable object in controller methods (http://localhost:8080/api/companies?page=2&size=2)
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();// configure static content handler
    }
}
