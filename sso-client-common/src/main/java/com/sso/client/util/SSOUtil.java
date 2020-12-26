package com.sso.client.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SSOUtil {

    public static String systemId;

    public static String secretKey;

    public static String ssoServerPath;

    @Value("${sso.server.url}")
    public void setSsoServerPath(String ssoServerPath) {
        SSOUtil.ssoServerPath=ssoServerPath;
    }

    public static String getSsoServerPath() {
        return ssoServerPath;
    }

    @Value("${app.system.id}")
    public void setSystemId(String systemId) {
        SSOUtil.systemId=systemId;
    }

    @Value("${app.service.secretkey}")
    public void setSecretKey(String secretKey) {
        SSOUtil.secretKey=secretKey;
    }

    public static String getApp() {
        return systemId+":"+secretKey;
    }
}
