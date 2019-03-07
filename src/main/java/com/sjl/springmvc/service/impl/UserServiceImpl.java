package com.sjl.springmvc.service.impl;

import com.sjl.springmvc.dao.TbUserMapper;
import com.sjl.springmvc.model.TbUser;
import com.sjl.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    TbUserMapper userMapper;

    public TbUser getUser(Integer id) {
        return null;
    }

    public int addUser(TbUser tbUser) {
        return userMapper.insert(tbUser);
    }

    public int updateUser(TbUser tbUser) {
        return 0;
    }

    public int deleteUser(Integer id) {
        return 0;
    }

    public List<TbUser> getUsers() {
        return userMapper.selectByExample(null);
    }
}
