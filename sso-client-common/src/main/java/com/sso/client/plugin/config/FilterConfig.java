package com.sso.client.plugin.config;

import com.sso.client.plugin.filter.CommonAuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class FilterConfig /*extends WebMvcConfigurerAdapter*/ {

    /*@Bean
    public FilterRegistrationBean commonAuthFilterRegistration()    {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CommonAuthFilter());
        registration.addUrlPatterns("/index");
        return registration;
    }*/
}
