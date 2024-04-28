package com.example.laster.mapper;

import com.example.laster.dao.UserDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Insert("insert into userinfo(name,age,sex,skill) values (#{name},#{age},#{sex},#{skill})")
    public void insert(UserDao userDao);
}
