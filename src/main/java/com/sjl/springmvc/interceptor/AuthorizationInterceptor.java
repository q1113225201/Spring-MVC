package com.sjl.springmvc.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日至拦截器
 */
public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final String TAG = "AuthorizationInterceptor";
    private static final Log log = LogFactory.getLog(AuthorizationInterceptor.class);

    /**
     * 返回false表示请求结束，后续Interceptor和Controller都不会执行
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            log.error("token == null");
            return false;
        } else {
            log.error("token != null");
            return true;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.error("postHandle");

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.error("afterCompletion");

    }
}
