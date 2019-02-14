package com.htzg.unittest.mapper;

import com.htzg.unittest.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<User> getAllUsers(String tableName);

    List<User> getUserById(String tableName, String id);

}
