package com.zzyy.study.service;

import com.zzyy.study.entities.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @auther zzyy
 * @create 2021-02-16 16:06
 */
public interface UserService
{
    public int add(User user);
    public int del();
    public int update(User user);


    public User getById(@Param("id") Integer id);

    public List<User> getByCondition(User user);

    public List<User> getSplitPage(User user);

    public List<User> getSplitPageExample(User user);

}
