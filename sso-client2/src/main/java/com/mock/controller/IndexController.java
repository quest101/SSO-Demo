package com.mock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {

    //@Autowired
    //private  userAccessService;

    @RequestMapping("/hello2")
    public String hello() {
        //UserAccessServiceString userToken = userAccessService.getUserToken("aaa");
        //System.out.println("============"+userToken);
        return "hello,app2";
    }

    @RequestMapping("/index")
    public String index(@RequestParam(name = "ssoUser") String ssoUser) {
        log.info("ssoUser :{}", ssoUser);
        return "hello, "+ssoUser;
    }
}
