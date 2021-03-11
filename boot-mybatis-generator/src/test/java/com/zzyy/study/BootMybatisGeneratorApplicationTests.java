package com.zzyy.study;

import com.zzyy.study.entities.User;
import com.zzyy.study.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BootMybatisGeneratorApplicationTests
{

    @Test
    void contextLoads()
    {
    }

    @Test
    void test1()
    {
        System.out.println(Math.random());
        System.out.println(Math.random() * 9);
        System.out.println(Math.random() * 9 + 1);
        System.out.println((Math.random() * 9 + 1) * 100000);
        System.out.println((int) ((Math.random() * 9 + 1) * 100000));
    }

}
