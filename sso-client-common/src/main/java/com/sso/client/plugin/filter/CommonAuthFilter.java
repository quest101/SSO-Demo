package com.sso.client.plugin.filter;

import com.sso.client.plugin.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SSO请求过滤处理
 */
//@Order(1)
@WebFilter(filterName = "commonAuthFilter", urlPatterns = "/index",
                initParams ={@WebInitParam(name ="EXCLUDED_PAGES", value = "/receiveToken,/ssoLogout,/ssoDeleteToken")})
public class CommonAuthFilter implements Filter {

    /*@Autowired
    private UserAccessService userAccessService;*/

    private WebApplicationContext wac;

    private String excludedPages;
    private String[] excludedPageArray;

    //@Value("${sso.server.url}")
    private String ssoServerPath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("==========init==========");
        //读取 WebInitParam 配置的 EXCLUDED_PAGES
        excludedPages = filterConfig.getInitParameter("EXCLUDED_PAGES");
        if(excludedPages!=null) {
            excludedPageArray = excludedPages.split(",");
        }
        ssoServerPath = filterConfig.getInitParameter("ssoServerPath");
        wac = (WebApplicationContext)filterConfig.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("==========doFilter==========");
        HttpServletRequest req = (HttpServletRequest) request;
        Object userName = req.getParameter("ssoUser");
        if(userName!=null
                && String.valueOf(userName).trim().length()>0
                /*&& userAccessService.getUserToken(String.valueOf(userName))!=null*/) {
            //WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
            UserAccessService userAccessService = (UserAccessService)
                    wac.getBean(UserAccessService.class);
            if(userAccessService.getUserToken(String.valueOf(userName))!=null){
                // 已经登录过，直接放行
                chain.doFilter(req, response);
                return;
            }
        }

        boolean containtFlag = false;
        //http://peer1:8088/sendToken?ssoToken=c2ce29be-5adb-4aaf-82cc-2ba24330176e&userName=6677
        if(excludedPageArray!=null) {
            for(String excludeStr : excludedPageArray) {
                if(excludeStr.equals(req.getServletPath())) {
                    containtFlag = true;
                    break;
                }
            }
        }
        if(containtFlag) {
            // 不拦截界面，直接放行
            chain.doFilter(req, response);
            return;
        }

        //其他情况都丢给SSO中心去处理
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String originalUrl = req.getRequestURL().toString();
        httpResponse.sendRedirect(ssoServerPath+"/index?originalUrl="+originalUrl+"&ssoUser="+userName);
        return;
    }

    @Override
    public void destroy() {
        System.out.println("==========destroy==========");
    }
}
