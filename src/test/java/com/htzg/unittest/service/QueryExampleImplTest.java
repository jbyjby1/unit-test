package com.htzg.unittest.service;

import com.htzg.unittest.entity.User;
import com.htzg.unittest.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("单元测试实例讲解")
class QueryExampleImplTest {

    @Autowired
    private QueryExample queryExample;

    @MockBean
    private UserMapper userMapper;

    @DisplayName("测试时间")
    @Test
    void queryByTimeTest() {
        //准备一个list，用于模拟当传入表名user_A的时候的返回值
        List<User> tableAData = new ArrayList<>();
        User tableAUser = new User();
        tableAUser.setUserName("aaaaa");
        tableAUser.setUserUuid(UUID.randomUUID().toString());
        tableAUser.setPhoneNumber("15600286858");
        tableAData.add(tableAUser);
        //设定：userMapper的getAllUsers方法，当传入"user_A"表的时候，返回tableAData
        when(userMapper.getAllUsers("user_A")).thenReturn(tableAData);
        //实际测试，传入2018年1月1日，正常情况下，应当从user_A表取出数据
        List<User> result = queryExample.queryByTime(LocalDateTime.parse("2018-01-01T00:00:00"));
        //对结果进行断言判定
        //得到的result不应该是null
        assertNotNull(result);
        //得到的result应该大小为1
        assertEquals(1, result.size());
        //得到的result的内容应该是用户"aaaaa",电话号码是15600286858
        User resultUser = result.get(0);
        assertEquals("aaaaa", resultUser.getUserName());
        assertEquals("15600286858", resultUser.getPhoneNumber());
    }

    @DisplayName("使用调用判断测试，1月1日")
    @Test
    void queryByTimeTest2() {
        //实际测试，传入2018年1月1日，正常情况下，应当从user_A表取出数据
        queryExample.queryByTime(LocalDateTime.parse("2018-01-01T00:00:00"));
        //验证是否userMapper类的getAllUsers被调用，并且参数是"user_A"
        verify(userMapper).getAllUsers("user_A");
    }

    @DisplayName("使用调用判断测试，5月1日")
    @Test
    void queryByTimeTest3() {
        //实际测试，传入2018年5月1日，正常情况下，应当从user_B表取出数据
        queryExample.queryByTime(LocalDateTime.parse("2018-05-01T00:00:00"));
        //验证是否userMapper类的getAllUsers被调用，并且参数是"user_B"
        verify(userMapper).getAllUsers("user_B");
    }

    @DisplayName("使用调用判断测试，9月10日")
    @Test
    void queryByTimeTest4() {
        //实际测试，传入2018年9月10日，正常情况下，应当从user_C表取出数据
        queryExample.queryByTime(LocalDateTime.parse("2018-09-10T00:00:00"));
        //验证是否userMapper类的getAllUsers被调用，并且参数是"user_C"
        verify(userMapper).getAllUsers("user_C");
    }

    @DisplayName("使用调用判断测试，11月30日")
    @Test
    void queryByTimeTest5() {
        //实际测试，传入2018年9月1日，正常情况下，应当从user_D表取出数据
        queryExample.queryByTime(LocalDateTime.parse("2018-11-30T00:00:00"));
        //验证是否userMapper类的getAllUsers被调用，并且参数是"user_D"
        verify(userMapper).getAllUsers("user_D");
    }
}