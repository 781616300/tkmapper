package com.zzyy.study.controller;

import com.zzyy.study.entities.User;
import com.zzyy.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @auther zzyy
 * @create 2021-02-16 16:04
 */
@RestController
@Slf4j
public class UserController
{
    @Resource
    private UserService userService;


    @RequestMapping("/user/add")
    public String add()
    {
        for (int i = 1; i <=10; i++)
        {
            User user = new User();
            user.setSex((byte)new Random().nextInt(2));
            user.setUsername("zzyy"+i);
            int sixpwd = (int) ((Math.random() * 9 + 1) * 100000);
            user.setPassword(sixpwd+"");

            userService.add(user);
        }
        return "------add user success";
    }

    @RequestMapping("/user/del")
    public String del()
    {
        userService.del();
        return "------del user success";
    }

    @RequestMapping("/user/{id}")
    public User get(@PathVariable("id") Integer id)
    {
        return userService.getById(id);
    }

    @RequestMapping("/user/condition")
    public List<User> getByCondition()
    {
        User user = new User();

        user.setSex((byte)1);
        user.setDeleted((byte)0);

        return userService.getByCondition(user);
    }

    @RequestMapping("/user/page")
    public List<User> getSplitPage()
    {
        User user = new User();
        user.setDeleted((byte)0);

        return userService.getSplitPage(user);
    }

    @RequestMapping("/user/pageex")
    public List<User> getSplitPageExample()
    {
        User user = new User();
        user.setUsername("zzyy");

        return userService.getSplitPageExample(user);
    }
}
