package com.sso.client.plugin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Value("${sso.server.url}")
    String ssoServerPath;

    @RequestMapping("/hello3")
    public String hello() {
        log.info("ssoServerPath :{}", ssoServerPath);
        return "hello,app3";
    }
}
