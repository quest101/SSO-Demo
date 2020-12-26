package com.mock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello,app1";
    }

    @RequestMapping("/index")
    public String index(@RequestParam(name = "ssoUser") String ssoUser) {
        log.info("ssoUser :{}", ssoUser);
        return "hello, "+ssoUser;
    }
}
