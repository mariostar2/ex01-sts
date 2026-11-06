package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.UserDto;

@Mapper
public interface UserDao {
	public UserDto Login(@Param("id")String id, @Param("pw")String pw);
	public int signUp(@Param("id")String id, @Param("pw")String pw, @Param("name")String name);
}
