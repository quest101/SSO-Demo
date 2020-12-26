package com.mock;

import com.sso.client.plugin.filter.CommonAuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ServletComponentScan
@ComponentScan({"com.mock","com.sso.client.plugin"})
public class SSOClientApplication2 {

    public static void main(String[] args) {

        SpringApplication.run(SSOClientApplication2.class, args);
    }

    /**
     * 把第三方的过滤器包装成一个Spring的Bean
     * @return
     */
    @Bean
    public FilterRegistrationBean thirdFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new CommonAuthFilter());
        bean.setName("commonAuthFilter");
        bean.addUrlPatterns("/index");
        bean.addInitParameter("ssoServerPath","http://127.0.0.1:9003");//设置init参数
        bean.setOrder(0);
        return bean;
    }
}
