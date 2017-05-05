package com.em248.dao;

import com.em248.model.Usercomments;

import java.util.List;


public interface Incomment {
	// 添加评论
	boolean addPermission(Usercomments pms);

	// 删除评论
	boolean deletePermission(Usercomments pms);

	// 查询评论(通过名字)
	Usercomments queryPermission(String pmsname);

	// 按照ID查询
	Usercomments queryPermission(int pmsid);

	// 查询全部
	public List<Usercomments> getAllPermission();
	// 查询多条分页
	// 查询多条分页
}
