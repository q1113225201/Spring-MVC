package com.sjl.springmvc.controller;

import com.sjl.springmvc.domain.UserBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 控制器
 */
@Controller
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUsers(HttpServletRequest httpServletRequest, Model model) {
        logger.info("handleRequest:" + httpServletRequest.getRequestURI());
        //添加模型数据
        model.addAttribute("name", "tom");
        model.addAttribute("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        return "user";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        //添加模型数据
        return "user";
    }

    /**
     * 先于所有请求
     * @param username
     * @param password
     * @param model
     */
    @ModelAttribute
    public void userModel(String username,String password,Model model){
        logger.info("userModel:"+username+","+password);
        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        model.addAttribute("user",userBean);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
    }

    @RequestMapping(value = "/user/login", method = {RequestMethod.POST,RequestMethod.GET})
    public String login(Model model) {
        UserBean userBean = (UserBean) model.asMap().get("user");
        userBean.setPassword("******");
        if("1".equalsIgnoreCase(userBean.getUsername())) {
            //添加模型数据
            return "user";
        }else {
            //添加模型数据
            return "index";
        }
    }

}
