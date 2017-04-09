package com.bslota.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by bslota on 2017-03-14.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("regular/home");
        registry.addViewController("/regular/home").setViewName("regular/home");
        registry.addViewController("/special/home").setViewName("special/home");
        registry.addViewController("/regular/login").setViewName("regular/login");
        registry.addViewController("/special/login").setViewName("special/login");
    }
}
