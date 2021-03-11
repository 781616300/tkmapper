package com.zzyy.study.service.impl;

import com.zzyy.study.entities.User;
import com.zzyy.study.mapper.UserMapper;
import com.zzyy.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther zzyy
 * @create 2021-02-16 16:07
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService
{
    @Resource
    private UserMapper userMapper;

    /**
     * 加2次insert后演示删除
     * @param user
     * @return
     */
    @Override
    public int add(User user)
    {
         return userMapper.insertSelective(user);
    }

    /**
     * delete from t_user where id >10 and id<=15;
     * @return
     */
    @Override
    public int del()
    {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andGreaterThan("id",10);
        criteria.andLessThanOrEqualTo("id",15);

        return userMapper.deleteByExample(example);
    }

    public int update(User user)
    {
        return 0;
    }

    @Override
    public User getById(Integer id)
    {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getByCondition(User user)
    {
        return userMapper.select(user);
    }

    @Override
    public List<User> getSplitPage(User user)
    {
        System.out.println("*****total records: "+userMapper.selectCount(user));

        return userMapper.selectByRowBounds(user, new RowBounds(0, 3));
    }

    @Override
    public List<User> getSplitPageExample(User user)
    {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("username",user.getUsername()+"%");


        return userMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 7));
    }
}