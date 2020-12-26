package com.sso.client.plugin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties(prefix = "myconfig")
@PropertySource(value = "classpath:myconfig.proferties")
public class MyConfig {
    @Value("${test}")
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
