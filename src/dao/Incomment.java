package dao;

import java.util.List;

import domain.Usercomments;

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
