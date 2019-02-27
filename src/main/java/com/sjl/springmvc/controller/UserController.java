package com.sjl.springmvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 控制器
 */
@Controller
@RequestMapping(value = "/auto")
public class AutoController {
    private static final Log logger = LogFactory.getLog(AutoController.class);

    @RequestMapping(value = "/auto", method = RequestMethod.GET)
    public String auto(HttpServletRequest httpServletRequest, Model model) {
        logger.info("handleRequest:" + httpServletRequest.getRequestURI());
        //添加模型数据
        model.addAttribute("message", "auto");
        model.addAttribute("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        return "auto";
    }


}
