package com.sjl.springmvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制器
 */
@Controller
public class AutoController {
    private static final Log logger = LogFactory.getLog(AutoController.class);

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String handlerRequestHello(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        logger.info("handleRequest:"+httpServletRequest.getRequestURI());
        return "/index.jsp";
    }
    @RequestMapping(value = "/auto",method = RequestMethod.GET)
    public ModelAndView handlerRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        logger.info("handleRequest:"+httpServletRequest.getRequestURI());
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("message", "auto");
        //设置逻辑视图名称
        modelAndView.setViewName("/auto.jsp");
        return modelAndView;
    }
}
