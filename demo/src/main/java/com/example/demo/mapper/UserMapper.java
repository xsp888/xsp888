package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.bean.User;

public interface UserMapper {

	public List<User> getAll();

	public User getOne(@Param("name") String name);

	public int insert(User user);

	public int update(User user);

	public int delete(@Param("name") String name);
	
	public int exists(User user);

}
