package com.htzg.unittest.service;

import com.htzg.unittest.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface QueryExample {

    List<User> queryByTime(LocalDateTime localDateTime);

    List<User> queryByTime(String tableName);
}
