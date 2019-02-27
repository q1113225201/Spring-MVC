package com.sjl.springmvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeController implements Controller {
    private static final Log log = LogFactory.getLog(WelcomeController.class);

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        log.info("handleRequest:" + httpServletRequest.getRequestURI());
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", "index");
        return modelAndView;
    }
}
