package com.htzg.unittest.service;

import com.htzg.unittest.entity.User;
import com.htzg.unittest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

/**
 * ClassName QueryExampleImpl
 * Description TODO
 *
 * @Date 2019/1/30 13:27
 * Version 1.0
 */
@Service
public class QueryExampleImpl implements QueryExample{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryByTime(LocalDateTime localDateTime) {
        //获取到本月是当年的第几个月（1~12）
        long monthOfYear = localDateTime.getMonth().getLong(ChronoField.MONTH_OF_YEAR);
        //前三个月
        List<User> result;
        if(monthOfYear <= 3){
            result = userMapper.getAllUsers("user_A");
        }else if(monthOfYear <= 6){
            result = userMapper.getAllUsers("user_B");
        }else if(monthOfYear <= 9){
            result = userMapper.getAllUsers("user_C");
        }else {
            result = userMapper.getAllUsers("user_D");
        }
        return result;
    }

    @Override
    public List<User> queryByTime(String tableName) {
        List<User> result = userMapper.getAllUsers(tableName);
        return result;
    }

    public static String convertTimeToTableName(LocalDateTime localDateTime){
        long monthOfYear = localDateTime.getMonth().getLong(ChronoField.MONTH_OF_YEAR);
        if(monthOfYear <= 3){
            return "user_A";
        }else if(monthOfYear <= 6){
            return "user_B";
        }else if(monthOfYear <= 9){
            return "user_C";
        }else{
            return "user_D";
        }
    }
}
