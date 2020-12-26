package com.mock.filter;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

//@WebFilter(filterName = "testFilter", urlPatterns = "/test")
public class TestFilter /*implements Filter*/ {

    /*@Value("${sso.server.url}")
    private String ssoServerPath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("ssoServerPath = " + ssoServerPath);
    }

    @Override
    public void destroy() {

    }*/
}
