package com.sjl.springmvc.controller;

import com.sjl.springmvc.domain.ResultDTO;
import com.sjl.springmvc.model.TbUser;
import com.sjl.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResultDTO<List<TbUser>> getUsers() {
        List<TbUser> users = userService.getUsers();
        return new ResultDTO<List<TbUser>>(users.size() > 0 ? 1 : 0, users, users.size() > 0 ? "获取成功" : "数据为空");
    }

    @ResponseBody
    @PostMapping(value = "/user")
    public ResultDTO<Integer> addUser(@RequestBody TbUser tbUser) {
        ResultDTO<Integer> resultDTO = new ResultDTO<Integer>();
        if (tbUser == null) {
            resultDTO.setCode(0);
            resultDTO.setMsg("添加数据为空");
            return resultDTO;
        }
        if (StringUtils.isEmpty(tbUser.getUsername())) {
            resultDTO.setCode(0);
            resultDTO.setMsg("昵称不能为空");
            return resultDTO;
        }
        if (StringUtils.isEmpty(tbUser.getPassword())) {
            resultDTO.setCode(0);
            resultDTO.setMsg("密码不能为空");
            return resultDTO;
        }
        int result = userService.addUser(tbUser);
        resultDTO.setCode(result > 0 ? 1 : 0);
        resultDTO.setMsg(result > 0 ? "添加成功" : "添加失败");
        resultDTO.setData(result);
        return resultDTO;
    }
}
