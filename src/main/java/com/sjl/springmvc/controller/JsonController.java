package com.sjl.springmvc.controller;

import com.sjl.springmvc.domain.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/list")
    @ResponseBody
    public Object getList() {
        List<UserBean> list = new ArrayList<UserBean>();
        list.add(new UserBean("123", "123"));
        list.add(new UserBean("456", "456"));
        return list;
    }
}
