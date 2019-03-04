package com.sjl.springmvc.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 日至拦截器
 */
public class LogInterceptor implements HandlerInterceptor {
    private static final String TAG = "LogInterceptor";
    private static final Log log = LogFactory.getLog(LogInterceptor.class);

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("preHandle\nurl:").append(httpServletRequest.getRequestURI());
        stringBuilder.append("\nmethod:").append(httpServletRequest.getMethod());
        stringBuilder.append("\nparams:");
        Enumeration<String> names = httpServletRequest.getParameterNames();
        while (names.hasMoreElements()) {
            String key = names.nextElement();
            stringBuilder.append(key).append("=").append(httpServletRequest.getParameter(key));
        }
        log.error(stringBuilder.toString());
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.error("postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.error("afterCompletion");
    }
}
