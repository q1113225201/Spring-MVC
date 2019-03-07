package com.sjl.springmvc.service;

import com.sjl.springmvc.model.TbUser;

import java.util.List;

public interface UserService {

    public TbUser getUser(Integer id);

    public int addUser(TbUser tbUser);

    public int updateUser(TbUser tbUser);

    public int deleteUser(Integer id);

    public List<TbUser> getUsers();
}
