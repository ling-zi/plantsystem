package com.em248.dao;

import com.em248.model.User;

import java.util.List;

public interface InUser {
		//添加用户
		boolean adduser(User user);
		//修改用户
		boolean updateuser(User user);
		//删除用户（通过用户id删除）
		boolean deleteuser(int uid);
		//通过名字查询用户
		List<User> getUserbyname(String uname);
		//查询用户(通过用户登录邮箱和密码查询)
		User getuserbynameandpwd(String uname, String password);
		//查询所有用户信息
		List<User> getAll();
		//分页查询
		//List<User> getAllUserbyPages(Pages page);
}
